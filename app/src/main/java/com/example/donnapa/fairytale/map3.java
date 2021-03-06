package com.example.donnapa.fairytale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class map3 extends AppCompatActivity {
    Button btn_back;
    ImageView mapsamon, mapfall, mapmalai, mapball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map3);

        btn_back = (Button) findViewById(R.id.btn_back);
//        final Intent n = new Intent(this ,home.class);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(n);
            }
        });
        //mapmalai
        mapmalai = (ImageView) findViewById(R.id.mapmalai);
        final Intent malai = new Intent(this, page3_11.class);
        mapmalai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(malai);
            }
        });

         //mapwaterfall
        mapfall = (ImageView)findViewById(R.id.mapfall);
        final Intent fall = new Intent(this, page3_21.class);
        mapfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fall);
            }
        });

        //mapsamon
        mapsamon = (ImageView) findViewById(R.id.mapsamon);
        final Intent samon = new Intent(this, page3_3.class);
        mapsamon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(samon);
            }
        });

        //mapball
        mapball = (ImageView) findViewById(R.id.mapball);
        final Intent ball = new Intent(this, page3_41.class);
        mapball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ball);
            }
        });

    }
}
