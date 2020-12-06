package com.example.rect.enemies;

import android.util.Log;

public class Point {
    private int speed;
    private int x;
    private int y;
    private int currentTime;
    private int time;
    private Enemy enemy;
    private boolean active = true;

  /*  private float moveX;
    private float moveY;*/


    public Point(int speed, int x, int y, int time, Enemy enemy) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.time = time;
        this.enemy = enemy;
        //getMoveXAndMoveY();
    }

   /* private void getMoveXAndMoveY(){
        int distanceX = enemy.getX() - x;
        int distanceY = enemy.getY() - y;
        if (Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)) <speed) {
            enemy.setX(x);
            enemy.setY(y);
            return;
        }
        float parts = Math.abs(distanceX) + Math.abs(distanceY);
        if (parts == 0) {
            return;
        }

        float step = speed / parts;
        moveX = distanceX * step*(-1);
        moveY = distanceY * step*(-1);
    }*/

    public void move(){
        if(!active){
            return;
        }
        currentTime++;
        if(currentTime < time){
            return;
        }

        int distanceX = enemy.getX() - x;
        int distanceY = enemy.getY() - y;
        if (Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)) <speed) {
            enemy.setX(x);
            enemy.setY(y);
            active = false;
            return;
        }
        float parts = Math.abs(distanceX) + Math.abs(distanceY);
        if (parts == 0) {
            return;
        }

        float step = speed / parts;

        float currentY = enemy.getY()-distanceY * step;
        float currentX =  enemy.getX()-distanceX * step;
        enemy.setX((int)currentX);
        enemy.setY((int)currentY);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
