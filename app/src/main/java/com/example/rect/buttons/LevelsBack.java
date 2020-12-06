package com.example.rect.buttons;

import android.graphics.Canvas;

import com.example.rect.Data;

public class LevelsBack extends Button {
    public LevelsBack(int firstX, int firstY) {
        super(firstX, firstY);
        this.text = "<--";
        this.fontSize = 50;
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
        Data.menu.currentLevelsSet.hideSet(Directions.Direction.DOWN);
        Data.menu.showMenu(Directions.Direction.UP);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
