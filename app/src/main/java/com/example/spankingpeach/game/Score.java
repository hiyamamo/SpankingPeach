package com.example.spankingpeach.game;

/**
 * Created by hiroki on 2014/10/09.
 */
public class Score {
    public static int hitScore = 0; // 獲得したスコア
    public static int life = 5; // 残りライフ

    private static void initScore(){
        hitScore = 0;
        life = 5;
    }
    public static boolean isClear(){
        if(hitScore >= 10){
            initScore();
            return true;
        }
        return false;
    }
    public static boolean isGameOver(){
        if(life <= 0){
            initScore();
            return true;
        }
        return false;
    }
}
