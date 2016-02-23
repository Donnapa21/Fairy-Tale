package com.example.donnapa.fairytale;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class scene3_3 extends AppCompatActivity {
    Button btn_back, btn_next,btn_puase;
    ImageView thaosamon1, prain1, bgSky, wall;
    ImageView word3_31, word3_32;
    //boolean
    boolean thaosamon = false;
    boolean prain = false;
    boolean flagThaosamon, flagPrain;
    animStandUp anim;
    //dialog
    AlertDialog.Builder builder;
    Dialog dialog;
    Button dialogset, dialogexit, dialoghome, dialogclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3_3);

        //bgSky
        bgSky = (ImageView) findViewById(R.id.imgSky);
        anim = new animStandUp(bgSky);

        //wall
        wall = (ImageView) findViewById(R.id.wall);
        anim = new animStandUp(wall);

        word3_31 = (ImageView)findViewById(R.id.word3_31);
        word3_32 = (ImageView)findViewById(R.id.word3_32);

        thaosamon1 = (ImageView)findViewById(R.id.thaosamon1);
        anim = new animStandUp(thaosamon1);
        ((AnimationDrawable)thaosamon1.getBackground()).start();
        thaosamon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagThaosamon = true;
                checkDown();
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
        anim = new animStandUp(prain1);
        ((AnimationDrawable)prain1.getBackground()).start();
        prain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagPrain = true;
                checkDown();
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
        //builder
        btn_puase = (Button) findViewById(R.id.btn_pause);
        builder = new AlertDialog.Builder(this);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        btn_puase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.btndialog);

                //TODO findViewBy
                dialogexit = (Button) dialog.findViewById(R.id.btn_exit);
                dialoghome = (Button) dialog.findViewById(R.id.btn_home);
                dialogset = (Button) dialog.findViewById(R.id.btn_setting);
                dialogclose = (Button) dialog.findViewById(R.id.btn_close);

                //button_exit
                dialogexit.setOnClickListener(new View.OnClickListener() {

                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(View v) {
                        finishAffinity();

                    }
                });

                //button_home
                dialoghome.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), map3.class);
                        startActivity(i);
                    }
                });

                //button_setting
                dialogset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                //button_close
                dialogclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
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
    public void checkDown(){
        if (flagThaosamon == true && flagPrain == true){
            btn_back.setVisibility(View.VISIBLE);
            btn_next.setVisibility(View.VISIBLE);
        }
    }
}
