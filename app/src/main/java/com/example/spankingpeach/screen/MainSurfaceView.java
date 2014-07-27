package com.example.spankingpeach.screen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.spankingpeach.R;

/**
 * Created by dev on 14/07/28.
 */
public class MainSurfaceView  extends SurfaceView implements SurfaceHolder.Callback {

    private Bitmap mPeach;  //桃画像
    private Bitmap mBg; //背景画像

    private final float BG_LEFT = 0;
    private final float BG_TOP = 0;
    private final float PEACH_LEFT = 50;
    private final float PEACH_TOP = 800;
    public MainSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        mPeach = BitmapFactory.decodeResource(getResources(), R.drawable.peach);
        mBg = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Paint paint = new Paint();
        Canvas canvas = holder.lockCanvas();
        canvas.drawBitmap(mBg, BG_LEFT, BG_TOP, paint);
        canvas.drawBitmap(mPeach, PEACH_LEFT, PEACH_TOP, paint);
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
