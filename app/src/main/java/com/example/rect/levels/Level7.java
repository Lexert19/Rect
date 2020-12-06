package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;
import com.example.rect.enemies.Enemy;
import com.example.rect.enemies.Path;

public class Level7 extends Level {
    public Level7() {
        this.ticks = 570;
        this.levelId = 7;
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

        Enemy enemy = new BlueEnemy(650, -100);
        Path path = new Path(enemy);
        path.addPoint(650,350,12, 0);
        enemy.setPath(path);
        Data.enemies.add(enemy);
    }
}
