package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.task.Bg;
import com.example.spankingpeach.game.task.FpsController;
import com.example.spankingpeach.game.task.ItemIcon;
import com.example.spankingpeach.game.task.Task;

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
    public void onTouch(GameMng manager, float x, float y) {

    }

    @Override
    public void onDraw(GameMng manager, Canvas c, LinkedList<Task> tsklist) {
        tsklist = getDefaultDrawTasks();

        execDraw(tsklist, c);
    }
    // アップデート処理実行関数
    protected void execUpdate(LinkedList<Task> taskList){
        for(Iterator<Task> i = taskList.iterator();i.hasNext();) {
            if (!i.next().onUpdate()) {
                i.remove();
            }
        }
    }
    protected void execTouch(LinkedList<Task> taskList, float x, float y){
        for(Task t : taskList){
            t.onTouch(x,y);
        }
    }
    protected void execDraw(LinkedList<Task> taskList,Canvas c){
        for(Task t : taskList){
            t.onDraw(c);
        }
    }
    protected LinkedList<Task> getDefaultDrawTasks(){
        LinkedList<Task> tsklist = new LinkedList<Task>();
        tsklist.add(Bg.getInstance());
        tsklist.add(FpsController.getInstance());
        tsklist.add(ItemIcon.getInstance());

        return tsklist;
    }
}
