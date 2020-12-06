package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;

public class Level3 extends Level {
    public Level3() {
        this.levelId = 3;
        this.ticks = 2100;
        this.points = 800;
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
}
