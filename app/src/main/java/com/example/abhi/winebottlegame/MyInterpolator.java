package com.example.abhi.winebottlegame;

import android.graphics.Interpolator;

/**
 * Created by Abhi on 03-03-2018.
 */



public class MyInterpolator extends Interpolator {
    public MyInterpolator(int no) {super(no);}
    public float getInterpolation(float t) {
        float x=2.0f*t-1.0f;
        return 0.5f*(x*x*x + 1.0f);
    }
}