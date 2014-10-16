package com.example.spankingpeach.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import com.example.spankingpeach.game.state.Before;
import com.example.spankingpeach.game.state.State;
import com.example.spankingpeach.game.task.Task;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dev on 14/07/29.
 */
public class GameMng {
    private State mState;
    private float mScale;

    public GameMng() {
        mState = Before.getInstance();
    }
    public void setScale(float scale){
        mScale = scale;
    }

    public void setState(State s){
        mState = s;
    }

    public boolean onUpdate(){
       mState.onUpdate(this);

        return true;
    }
    public void onDraw(Canvas c){
        LinkedList<Task> tsklist = new LinkedList<Task>();
        c.drawColor(Color.WHITE);
        mState.onDraw(this,c, tsklist);
    }

    //タッチリスナーインスタンス生成
    public GameTouchListener getTouchListener(){
        return new GameTouchListener();
    }
    //タッチリスナーの内部クラス
    private class GameTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float touchedX = event.getX() / mScale;
            float touchedY = event.getY() / mScale;
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                mState.onTouch(GameMng.this, touchedX, touchedY);
            }
            return false;
        }
    }
}
