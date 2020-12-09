package com.example.rect.buttons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;
import com.example.rect.R;

public class BackBtn extends Button{
    public BackBtn(int firstX, int firstY) {
        super(firstX, firstY);
        this.text = "<--";
        this.fontSize = 60;


        icon = BitmapFactory.decodeResource(Data.context.getResources(), R.drawable.leftarrow);
        icon = Bitmap.createScaledBitmap(icon, 80, 80, false);
    }

    @Override
    public void draw(Canvas canvas) {
        drawIcon(canvas);
    }

    @Override
    public boolean click(int x, int y) {
        if(active == false){
            return false;
        }
        if(x<this.firstX-20 || x>this.firstX+120){
            return false;
        }
        if(y<this.firstY-10 || y>this.firstY+90){
            return false;
        }

        this.use();
        return true;
    }

    private void use(){
        Data.menu.hideSettingsSet(Directions.Direction.RIGHT);
        Data.menu.showMenu(Directions.Direction.LEFT);
    }


  /*  @Override
    protected void drawButton(Canvas canvas){
        if(this.active == false){
            return;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);

        canvas.drawBitmap(this.leftArrow, this.firstX, this.firstY, Data.paint);
    }

    @Override
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
        Data.paint.setTextSize(60);
        canvas.drawBitmap(this.leftArrow, this.hiding_getX(), this.hiding_getY(), Data.paint);
    }

    @Override
    protected void drawShowing(Canvas canvas){
        if(this.showing == false){
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
        canvas.drawBitmap(this.leftArrow, this.showing_getX(), this.showing_getY(), Data.paint);
    }*/
}
