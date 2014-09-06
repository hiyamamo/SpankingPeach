package com.example.spankingpeach.game;

/**
 * ゲームの状態を管理するクラス
 */
public class State {
    private static int mState;
    public static final int BEFORE = 0;
    public static final int IN_GAME = 1;
    public static final int PAUSE = 2;
    public static final int GAME_OVER = 3;

    public static int getState(){
       return mState;
    }
    // in game
    // pause
    // before start
    // game over

    public static void setState(int s){
        mState = s;
    }
}
