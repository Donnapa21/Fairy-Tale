package com.example.donnapa.fairytale;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class scene3_2 extends AppCompatActivity {
    Button btn_back, btn_next;
    ImageView sung1, meat1;
    ImageView word3_11, word3_12;
    boolean sung = false;
    boolean meat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3_2);

        //word
        word3_11 = (ImageView)findViewById(R.id.word3_11);
        word3_12 = (ImageView)findViewById(R.id.word3_12);

        //sung1
        sung1 = (ImageView)findViewById(R.id.sung1);
        ((AnimationDrawable)sung1.getBackground()).start();
        sung1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (sung == false) {
                        ((AnimationDrawable) sung1.getBackground()).stop();
                        sung = true;
                        //change image view
                        sung1.setBackgroundResource(R.drawable.sung1);
                        word3_11.setVisibility(View.VISIBLE);
                    } else {
                        sung = false;
                        sung1.setBackgroundResource(R.drawable.animsung1);
                        word3_11.setVisibility(View.INVISIBLE);
                        ((AnimationDrawable) sung1.getBackground()).start();
                    }

                } catch (Exception e) {
                }
            }
        });

        //meat
        meat1 = (ImageView)findViewById(R.id.meat1);
        ((AnimationDrawable)meat1.getBackground()).start();
        meat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (meat == false) {
                        ((AnimationDrawable) meat1.getBackground()).stop();
                        meat = true;
                        //change image view
                        meat1.setBackgroundResource(R.drawable.meat1);
                        word3_12.setVisibility(View.VISIBLE);
                    } else {
                        meat = false;
                        meat1.setBackgroundResource(R.drawable.animmeat);
                        word3_12.setVisibility(View.INVISIBLE);
                        ((AnimationDrawable) meat1.getBackground()).start();
                    }

                } catch (Exception e) {
                }
            }
        });

        //เปลี่ยนหน้า
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_next = (Button) findViewById(R.id.btn_next);
        final Intent a = new Intent(this, page3_3.class);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                startActivity(a);
            }
        });
    }
}
