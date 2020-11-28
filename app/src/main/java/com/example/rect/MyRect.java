package com.example.rect;

import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AsyncPlayer;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.rect.enemies.BlueEnemy;
import com.example.rect.enemies.Enemy;
import com.example.rect.particles.DeathCircle;

public class MyRect {
    private int x;
    private int y;
    private int currentX;
    private int currentY;
    private int speed;
    private int degrees;
    private int live = 3;
    private int color = Color.parseColor("#700fa8");



    public MyRect(int x, int y, int currentX, int currentY) {
        this.x = x;
        this.y = y;
        this.currentX = currentX;
        this.currentY = currentY;
        this.speed = 36;
        this.degrees = 0;
    }

    public void draw(Canvas canvas){
        this.move();
        this.drawMyRect(canvas);
        this.attack();
    }

    public void drawMyRect(Canvas canvas){
        canvas.save();
        Data.paint.setColor(this.color);


        canvas.translate(Data.myRect.getCurrentX(), Data.myRect.getCurrentY());
        canvas.rotate(this.degrees);
        canvas.drawRect(-30,-30, 30, 30, Data.paint);

        canvas.restore();
    }

    public void move(){
        this.degrees+= 7;
        int distanceX = this.currentX-this.x;
        int distanceY = this.currentY-this.y;
        if(Math.sqrt(Math.pow(distanceX,2)+Math.pow(distanceY,2)) < this.speed){
            this.currentX = this.x;
            this.currentY = this.y;
            return;
        }
        float parts = Math.abs(distanceX)+Math.abs(distanceY);
        if(parts == 0){
            return;
        }

        float step = this.speed/parts;
        this.currentX -= distanceX*step;
        this.currentY -= distanceY*step;
    }

    private void attack(){
        if(this.live>0){
            for(int i=0; i<Data.enemies.size(); i++){
                Enemy enemy = Data.enemies.get(i);
                float distance = (float) Math.sqrt(Math.pow(this.currentX-enemy.getX(), 2)+Math.pow(this.currentY-enemy.getY(),2));
                if(distance < 60){
                    if(enemy instanceof BlueEnemy){
                        DeathCircle deathCircle = new DeathCircle(Color.parseColor("#556464ff"), enemy.getX(), enemy.getY()+24, 6, 10);
                        Data.particles.add(deathCircle);
                        Data.levelSPoints++;
                        this.playDash();
                        Data.enemies.remove(i);
                    }
                }
            }
        }
    }

    private void playDash(){
        //Data.player.playDash();
        try {
            if(Data.queue.size() == 0){
                Data.queue.put(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void regenerate(){
        this.live = 3;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
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
}
