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
        super.onUpdate(manager);
        taskList.add(Gage.getInstance());
        taskList.add(Timer.getInstance());
        if(Gage.getInstance().IsEnd()){
            manager.setState(Clear.getInstance());
        }
        if(Timer.getInstance().IsTimeUp()){
            manager.setState(TimeUp.getInstance());
        }
        execUpdate(taskList);
    }

    @Override
    public void onTouch(GameMng manager, float x, float y) {
        LinkedList<Task> taskList = new LinkedList<Task>();
        taskList.add(Peach.getInstance());
        if(Peach.getInstance().checkTouchRange(x,y)) {
            taskList.add(Gage.getInstance());
        }
        execTouch(taskList, x, y);
    }

    @Override
    public void onDraw(GameMng manager, Canvas c) {
        super.onDraw(manager,c);
    }
}
