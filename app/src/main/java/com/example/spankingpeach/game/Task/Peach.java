package com.example.spankingpeach.game.Task;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.spankingpeach.App;
import com.example.spankingpeach.R;

/**
 * Created by dev on 14/07/29.
 */
public class Peach extends Task{
    private static Peach mInstance = new Peach();
    private Paint paint = new Paint();
    private Bitmap bitmap;
    private final float POSITION_X = 90; // X座標
    private final float POSITION_Y = 550; // Y座標

    public static Peach getInstance(){
        return mInstance;
    }
    private Peach() {
        Resources res = App.getContext().getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.peach);
    }

    @Override
    public void onTouch() {
    }


    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,POSITION_X,POSITION_Y,paint);
    }
}
