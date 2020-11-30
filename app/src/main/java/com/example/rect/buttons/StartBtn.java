package com.example.rect.buttons;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;

public class StartBtn extends Button {
    private boolean active = true;
    private boolean hiding = false;
    private boolean showing = false;

    private int x;
    private int y;

    private int showingTime = 30;
    private int currentTime = 0;

    public StartBtn() {
        this.x = (Data.gameWidth/2)-100;
        this.y = Data.gameHeight/2;
    }

    public void draw(Canvas canvas){
        this.drawButton(canvas);
        this.drawShowing(canvas);
        this.drawHiding(canvas);
    }

    public boolean click(int x, int y){
        if(active == false){
            return false;
        }
        if(x<Data.gameWidth/2-120 || x>Data.gameWidth/2+120){
            return false;
        }
        if(y<Data.gameHeight/2-120 || y>Data.gameHeight/2+20){
            return false;
        }

        hiding = true;
        active = false;
        return true;
    }

    private void drawButton(Canvas canvas){
        if(active == false){
            return;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(90);
        canvas.drawText("Start",  x, y, Data.paint);
    }

    private void drawShowing(Canvas canvas){
        if(showing == false){
            return;
        }
        currentTime++;
        if(currentTime == showingTime){
            showing = false;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(90);
        canvas.drawText("Start", x, currentTime*30+y, Data.paint);
    }

    private void drawHiding(Canvas canvas){
        if(hiding == false){
            return;
        }
        currentTime++;
        if(currentTime == showingTime){
            hiding = false;
        }
        this.y -= currentTime*2;
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(90);
        canvas.drawText("Start", x, y, Data.paint);

    }
}
