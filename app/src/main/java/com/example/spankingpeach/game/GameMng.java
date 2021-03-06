package com.example.spankingpeach.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import com.example.spankingpeach.game.state.Before;
import com.example.spankingpeach.game.state.State;

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
       // for(Iterator<Task> i = taskList.iterator();i.hasNext();){
       //     if(!i.next().onUpdate()){
       //         i.remove();
       //     }
//        }

        return true;
    }
    public void onDraw(Canvas c){
        c.drawColor(Color.WHITE);
        mState.onDraw(this,c);
       // for (Task i : taskList) {
       //     i.onDraw(c);
//        }
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
