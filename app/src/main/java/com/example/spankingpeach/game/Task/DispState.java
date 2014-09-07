package com.example.spankingpeach.game.Task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.game.State;

/**
 * Created by hiroki on 2014/09/06.
 */
public class DispState extends Task {
    private Paint mPaint = new Paint();
    private final int WIDTH = 150;
    private final int HEIGHT = 400;
    private final int READY_WIDTH = 230;
    private final int READY_HEIGHT = 300;
    private final int TAP2START_WIDTH = 250;
    private final int TAP2START_HEIGHT = 400;
    private final int READY_FONTSIZE = 60;
    private final int TAP2START_FONTSIZE = 30;
    private boolean isDraw;
    private int counter;

    public DispState() {
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
        switch(State.getState()){
            case State.BEFORE:
                mPaint.setTextSize(READY_FONTSIZE);
                c.drawText("Ready", READY_WIDTH, READY_HEIGHT, mPaint);
                // 点滅
                if(isDraw) {
                    mPaint.setTextSize(TAP2START_FONTSIZE);
                    c.drawText("tapで開始", TAP2START_WIDTH, TAP2START_HEIGHT, mPaint);
                }
                break;
            case State.GAME_OVER:
                c.drawText("finish",WIDTH,HEIGHT,mPaint);
                break;
            case State.PAUSE:
                c.drawText("pause",WIDTH,HEIGHT,mPaint);
                break;
        }
    }

    @Override
    public void onTouch() {
        super.onTouch();
    }
}
