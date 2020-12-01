package com.example.rect.buttons;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

import com.example.rect.Data;

public class SoundBtn extends Button {
    public boolean sound = true;

    public SoundBtn(int firstX, int firstY) {
        super(firstX, firstY);
        this.text = "Sound: On";
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
        try {
            if(Data.playerQueue.size() == 0){
                if(sound){
                    Data.playerQueue.put(0);
                    sound = false;
                }else if(!sound){
                    Data.playerQueue.put(1);
                    sound = true;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(sound){
            text = "Sound: On";
        }else{
            text = "Sound: Off";
        }
        Log.i("gs",this.text);
    }

  /*  protected void drawShowing(Canvas canvas){
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
    }*/

}
