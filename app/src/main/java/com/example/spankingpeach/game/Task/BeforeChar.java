package com.example.spankingpeach.game.Task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 * Created by hiroki on 2014/09/06.
 */
public class BeforeChar extends Task {
    private static BeforeChar mInstance = new BeforeChar();
    private Paint mPaint = new Paint();
    private final int READY_WIDTH = 230;
    private final int READY_HEIGHT = 300;
    private final int TAP2START_WIDTH = 250;
    private final int TAP2START_HEIGHT = 400;
    private final int READY_FONTSIZE = 60;
    private final int TAP2START_FONTSIZE = 30;
    private boolean isDraw;
    private int counter;

    public static BeforeChar getIntance(){
        return mInstance;
    }
    private BeforeChar() {
        counter = 0;
        mPaint.setColor(Color.BLACK);
    }

    @Override
    public boolean onUpdate() {
        counter = ++counter % 60;
        if(counter <= 30 ){
            isDraw = true;
        }else{
            isDraw = false;
        }

        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        mPaint.setTextSize(READY_FONTSIZE);
        c.drawText("Ready", READY_WIDTH, READY_HEIGHT, mPaint);
        // 点滅
        if (isDraw) {
            mPaint.setTextSize(TAP2START_FONTSIZE);
            c.drawText("tapで開始", TAP2START_WIDTH, TAP2START_HEIGHT, mPaint);
        }
    }
}
