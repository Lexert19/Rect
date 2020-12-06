package com.example.rect.levels;

import com.example.rect.Data;

public class Level{
    protected int points = 0;
    protected int currentTick;
    protected int ticks;
    protected int levelId;

    public void tick(){

    }

    protected void EndLevel(){
        this.clearEnemies();
        Data.currentLevel = null;
        Data.menu.showCurrentLevelsSet();
        Data.end = true;
        Data.myRect.regenerate();

        if(Data.listOfPoints.get(levelId) < Data.levelSPoints){
            Data.listOfPoints.set(levelId, Data.levelSPoints);
        }
        Data.levelSPoints = 0;
    }

    public int collectedPoints(){
        return Data.listOfPoints.get(levelId);
    }

    public int getPoints(){
        return points;
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
