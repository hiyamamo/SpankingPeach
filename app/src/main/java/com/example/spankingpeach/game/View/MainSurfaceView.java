package com.example.spankingpeach.game.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import com.example.spankingpeach.game.GameMng;

/**
 * Created by dev on 14/07/28.
 */
public class MainSurfaceView  extends SurfaceView implements SurfaceHolder.Callback,Runnable {

    private GameMng gameMng = new GameMng(getResources());
    private Thread thread;
    public MainSurfaceView(Context context) {
        super(context);
        setOnTouchListener(gameMng.getTouchListener());
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new Thread(this);
        thread.start();
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
