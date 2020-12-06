package com.example.rect.levels;


import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;

public class Level1 extends Level {
    public Level1() {
        this.ticks = 570;
        this.levelId = 1;
        this.points = 84;
    }

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
    }

    private void spawn(){
        int a = 0;
        for(int j=0; j<4; j++){
             for(int i=0; i<7; i++){
                 int x = 224+i*120;
                 int y = -300-i*24-a;
                 BlueEnemy blueEnemy = new BlueEnemy(x, y, 0, 5);
                 Data.enemies.add(blueEnemy);
             }
             for(int i=0; i<7; i++){
                 int x = 224+i*120;
                 int y = -300-i*-24-a;
                 BlueEnemy blueEnemy = new BlueEnemy(x, y, 0, 5);
                 Data.enemies.add(blueEnemy);
             }
             a+=300;
             for(int i=0; i<7; i++){
                 int x = 224+i*120;
                 int y = -300-i*-24-a;
                 BlueEnemy blueEnemy = new BlueEnemy(x, y, 0, 5);
                 Data.enemies.add(blueEnemy);
             }
        }
    }
}
