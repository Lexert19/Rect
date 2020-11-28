package com.example.rect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

import com.example.rect.enemies.Enemy;
import com.example.rect.particles.Particle;

public class MyCanvas extends View {
    public MyCanvas(Context context) {

        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.drawAll(canvas);


        try {
            Data.start.put(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void drawAll(Canvas canvas){
        try{
            if (Data.currentLevel != null) {
                Data.currentLevel.tick();
            }
            Data.myRect.draw(canvas);
            for (Enemy enemy : Data.enemies) {
                enemy.draw(canvas);
            }
            for (Particle particle : Data.particles) {
                particle.draw(canvas);
            }
            Data.menu.draw(canvas);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
