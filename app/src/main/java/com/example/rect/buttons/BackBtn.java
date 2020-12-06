package com.example.rect.buttons;

import android.graphics.Canvas;
import android.util.Log;

import com.example.rect.Data;

public class BackBtn extends Button{
    public BackBtn(int firstX, int firstY) {
        super(firstX, firstY);
        this.text = "<--";
        this.fontSize = 60;
    }

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
        Data.menu.hideSettingsSet(Directions.Direction.RIGHT);
        Data.menu.showMenu(Directions.Direction.LEFT);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
