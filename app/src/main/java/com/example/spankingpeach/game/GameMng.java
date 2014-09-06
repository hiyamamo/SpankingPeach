package com.example.spankingpeach.game;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import com.example.spankingpeach.game.State;
import com.example.spankingpeach.game.Task.Bg;
import com.example.spankingpeach.game.Task.DispState;
import com.example.spankingpeach.game.Task.FpsController;
import com.example.spankingpeach.game.Task.Gage;
import com.example.spankingpeach.game.Task.Peach;
import com.example.spankingpeach.game.Task.Task;
import com.example.spankingpeach.game.Task.Timer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by dev on 14/07/29.
 */
public class GameMng {
    private LinkedList<Task> taskList = new LinkedList<Task>();
    private float mScale;

    public GameMng(Resources res) {
        taskList.add(new Bg(res));
        taskList.add(new FpsController());
        taskList.add(new Peach(res));
        taskList.add(new Gage());
        taskList.add(new Timer());
        taskList.add(new DispState());
        State.setState(State.BEFORE);
    }
    public void setScale(float scale){
        mScale = scale;
    }

    public boolean onUpdate(){
        for(Iterator<Task> i = taskList.iterator();i.hasNext();){
            if(!i.next().onUpdate()){
                i.remove();
            }
        }
        return true;
    }
    public void onDraw(Canvas c){
        c.drawColor(Color.WHITE);
        for (Task i : taskList) {
            i.onDraw(c);
        }
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
                if(State.getState() == State.BEFORE){
                    State.setState(State.IN_GAME);
                }
                for (Task i : taskList) {
                    i.onTouch();
                }
            }
            return false;
        }
    }
}
