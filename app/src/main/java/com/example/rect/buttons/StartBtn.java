package com.example.rect.buttons;

import com.example.rect.Data;

public class StartBtn extends Button {
    public StartBtn(int firstX, int firstY) {
        super(firstX,firstY);
        this.active = true;

        this.text = "Start";
        this.fontSize = 90;
    }

    public boolean click(int x, int y){
        if(active == false){
            return false;
        }
        if(x<Data.gameWidth/2-120 || x>Data.gameWidth/2+120){
            return false;
        }
        if(y<Data.gameHeight/2-120 || y>Data.gameHeight/2+20){
            return false;
        }

        this.use();
        return true;
    }

    private void use(){
        Data.menu.setCurrentLevelsSet(1);
        Data.menu.showCurrentLevelsSet();
        Data.menu.hideMenu(Directions.Direction.UP);
    }
}
