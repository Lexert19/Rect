package com.example.rect.Menu;

import android.graphics.Canvas;

import com.example.rect.Data;
import com.example.rect.buttons.Button;
import com.example.rect.buttons.Directions;
import com.example.rect.buttons.NextButton;
import com.example.rect.buttons.PreviousButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelsSet {
    private List<Button> buttons = new LinkedList<>();
    private int setNumber;

    public boolean click(int x, int y){
        for(Button button : buttons){
            button.click(x,y);
           /* if(button.click(x,y)==true){
                if(button instanceof NextButton){
                    this.showNextSet(Directions.Direction.DOWN);
                    this.hideSet(Directions.Direction.UP);
                }else if(button instanceof PreviousButton){
                    this.showPreviousSet(Directions.Direction.UP);
                    this.hideSet(Directions.Direction.DOWN);
                }else {
                    this.hideSet(Directions.Direction.UP);
                }
                return true;
            }*/
        }
        return false;
    }

    public void showNextSet(Directions.Direction direction){
        Data.menu.showLevelsSet(this.setNumber+1,direction);
        Data.menu.setCurrentLevelsSet(this.setNumber+1);
    }

    public void showPreviousSet(Directions.Direction direction){
        Data.menu.showLevelsSet(this.setNumber-1,direction);
        Data.menu.setCurrentLevelsSet(this.setNumber-1);
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

    public LevelsSet(int setNumber) {
        this.setNumber = setNumber;
    }
}
