package com.example.rect.buttons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.rect.Data;
import com.example.rect.R;

public class NextButton extends Button{
    public NextButton(int firstX, int firstY) {
        super(firstX,firstY);

        this.text = "\\/";
        this.fontSize = 60;

        icon = BitmapFactory.decodeResource(Data.context.getResources(), R.drawable.arrowdown);
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
        if(x<this.firstX-10 || x>this.firstX+90){
            return false;
        }
        if(y<this.firstY-10 || y>this.firstY+90){
            return false;
        }

        this.use();
        return true;
    }

    private void use(){
        Data.menu.currentLevelsSet.hideSet(Directions.Direction.UP);
        Data.menu.currentLevelsSet.showNextSet(Directions.Direction.DOWN);
    }


}
