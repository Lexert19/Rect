package com.example.rect.buttons;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;
import com.example.rect.levels.Level;

public class LevelBtn extends Button {
    private Level level;

    public LevelBtn(String text, int x, int y, Level level) {
        super(x,y);
        this.text = text;
        this.x = x;
        this.y = y;
        this.level = level;

        this.firstX = x;
        this.firstY = y;

        this.fontSize = 60;
    }

   /* @Override
    public void draw(Canvas canvas){
        this.drawButton(canvas);
        this.drawHiding(canvas);
        this.drawShowing(canvas);
    }*/

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

        Data.menu.currentLevelsSet.hideSet(Directions.Direction.UP);

        Data.currentLevel = level;
    }

    @Override
    protected void drawButton(Canvas canvas){
        if(active == false){
            return;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText(this.text+" "+level.collectedPoints()+"/"+level.getPoints(),  firstX, firstY, Data.paint);
    }


    @Override
    protected void drawShowing(Canvas canvas){
        if(showing == false){
            return;
        }
        currentTime++;
        if(currentTime == animationTime){
            currentTime = 0;
            showing = false;
            active = true;
        }

        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText(this.text+" "+level.collectedPoints()+"/"+level.getPoints(),  x, this.showing_getY(), Data.paint);
    }

    @Override
    protected void drawHiding(Canvas canvas){
        if(hiding == false){
            return;
        }
        currentTime++;
        if(currentTime == animationTime){
            currentTime = 0;
            hiding = false;
        }

        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);
        canvas.drawText(this.text+" "+level.collectedPoints()+"/"+level.getPoints(),  x, this.hiding_getY(), Data.paint);
    }
}
