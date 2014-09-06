package com.example.spankingpeach.game.Task;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.spankingpeach.R;

/**
 * Created by dev on 14/07/29.
 */
public class Peach extends Task{
    private Paint paint = new Paint();
    private Bitmap bitmap;
    private final float POSITION_X = 50; // X座標
    private final float POSITION_Y = 800; // Y座標

    public Peach(Resources res) {
        bitmap = BitmapFactory.decodeResource(res, R.drawable.peach);
    }

    @Override
    public void onTouch() {
    }

    @Override
    public boolean onUpdate() {
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,POSITION_X,POSITION_Y,paint);
    }
}
