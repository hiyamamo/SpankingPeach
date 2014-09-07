package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.Task.FpsController;
import com.example.spankingpeach.game.Task.Task;

import java.util.Iterator;
import java.util.LinkedList;

/**
 */
public abstract class ConcreteState implements State{
    @Override
    public void onUpdate(GameMng manager) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        taskList.add(FpsController.getInstance());
        execUpdate(taskList);
    }

    @Override
    public void onTouch(GameMng manager) {

    }

    @Override
    public void onDraw(GameMng manager, Canvas c) {

    }
    // アップデート処理実行関数
    protected void execUpdate(LinkedList<Task> taskList){
        for(Iterator<Task> i = taskList.iterator();i.hasNext();) {
            if (!i.next().onUpdate()) {
                i.remove();
            }
        }
    }
    protected void execTouch(LinkedList<Task> taskList){
        for(Task t : taskList){
            t.onTouch();
        }
    }
    protected void execDraw(LinkedList<Task> taskList,Canvas c){
        for(Task t : taskList){
            t.onDraw(c);
        }
    }
}
