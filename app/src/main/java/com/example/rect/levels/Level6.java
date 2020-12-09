package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.enemies.BlueEnemy;
import com.example.rect.enemies.Enemy;
import com.example.rect.enemies.Path;
import com.example.rect.enemies.RedEnemy;

public class Level6 extends Level {
    public Level6() {
        this.levelId = 6;
        this.ticks = 740;
        this.points = 96;
    }

    @Override
    public void tick() {
        currentTick++;
        if (currentTick == ticks) {
            currentTick = 0;
            this.EndLevel();
        }
        spawn();
    }


    private void spawn() {
        if (currentTick == 30) {
            spawnWave1();
        } else if (currentTick == 200) {
            spawnWave2();
        } else if (currentTick == 370) {
            spawnWave1();
        } else if (currentTick == 540) {
            spawnWave2();
        }
    }

    private void spawnWave1() {
        spawnXD(30, 250);
        spawnWall(10, -2700);
    }

    private void spawnWave2() {
        spawnXD(680, 250);
        spawnWall(660, -2700);
    }

    private void spawnWall(int x, int y) {
        int speed = 34;
        for (int i = 0; i < 13; i++) {
            Enemy enemy = new RedEnemy(x + i * 50, y, 0, speed);
            Data.enemies.add(enemy);
        }
    }

    private void spawnXD(int x, int y) {
        int time = 90;
        int fadeX;
        if (x <= 650) {
            fadeX = -300;
        } else {
            fadeX = 1600;
        }

        for (int i = 0; i < 6; i++) {
            int x_ = x + i * 40;
            int y_ = y + i * 40;
            Enemy enemy = new BlueEnemy(x_, y_ - 500);
            Path path = new Path(enemy);
            path.addPoint(x_, y_, 16, 0);
            path.addPoint(fadeX, y_, 24, time);
            enemy.setPath(path);
            Data.enemies.add(enemy);
        }

        for (int i = 0; i < 6; i++) {
            int x_ = x + i * 40;
            int y_ = y - i * 40 + 200;
            Enemy enemy = new BlueEnemy(x_, y_ - 500);
            Path path = new Path(enemy);
            path.addPoint(x_, y_, 16, 0);
            path.addPoint(fadeX, y_, 24, time);
            enemy.setPath(path);
            Data.enemies.add(enemy);
        }

        for (int i = 0; i < 6; i++) {
            int x_ = x + 360;
            int y_ = y - i * 40 + 200;
            Enemy enemy = new BlueEnemy(x_, y_ - 500);
            Path path = new Path(enemy);
            path.addPoint(x_, y_, 16, 0);
            path.addPoint(fadeX, y_, 24, time);
            enemy.setPath(path);
            Data.enemies.add(enemy);
        }

        for(int i=0; i<3; i++){
            int x_ = 400+x + i * 40;
            int y_ = y + i * 40;
            Enemy enemy = new BlueEnemy(x_, y_ - 500);
            Path path = new Path(enemy);
            path.addPoint(x_, y_, 16, 0);
            path.addPoint(fadeX, y_, 24, time);
            enemy.setPath(path);
            Data.enemies.add(enemy);
        }

        for(int i=0; i<3; i++){
            int x_ = 400+x + i * 40;
            int y_ = 200+y - i * 40;
            Enemy enemy = new BlueEnemy(x_, y_ - 500);
            Path path = new Path(enemy);
            path.addPoint(x_, y_, 16, 0);
            path.addPoint(fadeX, y_, 24, time);
            enemy.setPath(path);
            Data.enemies.add(enemy);
        }
    }

}
