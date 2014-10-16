package com.example.spankingpeach.game.task;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by hiroki on 2014/10/12.
 */
public class ClearChar extends Task {
    private static ClearChar mInstance = new ClearChar();
    private Paint mPaint = new Paint();
    private final int WIDTH = 230;
    private final int HEIGT = 300;
    private boolean mIsTouched = false;

    private ClearChar(){
       mPaint.setColor(Color.BLACK);
       mPaint.setTextSize(60);
    }

    public void init(){
        mIsTouched = false;
    }
    public static ClearChar getInstance(){
        return mInstance;
    }

    @Override
    public void onTouch(float x, float y) {
        mIsTouched = true;
    }
    public boolean isTouched(){
        return mIsTouched;
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText("Clear",WIDTH,HEIGT,mPaint);
    }
}
