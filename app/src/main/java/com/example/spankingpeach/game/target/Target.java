package com.example.spankingpeach.game.target;

/**
 * 落下してくる桃のスーパークラス
 */
public class Target {
    protected int mX,mY; // 座標
    protected int mSpeed; // 落ちてくスピード

    public Target(int x, int y, int speed){
        mX = x;
        mY = y;
        mSpeed = speed;
    }

    // 座標を計算する
    public boolean calcCoord() {
        mY = mY + mSpeed;
        if(mY <= 0){
            return false;
        }
        return true;
    }

    public int getX(){
        return mX;
    }
    public int getY(){
        return mY;
    }
}