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
    private float dstL;
    private float dstT;

    private Paint paint = new Paint();
    private Paint dstPaint = new Paint();
    private Bitmap bitmap;
    public Gage(Resources res) {
        left = 30;
        top =280;
        dstL = 30;
        dstT = 280+299;
        dstPaint.setColor(Color.BLUE);
        bitmap = BitmapFactory.decodeResource(res, R.drawable.gage);
    }

    @Override
    public void onTouch() {
        dstT -=30;

    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,left,top,paint);
        c.drawRect(dstL,dstT,dstL+35,280+299,dstPaint);
    }
}
