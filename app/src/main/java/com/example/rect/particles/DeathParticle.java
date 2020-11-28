package com.example.rect.particles;

import android.graphics.Canvas;
import android.graphics.Color;

import com.example.rect.Data;

public class DeathParticle extends Particle {
    private int x;
    private int y;
    private int size;
    private int time;
    private float speed;
    private float speeding;
    private int color;
    private float speedX;
    private float speedY;

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.drawParticle(canvas);
    }

    private void drawParticle(Canvas canvas){
        if(this.time <= 0){
            return;
        }

        this.time--;
        this.speed += speeding;

        this.x += this.speed*this.speedX;
        this.y += this.speed*this.speedY;

        Data.paint.setColor(this.color);

        //canvas.translate(Data.myRect.getCurrentX(), Data.myRect.getCurrentY());
        canvas.drawRect(this.x-this.size, this.y-this.size, this.x+this.size, this.y+this.size, Data.paint);
    }

    public DeathParticle(int x, int y, int size, int time, float speed, float speeding, String color, float speedX, float speedY) {
        float sum = (float) Math.sqrt(Math.pow(speedX, 2)+Math.pow(speedY, 2));

        this.x = x;
        this.y = y;
        this.size = size/2;
        this.time = time;
        this.speed = speed;
        this.speeding = speeding;
        this.color = Color.parseColor(color);
        this.speedX = speedX/sum;
        this.speedY = speedY/sum;
    }
}
