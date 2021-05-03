package com.example.newsimprove;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class NewslistAdapter extends RecyclerView.Adapter<Newsviewholder> {
    private ArrayList<News> items=new ArrayList<>();
    private Newsitemclicked Listener;
    NewslistAdapter(Newsitemclicked listener){
        this.Listener=listener;
    }

    @NonNull
    @Override
    public Newsviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemnews,parent,false);
        Newsviewholder viewholder=new Newsviewholder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Listener.Onitemclicked(items.get(viewholder.getAdapterPosition()));
            }
        });
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Newsviewholder holder, int position) {
        News currentitem=items.get(position);
        holder.titleview.setText(currentitem.getTitle());
        holder.authorview.setText(currentitem.getAuthor());
        Glide.with(holder.itemView.getContext()).load(currentitem.getImageurl()).into(holder.imageView);
    }
    void updateitem(ArrayList<News> updateditem){
        items.clear();
        items.addAll(updateditem);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
class Newsviewholder extends RecyclerView.ViewHolder{
    TextView titleview;
    TextView authorview;
    ImageView imageView;

    public Newsviewholder(@NonNull View itemView) {
        super(itemView);
        titleview=itemView.findViewById(R.id.Title);
        authorview=itemView.findViewById(R.id.author);
        imageView=itemView.findViewById(R.id.imageview);
    }
}
interface Newsitemclicked{
    void Onitemclicked(News item);
}
