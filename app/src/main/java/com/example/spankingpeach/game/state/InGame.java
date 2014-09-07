package com.example.spankingpeach.game.state;

import android.graphics.Canvas;

import com.example.spankingpeach.game.GameMng;
import com.example.spankingpeach.game.Task.Bg;
import com.example.spankingpeach.game.Task.FpsController;
import com.example.spankingpeach.game.Task.Gage;
import com.example.spankingpeach.game.Task.Peach;
import com.example.spankingpeach.game.Task.Task;
import com.example.spankingpeach.game.Task.Timer;

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
        taskList.add(Gage.getInstance());
        taskList.add(Timer.getInstance());
        taskList.add(FpsController.getInstance());
        if(Gage.getInstance().IsEnd()){
            manager.setState(Clear.getInstance());
        }
        if(Timer.getInstance().IsTimeUp()){
            manager.setState(TimeUp.getInstance());
        }

        execUpdate(taskList);
    }

    @Override
    public void onTouch(GameMng manager) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        taskList.add(Peach.getInstance());
        taskList.add(Gage.getInstance());

        execTouch(taskList);
    }

    @Override
    public void onDraw(GameMng manager, Canvas c) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        taskList.add(Bg.getInstance());
        taskList.add(Peach.getInstance());
        taskList.add(Gage.getInstance());
        taskList.add(FpsController.getInstance());
        taskList.add(Timer.getInstance());

        execDraw(taskList,c);


    }
}
