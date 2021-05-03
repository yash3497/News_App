package com.example.newsimprove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class categories extends AppCompatActivity implements Newsitemclicked {
    public RecyclerView recyclerview;
    public NewslistAdapter madapter;
    public ImageView i1,i2,i3;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        i1=findViewById(R.id.Home2);
        i2=findViewById(R.id.category2);
        i3=findViewById(R.id.information2);
        recyclerview=findViewById(R.id.recyclerView2);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        Intent intent=getIntent();
        String s=intent.getStringExtra("extra");
        Toast.makeText(this,s+"\nnews",Toast.LENGTH_SHORT).show();
        if(s.equals("science")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json";
            fetchdata();
        }else if(s.equals("tech")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json";
            fetchdata();
        }else if (s.equals("entertainment")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json";
            fetchdata();
        }else if(s.equals("sport")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json";
            fetchdata();
        }else if(s.equals("health")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json";
            fetchdata();
        }else if(s.equals("business")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json";
            fetchdata();
        }else if(s.equals("usa")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/general/us.json";
            fetchdata();
        }
        else if(s.equals("australia")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/general/au.json";
            fetchdata();
        }else if(s.equals("france")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/general/fr.json";
            fetchdata();
        }else if(s.equals("russia")){
            URL="https://saurav.tech/NewsAPI/top-headlines/category/general/ru.json";
            fetchdata();
        }
        madapter=new NewslistAdapter(this);
        recyclerview.setAdapter(madapter);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(home);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent category=new Intent(getApplicationContext(),Catelog.class);
                startActivity(category);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info=new Intent(getApplicationContext(),About.class);
                startActivity(info);
            }
        });
    }
    private  void fetchdata(){
        String url=URL;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray newsjsonarray=response.getJSONArray("articles");
                            ArrayList<News> newsArray=new ArrayList<>();
                            for(int i=0;i<newsjsonarray.length();i++){
                                JSONObject jsonObject=newsjsonarray.getJSONObject(i);
                                String title=jsonObject.getString("title");
                                String author=jsonObject.getString("author");
                                String url=jsonObject.getString("url");
                                String imageurl=jsonObject.getString("urlToImage");
                                newsArray.add(new News(title,author,url,imageurl));
                            }
                            madapter.updateitem(newsArray);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void Onitemclicked(News item) {
        Toast.makeText(this,"Open News",Toast.LENGTH_SHORT).show();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.getUrl()));
    }
}
