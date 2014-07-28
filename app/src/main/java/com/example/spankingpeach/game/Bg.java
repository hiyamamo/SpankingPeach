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
public class Bg extends Task{
    private Bitmap bitmap;
    private Paint paint = new Paint();
    public Bg(Resources res) {
       bitmap = BitmapFactory.decodeResource(res, R.drawable.bg);
    }

    @Override
    public boolean onUpdate() {
        return super.onUpdate();
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,0,0,paint);
    }
}
