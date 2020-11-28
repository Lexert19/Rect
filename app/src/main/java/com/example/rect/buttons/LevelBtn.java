package com.example.rect.buttons;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;
import com.example.rect.levels.Level;

public class LevelBtn {
    private String text;
    private int firstX;
    private int firstY;
    private int x;
    private int y;

    private Level level;

    private boolean active = false;
    private boolean showing = false;
    private boolean hiding = false;

    private int time = 30;
    private int currentTime = 0;

    public void draw(Canvas canvas){
        this.drawLevel(canvas);
        this.drawHiding(canvas);
        this.drawShowing(canvas);
    }

    public boolean click(int x, int y){
        if(active == false){
            return false;
        }
        if(x<this.firstX-20 || x>this.firstX+470){
            return false;
        }
        if(y<this.firstY-40 || y>this.firstY){
            return false;
        }

        this.use();
        return true;
    }

    public void use(){
        active = false;
        hiding = true;
        this.y = firstY;

        Data.currentLevel = level;
    }

    private void drawLevel(Canvas canvas){
        if(active == false){
            return;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText(this.text+" "+level.collectedPoints()+"/"+level.getPoints(),  firstX, firstY, Data.paint);
    }


    private void drawShowing(Canvas canvas){
        if(showing == false){
            return;
        }
        currentTime++;
        if(currentTime == time){
            currentTime = 0;
            showing = false;
            active = true;
        }
        this.y -= currentTime*2;
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText(this.text+" "+level.collectedPoints()+"/"+level.getPoints(),  x, y+960, Data.paint);
    }

    private void drawHiding(Canvas canvas){
        if(hiding == false){
            return;
        }
        currentTime++;
        if(currentTime == time){
            currentTime = 0;
            hiding = false;
        }
        this.y -= currentTime*2;
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText(this.text+" "+level.collectedPoints()+"/"+level.getPoints(),  x, y, Data.paint);
    }

    public LevelBtn(String text, int x, int y, Level level) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.level = level;

        this.firstX = x;
        this.firstY = y;
    }

    public boolean isShowing() {
        return showing;
    }

    public void setShowing(boolean showing) {
        this.showing = showing;
        this.y = firstY;
    }

    public boolean isHiding() {
        return hiding;
    }

    public void setHiding(boolean hiding) {
        this.hiding = hiding;
        this.y = firstY;
        this.active = false;
    }


}
