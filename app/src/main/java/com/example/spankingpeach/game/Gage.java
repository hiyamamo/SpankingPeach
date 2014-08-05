package com.example.spankingpeach.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.spankingpeach.R;

/**
 * Created by dev on 14/07/31.
 */
public class Gage extends Task{
    private static final float OUTER_POS_LEFT = 30;
    private static final float OUTER_POS_TOP = 280;
    private static final int INNER_LEFT = 50;
    private static final int INNER_TOP = 300;
    private int currentPos;
    private  int dstPos;

    private Paint paint = new Paint();
    private Bitmap outerBitmap;
    private Bitmap innerBitmap;
    private int counter;

    private int innerHeight;
    private int innerWidth;
    private Rect srcR;
    private Rect dstR;
    public Gage(Resources res) {
        counter = 0;
        outerBitmap = BitmapFactory.decodeResource(res, R.drawable.gage);
        innerBitmap = BitmapFactory.decodeResource(res, R.drawable.gage_innner);

        innerHeight = innerBitmap.getHeight();
        innerWidth = innerBitmap.getWidth();
        int outerw = outerBitmap.getWidth();
        int ounterh = outerBitmap.getHeight();
        currentPos = INNER_TOP+innerHeight;
        dstPos = currentPos;
        srcR = new Rect(0,0,innerWidth,innerHeight);
        dstR = new Rect(INNER_LEFT,currentPos,INNER_LEFT+innerWidth-20,INNER_TOP+innerHeight-20);
    }

    @Override
    public void onTouch() {
       dstPos -= 30;
        counter = 0;

    }

    @Override
    public boolean onUpdate() {
        int offset = currentPos - dstPos;
        if(counter >= 30){
            counter = 0;
        }
        int inc = offset / (30 - counter);
        if(inc > 0) {
            currentPos -= inc;
        }
        if(currentPos <= INNER_TOP){
            currentPos = INNER_TOP;
        }
        dstR.set(INNER_LEFT,currentPos,INNER_LEFT+innerWidth-20,INNER_TOP+innerHeight-20);
        counter++;
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(outerBitmap,OUTER_POS_LEFT,OUTER_POS_TOP,paint);
        c.drawBitmap(innerBitmap,srcR,dstR,paint);
    }
}
