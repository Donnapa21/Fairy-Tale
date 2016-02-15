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

public class scene3_2 extends AppCompatActivity {
    Button btn_back, btn_next, btn_puase;
    ImageView sung1, meat1,fish, fish1;
    ImageView word3_21, word3_22;
    //boolean
    boolean sung = false;
    boolean meat = false;
    //dialog
    AlertDialog.Builder builder;
    Dialog dialog;
    Button dialogset, dialogexit, dialoghome, dialogclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3_2);

        //word
        word3_21 = (ImageView)findViewById(R.id.word3_21);
        word3_22 = (ImageView)findViewById(R.id.word3_22);

        //animfish
        fish = (ImageView)findViewById(R.id.animfish);
        ((AnimationDrawable)fish.getBackground()).start();
        fish1 = (ImageView)findViewById(R.id.animfish1);
        ((AnimationDrawable)fish1.getBackground()).start();
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
                        word3_21.setVisibility(View.VISIBLE);
                    } else {
                        sung = false;
                        sung1.setBackgroundResource(R.drawable.animsung1);
                        word3_21.setVisibility(View.INVISIBLE);
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
                        word3_22.setVisibility(View.VISIBLE);
                    } else {
                        meat = false;
                        meat1.setBackgroundResource(R.drawable.animmeat);
                        word3_22.setVisibility(View.INVISIBLE);
                        ((AnimationDrawable) meat1.getBackground()).start();
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
        final Intent a = new Intent(this, page3_3.class);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                startActivity(a);
            }
        });
    }
}
