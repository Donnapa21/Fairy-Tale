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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.annotation.Target;

public class scene3_1 extends AppCompatActivity {
    Button btn_back, btn_next, btn_puase;
    ImageView ng1, malai, woman1;
    ImageView word31;
    Animation slide;

    //boolean
    boolean woman = false;
    boolean flat = false;
    //dialog
    AlertDialog.Builder builder;
    Dialog dialog;
    Button dialogset, dialogexit, dialoghome, dialogclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3_1);

        //word
        word31 = (ImageView) findViewById(R.id.word31);

        //  คลิกรจนา
        woman1 = (ImageView) findViewById(R.id.woman1);
        ((AnimationDrawable) woman1.getBackground()).start();
        woman1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (woman == false) {
                        ((AnimationDrawable) woman1.getBackground()).stop();
                        woman = true;
                        //change image view
                        woman1.setBackgroundResource(R.drawable.woman1);
                        word31.setVisibility(View.VISIBLE);
                    } else {
                        woman = false;
                        woman1.setBackgroundResource(R.drawable.animwoman1);
                        word31.setVisibility(View.INVISIBLE);
                        ((AnimationDrawable) woman1.getBackground()).start();
                    }
                } catch (Exception e) {
                }
            }
        });
        //  คลิกพวงมาลัย
        malai = (ImageView) findViewById(R.id.malai);
        ((AnimationDrawable) malai.getBackground()).start();
        malai.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         slide = AnimationUtils.loadAnimation(scene3_1.this, R.anim.movemalai);
                                         malai.startAnimation(slide);
                                         malai.setEnabled(false);//ปิดให้ปุ่มนี้ไม่ทำงาน
                                         malai.setBackgroundResource(R.drawable.malai2);
//                                         ((AnimationDrawable) malai.getBackground()).stop();
                                     }
                                 }
        );

        //กดเงาะ
        ng1 = (ImageView) findViewById(R.id.ng1);
        ((AnimationDrawable) ng1.getBackground()).start();
        ng1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    if (flat == false) {
//                        ((AnimationDrawable) ng1.getBackground()).stop();
//                        flat = true;
//                        //change image view
//                        ng1.setBackgroundResource(R.drawable.gold);
////                        gold.setVisibility(View.VISIBLE);
//                    } else {
//                        flat = false;
//                        ng1.setBackgroundResource(R.drawable.animred);
//                        gold.setVisibility(View.INVISIBLE);
//                        ((AnimationDrawable) ng1.getBackground()).start();
//                    }
//                } catch (Exception e) {
//                }
//            }
//        });

                try {
                    ((AnimationDrawable) ng1.getBackground()).stop();
                    //change image view
                    ng1.setBackgroundResource(R.drawable.gold);
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
                                    }
        );
        btn_next = (Button) findViewById(R.id.btn_next);
        final Intent a = new Intent(this, page3_21.class);
        btn_next.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View b) {
                                            startActivity(a);
                                        }
                                    }
        );
    }
}
