package com.example.spankingpeach.game.Task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.App;
import com.example.spankingpeach.game.State;

/**
 * Created by hiroki on 2014/09/06.
 */
public class DispState extends Task {
    private Paint mPaint = new Paint();
    private final int WIDTH = 100;
    private final int HEIGHT = 400;
    private boolean isDraw;
    private int counter;

    public DispState() {
        counter = 0;
        mPaint.setTextSize(60);
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
                if(isDraw) {
                    c.drawText("tap to start game", WIDTH, HEIGHT, mPaint);
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
