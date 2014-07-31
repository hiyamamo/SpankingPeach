package com.example.spankingpeach.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.spankingpeach.R;
import com.example.spankingpeach.listener.GameTouchListener;

/**
 * Created by dev on 14/07/29.
 */
public class Peach extends Task{
    private Paint paint = new Paint();
    private Bitmap bitmap;
    private float x;
    private float y;

    public Peach(Resources res) {
        bitmap = BitmapFactory.decodeResource(res, R.drawable.peach);
        x = 50;
        y = 800;
    }

    @Override
    public void onTouch() {
        y -= 30;
        if(y < 500){
            y = 800;
        }
    }

    @Override
    public boolean onUpdate() {
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,x,y,paint);
    }
}
