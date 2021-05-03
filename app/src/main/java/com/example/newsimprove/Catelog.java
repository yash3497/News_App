package com.example.newsimprove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Catelog extends AppCompatActivity {
    public CardView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catelog);
        c1 = findViewById(R.id.sciencenews);
        c2 = findViewById(R.id.technews);
        c3 = findViewById(R.id.entertainnews);
        c4 = findViewById(R.id.sportsnews);
        c5 = findViewById(R.id.healthnews);
        c6 = findViewById(R.id.businessnews);
        c7 = findViewById(R.id.usanews);
        c8 = findViewById(R.id.australianews);
        c9 = findViewById(R.id.francenews);
        c10 = findViewById(R.id.russianews);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "science";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "tech";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "entertainment";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "sport";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "health";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "business";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "usa";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "australia";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "france";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), categories.class);
                String s = "russia";
                intent.putExtra("extra", s);
                startActivity(intent);
            }
        });
    }
}