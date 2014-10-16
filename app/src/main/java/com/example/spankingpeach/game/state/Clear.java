package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.entity.Stage;
import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.task.ClearChar;
import com.example.spankingpeach.game.task.Task;

import java.util.LinkedList;

/**
 */
public class Clear extends ConcreteState{
    private static Clear mInstance = new Clear();
    public static Clear getInstance(){
        return mInstance;
    }
    private Clear(){}

    @Override
    public void onTouch(GameMng manager, float x, float y) {
        LinkedList<Task> tsklist = new LinkedList<Task>();
        tsklist.add(ClearChar.getInstance());
        execTouch(tsklist,x,y);
    }

    @Override
    public void onUpdate(GameMng manager) {
        super.onUpdate(manager);
        if(ClearChar.getInstance().isTouched()){
            manager.setState(InGame.getInstance());
            Stage.getInstance().nextLevel();
        }
    }

    @Override
    public void onDraw(GameMng manager, Canvas c, LinkedList<Task> tsklist) {
        tsklist = getDefaultDrawTasks();
        tsklist.add(ClearChar.getInstance());

        execDraw(tsklist,c);
    }
}
