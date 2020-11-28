package com.example.rect.levels;


import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;

public class Level1 extends Level {
    public static int points = 84;
    private int ticks = 570;
    private int currentTick = 0;

    @Override
    public void tick() {
        currentTick++;
        if(currentTick == ticks){
            currentTick = 0;
            this.EndLevel();
        }
        if(currentTick == 30){
            spawn();
        }

        super.tick();
    }

    private void spawn(){
        int a = 0;
        for(int j=0; j<4; j++){
             for(int i=0; i<7; i++){
                 int x = 224+i*150;
                 int y = -300-i*24-a;
                 BlueEnemy blueEnemy = new BlueEnemy(x, y, 0, 5);
                 Data.enemies.add(blueEnemy);
             }
             for(int i=0; i<7; i++){
                 int x = 224+i*150;
                 int y = -300-i*-24-a;
                 BlueEnemy blueEnemy = new BlueEnemy(x, y, 0, 5);
                 Data.enemies.add(blueEnemy);
             }
             a+=300;
             for(int i=0; i<7; i++){
                 int x = 224+i*150;
                 int y = -300-i*-24-a;
                 BlueEnemy blueEnemy = new BlueEnemy(x, y, 0, 5);
                 Data.enemies.add(blueEnemy);
             }
        }
    }

    @Override
    protected void EndLevel() {
        super.EndLevel();
        if(Data.lvl1Points < Data.levelSPoints){
            Data.lvl1Points = Data.levelSPoints;
        }
        Data.levelSPoints = 0;
    }

    @Override
    public int collectedPoints() {
        return Data.lvl1Points;
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
