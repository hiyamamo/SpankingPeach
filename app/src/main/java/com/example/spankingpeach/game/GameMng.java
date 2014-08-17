package com.example.spankingpeach.game;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by dev on 14/07/29.
 */
public class GameMng {
    private LinkedList<Task> taskList = new LinkedList<Task>();

    public GameMng(Resources res) {
        taskList.add(new Bg(res));
        taskList.add(new FpsController());
        taskList.add(new Peach(res));
        taskList.add(new Gage());
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
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                for (Task i : taskList) {
                    i.onTouch();
                }
            }
            return false;
        }
    }
}
