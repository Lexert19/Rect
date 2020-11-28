package com.example.rect.enemies;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;

public class BlueEnemy extends Enemy {
    private int x;
    private int y;
    private float speedX;
    private float speedY;
    private int degrees;
    private int color = Color.parseColor("#6464ff");

    public BlueEnemy(int x, int y, float speedX, float speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void draw(Canvas canvas) {
        this.move();
        this.drawRect(canvas);
        super.draw(canvas);
    }

    private void move(){
        this.x += speedX;
        this.y += speedY;
        this.degrees +=1;
    }

    private void drawRect(Canvas canvas){
        canvas.save();
        Data.paint.setColor(this.color);

        canvas.translate(this.x, this.y);
        canvas.rotate(this.degrees);
        canvas.drawRect(-20,-20, 20, 20, Data.paint);

        canvas.restore();

        //Data.paint.setColor(Color.RED);
        //canvas.drawRect(this.x-3,this.y-3, this.x+3, this.y+3, Data.paint);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y-40;
    }
}
