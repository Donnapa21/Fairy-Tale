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
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class scene3_4 extends AppCompatActivity {
    Button btn_back, btn_next ,btn_puase;
    ImageView ball , horse;
    Animation slide;
    Dialog toy;
    int index = 0;
    int[] restoy = {R.drawable.kema,R.drawable.kala,R.drawable.kanklauy};
    //dialog
    AlertDialog.Builder builder;
    Dialog dialog;
    Button dialogset, dialogexit, dialoghome, dialogclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3_4);

        //ball
        ball = (ImageView)findViewById(R.id.ball);
        ((AnimationDrawable)ball.getBackground()).start();
        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide = AnimationUtils.loadAnimation(scene3_4.this, R.anim.moveball);
                ball.startAnimation(slide);
                ball.setEnabled(false);//ปิดให้ปุ่มนี้ไม่ทำงาน
//                ((AnimationDrawable) ball.getBackground()).stop();
                ball.setBackgroundResource(R.drawable.ball2);

            }
        });
        //horse
        horse = (ImageView)findViewById(R.id.prasung);
        horse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toy.show();
            }
        });

        toy = new Dialog(scene3_4.this);
        toy.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //dialog นำ layout chickenlayout มาแสดง
        toy.setContentView(R.layout.toylayout);
        //dialog ให้สามารถปิิดได้
        toy.setCancelable(true);
        //เปลี่ยนหน้า

        final Button btnBack = (Button) toy.findViewById(R.id.btnBack);
        final Button btnNext = (Button) toy.findViewById(R.id.btnNext);
        final ImageView kala = (ImageView) toy.findViewById(R.id.kala);
        final Button btnClose = (Button) toy.findViewById(R.id.btnClose);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == restoy.length - 1) {
                    kala.setImageResource(restoy[0]);
                    index = 0;

                } else {
                    kala.setImageResource(restoy[++index]);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 0) {
                    kala.setImageResource(restoy[restoy.length - 1]);
                    index = restoy.length - 1;
                } else {
                    kala.setImageResource(restoy[--index]);

                }
            }
        });
        //dialog เต็มหน้าจอ
        toy.getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toy.cancel();
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

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        btn_next = (Button) findViewById(R.id.btn_next);
//        final Intent a = new Intent(this, page3_11.class);
//        btn_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View b) {
//                startActivity(a);
//            }
//        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();

        ((AnimationDrawable) horse.getBackground()).stop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ((AnimationDrawable) horse.getBackground()).start();
    }
}
