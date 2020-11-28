package com.example.rect.particles;

import android.graphics.Canvas;
import android.graphics.RectF;

import com.example.rect.Data;

public class DeathCircle extends Particle {
    private int color;
    private int x;
    private int y;
    private int speed;
    private int time;
    private int currentTime = 0;

    public DeathCircle(int color, int x, int y, int speed, int time) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.time = time;
    }

    @Override
    public void draw(Canvas canvas) {
        this.drawCircle(canvas);
        super.draw(canvas);
    }

    private void drawCircle(Canvas canvas){
        if(this.currentTime <= this.time){
            this.currentTime++;
            int a = this.currentTime;

            RectF oval = new RectF();
            oval.set(this.x -a*this.speed, this.y-a*this.speed, this.x +a*this.speed, this.y + a*this.speed );
            Data.paint.setColor(this.color);

            canvas.drawArc(oval,0, 360, false, Data.paint);

        }
    }
}
