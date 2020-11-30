package com.example.rect.Menu;

import android.graphics.Canvas;

import com.example.rect.buttons.Button;
import com.example.rect.buttons.Directions;

import java.util.LinkedList;
import java.util.List;

public class MenuSet {
    private List<Button> buttons = new LinkedList<>();

    public boolean click(int x, int y){
        for(Button button : buttons){
            button.click(x,y);
        }
        return false;
    }

    public void draw(Canvas canvas){
        for(Button button : buttons){
            button.draw(canvas);
        }
    }

    public void hide(Directions.Direction direction){
        for(Button button : buttons){
            button.hide(direction);
        }
    }

    public void show(Directions.Direction direction){
        for(Button button : buttons){
            button.hide(direction);
        }
    }

    public void addButton(Button button){
        this.buttons.add(button);
    }

}
