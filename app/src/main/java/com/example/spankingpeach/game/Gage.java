package com.example.spankingpeach.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.R;

/**
 * Created by dev on 14/07/31.
 */
public class Gage extends Task{
    private float left;
    private float top;
    private float currentPos;
    private float dstPos;
    private float bottom;

    private Paint paint = new Paint();
    private Paint dstPaint = new Paint();
    private Bitmap bitmap;
    private long counter;
    public Gage(Resources res) {
        left = 30;
        top =280;
        bottom = 280+900;
        currentPos = bottom;
        dstPos = bottom;
        counter = 0;
        dstPaint.setColor(Color.BLUE);
        bitmap = BitmapFactory.decodeResource(res, R.drawable.gage);
    }

    @Override
    public void onTouch() {
       dstPos -= 30;
        counter = 0;

    }

    @Override
    public boolean onUpdate() {
        float offset = currentPos - dstPos;
        float inc = offset / (30 - counter);
        if(inc > 0) {
            currentPos -= inc;
        }
        if(currentPos <= 280){
            currentPos = 280;
        }
        counter++;
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,left,top,paint);
        c.drawRect(left, currentPos,left+100,bottom,dstPaint);
    }
}
