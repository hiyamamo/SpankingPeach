package com.example.spankingpeach.game.Task;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.spankingpeach.App;
import com.example.spankingpeach.R;
import com.example.spankingpeach.game.Task.Task;

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
    }

    @Override
    public void onDraw(Canvas c) {
        c.drawBitmap(bitmap,0,0,paint);
    }
}
