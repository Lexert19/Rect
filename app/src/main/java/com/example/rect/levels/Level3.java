package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;

public class Level3 extends Level {
    private int ticks = 2100;
    public static int points = 800;
    private int currentTick = 0;

    @Override
    public void tick() {
        currentTick++;
        if(currentTick == ticks){
            currentTick = 0;
            this.EndLevel();
        }

        if(currentTick == 20){
            spawn();
        }

        super.tick();
    }

    private void spawn(){
        for(int k=0; k<2; k++){
            for(int j=0; j<20; j++){
                for(int i=0; i<20; i++){
                    int x = i*(60)+70;
                    int y = j*(-60)-240-k*1800;
                    BlueEnemy blueEnemy = new BlueEnemy(x, y, 0, 2f);
                    Data.enemies.add(blueEnemy);
                }
            }
        }
    }

    @Override
    protected void EndLevel() {
        super.EndLevel();
        if(Data.lvl3Points < Data.levelSPoints){
            Data.lvl3Points = Data.levelSPoints;
        }
        Data.levelSPoints = 0;
    }

    @Override
    public int collectedPoints() {
        return Data.lvl3Points;
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
