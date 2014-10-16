package com.example.spankingpeach.game.task;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dev on 14/07/29.
 * FPSを表示
 */
public class FpsController extends Task{
    private static FpsController mInstance = new FpsController();
    private long startTime = 0;
    private int cnt = 0;
    private Paint paint = new Paint();
    private float fps;
    private final static int NUNBER = 60;
    private final static int FONT_SIZE = 20;
    public static FpsController getInstance(){
        return mInstance;
    }

    private FpsController() {
        paint.setColor(Color.BLUE);
        paint.setTextSize(FONT_SIZE);
    }

    @Override
    public boolean onUpdate() {
        if(cnt == 0){
            startTime = System.currentTimeMillis();
        }
        if(cnt == NUNBER){
            long t = System.currentTimeMillis();
            fps = 1000.f / ((t - startTime) / (float)NUNBER);
            cnt = 0;
            startTime = t;
        }
        cnt ++;
       return true;
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawText(String.format("%.1f",fps),0,FONT_SIZE-2,paint);
    }
}
