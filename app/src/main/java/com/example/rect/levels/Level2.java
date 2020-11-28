package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;

public class Level2 extends Level {
    private int ticks = 2200;
    public static int points = 360;
    private int currentTick = 0;

    @Override
    public void tick() {
        currentTick++;
        if(currentTick == ticks){
            currentTick = 0;
            this.EndLevel();
        }

        if(currentTick == 20){
            this.spawn();
        }

        super.tick();
    }

    private void spawn(){
        for(int i=0; i<360; i++){
            int x = (int) (Math.sin(i*3)*360+640);
            BlueEnemy blueEnemy = new BlueEnemy(x, i*(-19)-200, 0, 3.6f);
            Data.enemies.add(blueEnemy);
        }
    }

    @Override
    protected void EndLevel() {
        super.EndLevel();
        if(Data.lvl2Points < Data.levelSPoints){
            Data.lvl2Points = Data.levelSPoints;
        }
        Data.levelSPoints = 0;
    }

    @Override
    public int collectedPoints() {
        return Data.lvl2Points;
    }

    @Override
    public int getPoints() {
        return points;
    }

    public int getCurrentTick() {
        return currentTick;
    }

    public void setCurrentTick(int currentTick) {
        this.currentTick = currentTick;
    }
}
