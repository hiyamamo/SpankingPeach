package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.entity.Stage;
import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.Score;
import com.example.spankingpeach.game.task.ClearChar;
import com.example.spankingpeach.game.task.Peach;
import com.example.spankingpeach.game.task.Task;

import java.util.LinkedList;

/**
 */
public class InGame extends ConcreteState{
    private static State mInGame = new InGame();
    private InGame(){}
    public static State getInstance(){
        return mInGame;
    }

    @Override
    public void onUpdate(GameMng manager) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        super.onUpdate(manager);
        taskList.add(Peach.getInstance());
        if(Score.isClear()){
            clear(manager);
        }
        if(Score.isGameOver()){
            manager.setState(TimeUp.getInstance());
        }
        execUpdate(taskList);
    }
    private void clear(GameMng manager){
        manager.setState(Clear.getInstance());
        ClearChar.getInstance().init();
        Peach.getInstance().init();
    }

    @Override
    public void onTouch(GameMng manager, float x, float y) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        taskList.add(Peach.getInstance());
        execTouch(taskList, x, y);
    }

    @Override
    public void onDraw(GameMng manager, Canvas c, LinkedList<Task> tsklist) {
        tsklist = getDefaultDrawTasks();
        tsklist.add(Peach.getInstance());
        execDraw(tsklist, c);
    }
}
