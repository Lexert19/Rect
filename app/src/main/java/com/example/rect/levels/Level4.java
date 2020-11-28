package com.example.rect.levels;

import com.example.rect.Data;

public class Level4 extends Level{
    private int ticks = 600;
    public static int points = 21;
    private int currentTick = 0;

    @Override
    public void tick() {
        currentTick++;
        if(currentTick == ticks){
            currentTick = 0;
            this.EndLevel();
        }

        super.tick();
    }

    @Override
    protected void EndLevel() {
        super.EndLevel();
        if(Data.lvl4Points < Data.levelSPoints){
            Data.lvl4Points = Data.levelSPoints;
        }
        Data.levelSPoints = 0;
    }

    @Override
    public int collectedPoints() {
        return Data.lvl4Points;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
