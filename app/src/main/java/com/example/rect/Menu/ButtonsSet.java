package com.example.rect.Menu;

import android.graphics.Canvas;

import com.example.rect.buttons.Button;
import com.example.rect.buttons.Directions;

import java.util.LinkedList;
import java.util.List;

public class ButtonsSet {
    protected List<Button> buttons = new LinkedList<>();

    public boolean click(int x, int y){
        return false;
    }

    public void showSet(Directions.Direction direction){
        for(Button button : buttons){
            button.show(direction);
        }
    }

    public void hideSet(Directions.Direction direction){
        for(Button button : buttons){
            button.hide(direction);
        }
    }

    public void addButton(Button button){
        this.buttons.add(button);
    }

    public void draw(Canvas canvas){
        for(Button button : buttons){
            button.draw(canvas);
        }
    }
}
