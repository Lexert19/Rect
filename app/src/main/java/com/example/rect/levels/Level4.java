package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;
import com.example.rect.enemies.Enemy;
import com.example.rect.enemies.RedEnemy;

public class Level4 extends Level{
    public Level4() {
        this.levelId = 4;
        this.ticks = 600;
        this.points = 21;
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
        int speed = 11;

        for (int i = 0; i < 25; i++) {
            int x = i * (53) + 20;
            int y = -200;
            Enemy enemy;
            if (i >= 20 && i <= 22) {
                enemy = new BlueEnemy(x, y, 0, speed);
            } else {
                enemy = new RedEnemy(x, y, 0, speed);
            }
            Data.enemies.push(enemy);
        }

        for (int i = 0; i < 25; i++) {
            int x = i * (53) + 20;
            int y = -800;
            Enemy enemy;
            if (i >= 5 && i <= 7) {
                enemy = new BlueEnemy(x, y, 0, speed);
            } else {
                enemy = new RedEnemy(x, y, 0, speed);
            }
            Data.enemies.push(enemy);
        }

        for (int i = 0; i < 25; i++) {
            int x = i * (53) + 20;
            int y = -1400;
            Enemy enemy;
            if (i >= 14 && i <= 16) {
                enemy = new BlueEnemy(x, y, 0, speed);
            } else {
                enemy = new RedEnemy(x, y, 0, speed);
            }
            Data.enemies.push(enemy);
        }

        for (int i = 0; i < 25; i++) {
            int x = i * (53) + 20;
            int y = -2000;
            Enemy enemy;
            if (i >= 2 && i <= 4) {
                enemy = new BlueEnemy(x, y, 0, speed);
            } else {
                enemy = new RedEnemy(x, y, 0, speed);
            }
            Data.enemies.push(enemy);
        }

        for (int i = 0; i < 25; i++) {
            int x = i * (53) + 20;
            int y = -2600;
            Enemy enemy;
            if (i >= 19 && i <= 21) {
                enemy = new BlueEnemy(x, y, 0, speed);
            } else {
                enemy = new RedEnemy(x, y, 0, speed);
            }
            Data.enemies.push(enemy);
        }

        for (int i = 0; i < 25; i++) {
            int x = i * (53) + 20;
            int y = -3200;
            Enemy enemy;
            if (i >= 7 && i <= 9) {
                enemy = new BlueEnemy(x, y, 0, speed);
            } else {
                enemy = new RedEnemy(x, y, 0, speed);
            }
            Data.enemies.push(enemy);
        }

        for (int i = 0; i < 25; i++) {
            int x = i * (53) + 20;
            int y = -3800;
            Enemy enemy;
            if (i >= 12 && i <= 14) {
                enemy = new BlueEnemy(x, y, 0, speed);
            } else {
                enemy = new RedEnemy(x, y, 0, speed);
            }
            Data.enemies.push(enemy);
        }
    }
}
