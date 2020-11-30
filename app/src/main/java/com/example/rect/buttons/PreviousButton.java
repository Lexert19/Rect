package com.example.rect.buttons;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;

public class PreviousButton extends Button{
    private boolean active = false;
    private boolean showing = false;
    private boolean hiding = false;
    private Directions.Direction direction;


    private int firstX;
    private int firstY;
    private int x;
    private int y;
    private int currentTime = 0;
    private int time = 30;

    @Override
    public boolean click(int x, int y) {
        if(active == false){
            return false;
        }
        if(x<this.firstX-20 || x>this.firstX+200){
            return false;
        }
        if(y<this.firstY-40 || y>this.firstY){
            return false;
        }

        this.use();
        return true;
    }

    private void use(){
        Data.menu.currentLevelsSet.hideSet(Directions.Direction.DOWN);
        Data.menu.currentLevelsSet.showPreviousSet(Directions.Direction.UP);
    }

    @Override
    public void draw(Canvas canvas) {
        this.drawButton(canvas);
        this.drawHiding(canvas);
        this.drawShowing(canvas);
    }

    private void drawButton(Canvas canvas){
        if(this.active == false){
            return;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText("Previous",  firstX, firstY, Data.paint);
    }

    private void drawHiding(Canvas canvas){
        if(this.hiding == false){
            return;
        }
        currentTime++;
        if(currentTime == time){
            currentTime = 0;
            hiding = false;
        }

        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText("Previous",  x, hiding_getY(), Data.paint);
    }

    private int hiding_getY(){
        if(this.direction == Directions.Direction.UP){
            this.y -= this.currentTime*2;
            return this.y;
        }else if(this.direction == Directions.Direction.DOWN){
            this.y += this.currentTime*2;
            return this.y;
        }
        return this.firstY;
    }

    private void drawShowing(Canvas canvas){
        if(this.showing == false){
            return;
        }
        currentTime++;
        if(currentTime == time){
            currentTime = 0;
            showing = false;
            active = true;
        }

        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText("Previous",  x, this.showing_getY(), Data.paint);
    }

    private int showing_getY(){
        if(this.direction == Directions.Direction.DOWN){
            this.y -= this.currentTime*2;
            return this.y+960;
        }else if(this.direction == Directions.Direction.UP){
            this.y += this.currentTime*2;
            return this.y-960;
        }
        return this.firstY;
    }

    @Override
    public void show(Directions.Direction direction) {
        this.showing = true;
        this.y = firstY;
        this.direction = direction;
    }

    @Override
    public void hide(Directions.Direction direction) {
        this.hiding = true;
        this.y = firstY;
        this.active = false;
        this.direction = direction;
    }

    public PreviousButton(int firstX, int firstY) {
        this.firstX = firstX;
        this.firstY = firstY;
        this.x = firstX;
    }
}
