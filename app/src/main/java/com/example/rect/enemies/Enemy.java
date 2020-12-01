package com.example.rect.enemies;

import android.graphics.Canvas;

import com.example.rect.Data;

public class Enemy {
    protected int x;
    protected int y;
    protected float speedX;
    protected float speedY;
    protected int degrees;
    protected int color;

    public Enemy(int x, int y, float speedX, float speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void draw(Canvas canvas){
        if(Data.myRect.getLive() > 0){
            this.move();
        }
        this.drawRect(canvas);
    }

    protected void drawRect(Canvas canvas){
        canvas.save();
        Data.paint.setColor(this.color);

        canvas.translate(this.x, this.y);
        canvas.rotate(this.degrees);
        canvas.drawRect(-20,-20, 20, 20, Data.paint);

        canvas.restore();
    }

    public void kill(){

    }

    protected void move(){
        this.x += speedX;
        this.y += speedY;
        this.degrees +=1;
    }

    protected void playDash(){
        try {
            if(Data.playerQueue.size() == 0){
                Data.playerQueue.put(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        this.y = y-40;
    }
}
