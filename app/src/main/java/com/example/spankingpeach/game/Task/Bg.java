package com.example.spankingpeach.game.task;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.spankingpeach.App;
import com.example.spankingpeach.entity.Stage;
import com.example.spankingpeach.R;

/**
 * Created by dev on 14/07/29.
 */
public class Bg extends Task {
    private static Bg mInstance = new Bg();
    private Bitmap bitmap;
    private Paint paint = new Paint();
    public static Bg getInstance(){
        return mInstance;
    }
    private Bg() {
        Resources res = App.getContext().getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.bg);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,0,0,paint);
        c.drawText(Stage.getInstance().getName(),0,100,paint);
    }
}
