package com.example.abhi.winebottlegame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class main extends AppCompatActivity {

    static int total=0;
    static TextView t1, t2, t3;
    static int first, second, third;
    static int exitcode=0;
    Button b1;
    ImageView bottle;
    Boolean reset = false;
    Random r = new Random();
    int angle;
    static int counter = 0;
    RotateAnimation rotate;
    float factor = 9.47f;
    int arr[] = new int[]{30, 26, 9, 28, 0, 2, 14, 35, 23, 4, 16, 33, 21, 6, 18, 31, 19, 8, 12, 29, 25, 10, 27, 00, 1, 13, 36, 24, 3, 15, 34, 22, 5, 17, 32, 20, 7, 11};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        bottle = (ImageView) findViewById(R.id.bottle);
        t1 = (TextView) findViewById(R.id.firstno);
        t2 = (TextView) findViewById(R.id.secondno);
        t3 = (TextView) findViewById(R.id.thirdno);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reset) {
                    RotateAnimation rotate = new RotateAnimation(angle % 360, 360,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(500);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);
                    reset = false;
                    b1.setText("Go");
                } else {
                    angle = r.nextInt(3600) + 720;
                    RotateAnimation rotate = new RotateAnimation(0, angle, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(800);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                    bottle.startAnimation(rotate);


                    rotate.setAnimationListener(new Animation.AnimationListener(){
                        @Override
                        public void onAnimationStart(Animation arg0) {
                        }
                        @Override
                        public void onAnimationRepeat(Animation arg0) {
                        }
                        @Override
                        public void onAnimationEnd(Animation arg0) {
                            reset = true;
                            b1.setText("RESET");

                            getnumbers(360 - (angle % 360));

                        }
                    });





                }


            }
        });

    }







    public void getnumbers(int angle) {

        int number = 0;

        for (int i = 0; i < 38; i++) {

            if ((angle >= i * factor) && (angle < (i + 1) * factor)) {
                number = arr[i];
                break;
            }
        }

        switch (counter) {
            case 0: {
                first = number;
                t1.setText("" + first);

            }
            break;
            case 1: {
                second = number;
                t2.setText("" + second);
            }
            break;
            case 2: {
                third = number;

                t3.setText("" + third);



            }
            break;

        }
        counter++;

        if (counter == 3) {


            Intent i = new Intent(main.this, result.class);
                    startActivity(i);



        }
    }


}



