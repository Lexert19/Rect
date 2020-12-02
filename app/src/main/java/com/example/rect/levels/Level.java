package com.example.rect.levels;

import com.example.rect.Data;

public class Level{
    public static int points = 0;
    protected int currentTick;

    public int getPoints(){
        return points;
    }

    public void tick(){

    }

    public int collectedPoints(){
        return 1;
    }

    protected void EndLevel(){
        this.clearEnemies();
        Data.currentLevel = null;
        Data.menu.showCurrentLevelsSet();
        Data.end = true;
        Data.myRect.regenerate();
    }

    private void clearEnemies(){
        Data.enemies.clear();
    }

    public int getCurrentTick() {
        return currentTick;
    }

    public void setCurrentTick(int currentTick) {
        this.currentTick = currentTick;
    }
}
