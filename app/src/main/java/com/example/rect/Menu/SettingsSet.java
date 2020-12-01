package com.example.rect.Menu;

import com.example.rect.buttons.Button;

public class SettingsSet extends ButtonsSet {
    public boolean click(int x, int y){
        for(Button button : buttons){
            button.click(x,y);
        }
        return false;
    }
}
