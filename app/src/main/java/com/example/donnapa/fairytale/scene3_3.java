package com.example.donnapa.fairytale;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class scene3_3 extends AppCompatActivity {
    Button btn_back, btn_next;
    ImageView thaosamon1, prain1 ;
    ImageView word3_31, word3_32;
    boolean thaosamon = false;
    boolean prain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3_3);

        word3_31 = (ImageView)findViewById(R.id.word3_31);
        word3_32 = (ImageView)findViewById(R.id.word3_32);

        thaosamon1 = (ImageView)findViewById(R.id.thaosamon1);
        ((AnimationDrawable)thaosamon1.getBackground()).start();
        thaosamon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (thaosamon == false) {
                        ((AnimationDrawable) thaosamon1.getBackground()).stop();
                        thaosamon = true;
                        //change image view
                        thaosamon1.setBackgroundResource(R.drawable.thaosamon1);
                        word3_31.setVisibility(View.VISIBLE);
                    } else {
                        thaosamon = false;
                        thaosamon1.setBackgroundResource(R.drawable.animthaosamon);
                        word3_31.setVisibility(View.INVISIBLE);
                        ((AnimationDrawable) thaosamon1.getBackground()).start();
                    }

                } catch (Exception e) {
                }
            }
        });
        prain1 = (ImageView)findViewById(R.id.prain1);
        ((AnimationDrawable)prain1.getBackground()).start();
        prain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (prain == false) {
                        ((AnimationDrawable) prain1.getBackground()).stop();
                        prain = true;
                        //change image view
                        prain1.setBackgroundResource(R.drawable.prain1);
                        word3_32.setVisibility(View.VISIBLE);
                    } else {
                        prain = false;
                        prain1.setBackgroundResource(R.drawable.animprain);
                        word3_32.setVisibility(View.INVISIBLE);
                        ((AnimationDrawable) prain1.getBackground()).start();
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
        final Intent a = new Intent(this, page3_41.class);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                startActivity(a);
            }
        });
    }
}
