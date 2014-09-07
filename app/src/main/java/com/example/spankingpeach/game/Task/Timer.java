package com.example.spankingpeach.game.Task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.game.CalcTime;

/**
 * ゲーム中の制限時間を管理するタスク
 */
public class Timer extends Task {
    private static Timer mInstance = new Timer();
    private CalcTime mCalcTime = new CalcTime();
    private Paint mPaint = new Paint();
    private final float FONTSIZE = 60;
    private final float WIDTH = 270;
    private final float HEIGHT = 150;
    private boolean mIsTimeUp;

    public static Timer getInstance(){
        return mInstance;
    }

    private Timer() {
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(FONTSIZE);
        mIsTimeUp = false;

    }
    public boolean IsTimeUp(){
        return mIsTimeUp;
    }

    @Override
    public boolean onUpdate() {
        mCalcTime.calc();
        if(mCalcTime.getNowTime() == 0) {
            mIsTimeUp = true;
        }else{
            mIsTimeUp = false;
        }
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText(String.valueOf(mCalcTime.getNowTime()),WIDTH,HEIGHT,mPaint);
    }
}
