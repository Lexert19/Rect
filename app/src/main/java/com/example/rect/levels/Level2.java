package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;

public class Level2 extends Level {
    public Level2() {
        this.points = 360;
        this.ticks = 2200;
        this.levelId = 2;
    }

    @Override
    public void tick() {
        currentTick++;
        if(currentTick == ticks){
            currentTick = 0;
            this.EndLevel();
        }

        if(currentTick == 30){
            this.spawn();
        }
    }

    private void spawn(){
        for(int i=0; i<360; i++){
            int x = (int) (Math.sin(i*3)*360+640);
            BlueEnemy blueEnemy = new BlueEnemy(x, i*(-19)-200, 0, 3.6f);
            Data.enemies.add(blueEnemy);
        }
    }
}
