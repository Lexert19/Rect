package com.example.rect.labels;

import android.graphics.Canvas;
import android.graphics.Color;

import com.example.rect.Data;

public class Points {
    public void draw(Canvas canvas){
        Data.paint.setColor(Color.RED);
        Data.paint.setTextSize(36);
        canvas.drawText(String.valueOf(Data.levelSPoints)+"  "+Data.fps, 36, 36, Data.paint);
    }
}
