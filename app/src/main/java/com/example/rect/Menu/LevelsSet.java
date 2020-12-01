package com.example.rect.Menu;

import com.example.rect.Data;
import com.example.rect.buttons.Button;
import com.example.rect.buttons.Directions;

public class LevelsSet extends ButtonsSet{
    private int setNumber;

    public LevelsSet(int setNumber) {
        this.setNumber = setNumber;
    }

    public boolean click(int x, int y){
        for(Button button : buttons){
            button.click(x,y);
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
}
