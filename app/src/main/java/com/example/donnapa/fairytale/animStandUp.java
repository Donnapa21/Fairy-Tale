package com.example.donnapa.fairytale;

import android.os.CountDownTimer;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Donnapa on 23-Feb-16.
 */
public class animStandUp {

    public animStandUp(final View v){

        new CountDownTimer(1000,50){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                YoYo.with(Techniques.StandUp).duration(3000).playOn(v);
            }
        }.start();
    }
}
