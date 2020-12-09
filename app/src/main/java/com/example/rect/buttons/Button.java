package com.example.rect.buttons;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import com.example.rect.Data;

public class Button {
    protected Directions.Direction direction;
    protected int currentTime;
    protected int firstX;
    protected int firstY;
    protected int x;
    protected int y;
    protected int animationTime = 30;

    protected String text;
    protected int fontSize = 60;

    protected boolean active = false;
    protected boolean showing = false;
    protected boolean hiding = false;

    protected Bitmap icon;

    public Button(int firstX, int firstY) {
        this.firstX = firstX;
        this.firstY = firstY;
        this.x = firstX;
        this.y = firstY;
    }

    public boolean click(int x, int y){
        return false;
    }

    public void hide(Directions.Direction direction){
        this.hiding = true;
        this.active = false;
        this.x = firstX;
        this.y = firstY;
        this.direction = direction;
    }

    public void show(Directions.Direction direction){
        this.showing = true;
        this.y = firstY;
        this.x = firstX;
        this.direction = direction;
    }

    public void draw(Canvas canvas){
        this.drawButton(canvas);
        this.drawShowing(canvas);
        this.drawHiding(canvas);
    }

    public void drawIcon(Canvas canvas){
        this.drawIconActive(canvas);
        this.drawIconShowing(canvas);
        this.drawIconHiding(canvas);
    }

    protected void drawIconActive(Canvas canvas){
        if(this.active == false){
            return;
        }
        canvas.drawBitmap(icon, firstX, firstY, Data.paint);
    }

    protected void drawIconShowing(Canvas canvas){
        if(showing == false){
            return;
        }
        currentTime++;
        if(currentTime == animationTime){
            showing = false;
            currentTime = 0;
            active = true;
        }
        canvas.drawBitmap(icon, showing_getX(), showing_getY(), Data.paint);
    }

    protected void drawIconHiding(Canvas canvas){
        if(this.hiding == false){
            return;
        }
        currentTime++;
        if(currentTime == animationTime){
            currentTime = 0;
            hiding = false;
        }
        canvas.drawBitmap(icon, hiding_getX(), hiding_getY(), Data.paint);
    }

    protected void drawShowing(Canvas canvas){
        if(showing == false){
            return;
        }
        currentTime++;
        if(currentTime == animationTime){
            showing = false;
            currentTime = 0;
            active = true;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(fontSize);
        canvas.drawText(text, this.showing_getX(), this.showing_getY(), Data.paint);
    }

    protected void drawButton(Canvas canvas){
        if(this.active == false){
            return;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(fontSize);
        canvas.drawText(text,  firstX, firstY, Data.paint);
    }

    protected void drawHiding(Canvas canvas){
        if(this.hiding == false){
            return;
        }
        currentTime++;
        if(currentTime == animationTime){
            currentTime = 0;
            hiding = false;
        }

        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(fontSize);
        canvas.drawText(text,  hiding_getX(), hiding_getY(), Data.paint);
    }

    protected int showing_getY(){
        if(this.direction == Directions.Direction.DOWN){
            this.y -= this.currentTime*2;
            return this.y+960;
        }else if(this.direction == Directions.Direction.UP){
            this.y += this.currentTime*2;
            return this.y-960;
        }
        return this.firstY;
    }

    protected int showing_getX(){
        if(this.direction == Directions.Direction.RIGHT){
            this.x -= this.currentTime*3;
            return this.x+1440;
        }else if(this.direction == Directions.Direction.LEFT){
            this.x += this.currentTime*3;
            return this.x-1440;
        }
        return this.firstX;
    }

    protected int hiding_getX(){
        if(this.direction == Directions.Direction.RIGHT){
            this.x += this.currentTime*3;
            return this.x;
        }else if(this.direction == Directions.Direction.LEFT){
            this.x -= this.currentTime*3;
            return this.x;
        }
        return this.firstX;
    }

    protected int hiding_getY(){
        if(direction == Directions.Direction.UP){
            y -= currentTime*2;
            return y;
        }else if(direction == Directions.Direction.DOWN){
            y += currentTime*2;
            return y;
        }
        return firstY;
    }

}
