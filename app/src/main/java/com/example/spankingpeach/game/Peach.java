package com.example.spankingpeach.game;

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

    public Peach(Resources res) {
        bitmap = BitmapFactory.decodeResource(res, R.drawable.peach);
    }

    @Override
    public boolean onUpdate() {
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,50,800,paint);
    }
}
