package com.example.rect.levels;

import com.example.rect.Data;
import com.example.rect.buttons.Directions;
import com.example.rect.enemies.BlueEnemy;
import com.example.rect.enemies.Enemy;
import com.example.rect.enemies.RedEnemy;

public class Level5 extends Level {
    public static int points = 96;
    private int ticks = 1700;
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
        for(int j=0; j<1; j++){
            spawnElement(100,-500, Directions.Direction.DOWN);
            spawnElement(500,-1100, Directions.Direction.UP);
            spawnElement(300,-1700, Directions.Direction.LEFT);
            spawnElement(800,-2300, Directions.Direction.RIGHT);
            spawnElement(100,-2900, Directions.Direction.DOWN);
            spawnElement(450,-3500, Directions.Direction.UP);

            spawnElement(100,-4100, Directions.Direction.RIGHT);
            spawnElement(750,-4100, Directions.Direction.LEFT);
        }
    }

    private void spawnElement(int x, int y, Directions.Direction gateway){
        int speed = 3;
        for(int i=0; i<9; i++){
            Enemy enemy1 = new RedEnemy(x+i*50, y+400, 0, speed);
            Enemy enemy2 = new RedEnemy(x+i*50, y, 0, speed);
            Enemy enemy3 = new RedEnemy(x+400, y+i*50, 0, speed);
            Enemy enemy4 = new RedEnemy(x, y+i*50, 0, speed);

            if(gateway == Directions.Direction.DOWN){
                if(i >= 3 && i<= 5){
                    enemy1 = new BlueEnemy(x+i*50, y+400, 0, speed);
                }
            }else if(gateway == Directions.Direction.UP){
                if(i >= 3 && i<= 5){
                    enemy2 = new BlueEnemy(x+i*50, y, 0, speed);
                }
            }else if(gateway == Directions.Direction.RIGHT){
                if(i >= 3 && i<= 5){
                    enemy3 = new BlueEnemy(x+400, y+i*50, 0, speed);
                }
            }else if(gateway == Directions.Direction.LEFT){
                if(i >= 3 && i<= 5){
                    enemy4 = new BlueEnemy(x, y+i*50, 0, speed);
                }
            }
            Data.enemies.add(enemy1);
            Data.enemies.add(enemy2);
            Data.enemies.add(enemy3);
            Data.enemies.add(enemy4);
        }
        spawnElement1(x,y);
    }

    private void spawnElement1(int x, int y){
        int speed = 3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                Enemy enemy = new BlueEnemy(x+150+i*50, y+150+j*50, 0, speed);
                Data.enemies.add(enemy);
            }
        }
    }

    @Override
    protected void EndLevel() {
        super.EndLevel();
        if(Data.lvl5Points < Data.levelSPoints){
            Data.lvl5Points = Data.levelSPoints;
        }
        Data.levelSPoints = 0;
    }

    @Override
    public int collectedPoints() {
        return Data.lvl5Points;
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
