package com.example.spankingpeach.game.Task;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;

import com.example.spankingpeach.App;
import com.example.spankingpeach.R;
import com.example.spankingpeach.game.CalcTime;

/**
 * ゲーム中の制限時間を管理するタスク
 */
public class Timer extends Task {
    private static Timer mInstance = new Timer();
    private Paint mPaint = new Paint();
    private final float WIDTH = 270;
    private final float HEIGHT = 150;
    private boolean mIsTimeUp;
    private Bitmap[] mBitmap = new Bitmap[10];
    private CalcTime mCalcTime = new CalcTime();

    public static Timer getInstance(){
        return mInstance;
    }

    private Timer() {
        Resources res = App.getContext().getResources();
        TypedArray numbers = res.obtainTypedArray(R.array.counter_num);
        for(int i = 0;i < mBitmap.length; i++){
            mBitmap[i] = ((BitmapDrawable) numbers.getDrawable(i)).getBitmap();
       }
        mIsTimeUp = false;
    }
    public boolean IsTimeUp(){
        return mIsTimeUp;
    }
    public void setStartTime(){
      mCalcTime.setStartTime();
    }

    @Override
    public boolean onUpdate() {
        mIsTimeUp = mCalcTime.calc();
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        int ones_time = (int)mCalcTime.getNowTime() % 10;
        int tens_time = (int)mCalcTime.getNowTime() / 10;
        c.drawBitmap(mBitmap[tens_time],WIDTH,HEIGHT,mPaint);
        c.drawBitmap(mBitmap[ones_time],WIDTH + 48,HEIGHT,mPaint);
    }
}
