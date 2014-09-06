package com.example.spankingpeach.game.Task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.game.CalcTime;

/**
 * ゲーム中の制限時間を管理するタスク
 */
public class Timer extends Task {
    private CalcTime mCalcTime = new CalcTime();
    private Paint mPaint = new Paint();
    private final float FONTSIZE = 120;

    public Timer() {
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(FONTSIZE);

    }

    @Override
    public boolean onUpdate() {
        mCalcTime.calc();
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText(String.valueOf(mCalcTime.getNowTime()),700,300,mPaint);
    }
}
