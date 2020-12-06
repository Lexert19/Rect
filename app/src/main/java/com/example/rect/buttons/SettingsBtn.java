package com.example.rect.buttons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;
import com.example.rect.R;

public class SettingsBtn extends Button{
    private Bitmap gear;

    public SettingsBtn(int firstX, int firstY) {
        super(firstX, firstY);
        this.active = true;

        this.gear = BitmapFactory.decodeResource(Data.context.getResources(), R.drawable.settings);
        this.gear = Bitmap.createScaledBitmap(this.gear, 80, 80, false);
    }

    @Override
    public boolean click(int x, int y) {
        if(active == false){
            return false;
        }
        if(x<this.firstX-20 || x>this.firstX+100){
            return false;
        }
        if(y<this.firstY-20 || y>this.firstY+100){
            return false;
        }

        this.use();
        return true;
    }

    private void use(){
        Data.menu.showSettingsSet(Directions.Direction.RIGHT);
        Data.menu.hideMenu(Directions.Direction.LEFT);
    }

    @Override
    protected void drawButton(Canvas canvas){
        if(this.active == false){
            return;
        }
        Data.paint.setColor(Color.WHITE);
        Data.paint.setTextSize(60);

        canvas.drawBitmap(this.gear, this.firstX, this.firstY, Data.paint);
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
        canvas.drawBitmap(this.gear, this.hiding_getX(), this.hiding_getY(), Data.paint);
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
        canvas.drawBitmap(this.gear, this.showing_getX(), this.showing_getY(), Data.paint);
    }
}
