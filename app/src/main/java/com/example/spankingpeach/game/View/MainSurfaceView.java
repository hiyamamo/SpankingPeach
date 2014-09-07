package com.example.spankingpeach.game.View;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.spankingpeach.game.GameMng;

/**
 * Created by dev on 14/07/28.
 */
public class MainSurfaceView  extends SurfaceView implements SurfaceHolder.Callback,Runnable {

    private GameMng gameMng;
    private Thread thread;
    private final float VIEW_WIDTH = 600;
    private final float VIEW_HEIGHT = 900;
    private float mScale;
    public MainSurfaceView(Context context) {
        super(context);
        gameMng = new GameMng();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Thread(this);
        thread.start();
        float scaleX = getWidth() / VIEW_WIDTH;
        float scaleY = getHeight() / VIEW_HEIGHT;
        mScale = scaleX > scaleY ? scaleY : scaleX;
        gameMng.setScale(mScale);
        setOnTouchListener(gameMng.getTouchListener());
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread = null;
    }

    private void onDraw(SurfaceHolder holder){
        Canvas c = holder.lockCanvas();
        if(c == null){
            return;
        }
        //c.translate((getWidth() - VIEW_WIDTH) / 2 * mScale,(getHeight() - VIEW_HEIGHT) / 2 * mScale);
        c.scale(mScale,mScale);
        gameMng.onDraw(c);
        holder.unlockCanvasAndPost(c);
    }

    @Override
    public void run() {
        while (thread != null){
            gameMng.onUpdate();
           this.onDraw(getHolder());
        }
    }
}
