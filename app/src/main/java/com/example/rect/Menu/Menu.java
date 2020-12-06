package com.example.rect.Menu;

import android.graphics.Canvas;

import com.example.rect.Data;
import com.example.rect.buttons.BackBtn;
import com.example.rect.buttons.Button;
import com.example.rect.buttons.Directions;
import com.example.rect.buttons.LevelBtn;
import com.example.rect.buttons.LevelsBack;
import com.example.rect.buttons.NextButton;
import com.example.rect.buttons.PreviousButton;
import com.example.rect.buttons.SettingsBtn;
import com.example.rect.buttons.SoundBtn;
import com.example.rect.buttons.StartBtn;
import com.example.rect.labels.Points;
import com.example.rect.levels.Level1;
import com.example.rect.levels.Level2;
import com.example.rect.levels.Level3;
import com.example.rect.levels.Level4;
import com.example.rect.levels.Level5;
import com.example.rect.levels.Level6;
import com.example.rect.levels.Level7;
import com.example.rect.levels.Level8;

public class Menu {
    private Points points = new Points();

    private MenuSet menuSet = new MenuSet();
    private SettingsSet settingsSet = new SettingsSet();

    private LevelsSet levelsSet1 = new LevelsSet(1);
    private LevelsSet levelsSet2 = new LevelsSet(2);
    public LevelsSet currentLevelsSet;

    public Menu() {
        this.createMenuSet();
        this.createLevelsSet1();
        this.createLevelsSet2();
        this.createSettingsSet();
    }

    public void click(int x, int y){
        this.menuSet.click(x,y);
        this.levelsSet1.click(x,y);
        this.levelsSet2.click(x,y);
        this.settingsSet.click(x,y);
    }

    public void setCurrentLevelsSet(int number){
        if (number == 1){
            this.currentLevelsSet = this.levelsSet1;
        }else if(number == 2){
            this.currentLevelsSet = this.levelsSet2;
        }
    }

    public void hideSettingsSet(Directions.Direction direction){
        this.settingsSet.hideSet(direction);
    }

    public void showMenu(Directions.Direction direction){
        this.menuSet.showSet(direction);
    }

    public void showSettingsSet(Directions.Direction direction){
        this.settingsSet.showSet(direction);
    }

    public void hideMenu(Directions.Direction direction){
        this.menuSet.hideSet(direction);
    }

    public void showCurrentLevelsSet(){
        this.currentLevelsSet.showSet(Directions.Direction.DOWN);
    }

    public void showLevelsSet(int number, Directions.Direction direction){
        switch (number){
            case 1:{
                this.levelsSet1.showSet(direction);
                break;
            }
            case 2:{
                this.levelsSet2.showSet(direction);
                break;
            }
        }
    }

    private void createSettingsSet(){
        Button sound = new SoundBtn(Data.gameWidth/2-170, Data.gameHeight/2-150);
        Button back = new BackBtn(20, Data.gameHeight-30);

        this.settingsSet.addButton(sound);
        this.settingsSet.addButton(back);
    }

    private void createMenuSet(){
        Button settings = new SettingsBtn(Data.gameWidth-100, Data.gameHeight-90);
        Button start =  new StartBtn(Data.gameWidth/2-100, Data.gameHeight/2);

        this.menuSet.addButton(settings);
        this.menuSet.addButton(start);
    }

    private void createLevelsSet1(){
        Button level1 = new LevelBtn("Level 1", Data.gameWidth/2-170, Data.gameHeight/2-150, new Level1());
        Button level2 = new LevelBtn("Level 2", Data.gameWidth/2-170, Data.gameHeight/2-50, new Level2());
        Button level3 = new LevelBtn("Level 3", Data.gameWidth/2-170, Data.gameHeight/2+50, new Level3());
        Button level4 = new LevelBtn("Level 4", Data.gameWidth/2-170, Data.gameHeight/2+150, new Level4());
        Button back = new LevelsBack(20, Data.gameHeight-20);
        Button next = new NextButton(Data.gameWidth/2-30, Data.gameHeight/2+250);

        this.levelsSet1.addButton(level1);
        this.levelsSet1.addButton(level2);
        this.levelsSet1.addButton(level3);
        this.levelsSet1.addButton(level4);
        this.levelsSet1.addButton(next);
        this.levelsSet1.addButton(back);
    }

    private void createLevelsSet2(){
        Button level1 = new LevelBtn("Level 5", Data.gameWidth/2-170, Data.gameHeight/2-150, new Level5());
        Button level2 = new LevelBtn("Level 6", Data.gameWidth/2-170, Data.gameHeight/2-50, new Level6());
        Button level3 = new LevelBtn("Level 7", Data.gameWidth/2-170, Data.gameHeight/2+50, new Level7());
        Button level4 = new LevelBtn("Level 8", Data.gameWidth/2-170, Data.gameHeight/2+150, new Level8());
        Button back = new LevelsBack(20, Data.gameHeight-30);
        Button previous = new PreviousButton(Data.gameWidth/2-20, Data.gameHeight/2-250);

        this.levelsSet2.addButton(level1);
        this.levelsSet2.addButton(level2);
        this.levelsSet2.addButton(level3);
        this.levelsSet2.addButton(level4);
        this.levelsSet2.addButton(previous);
        this.levelsSet2.addButton(back);
    }

    public void draw(Canvas canvas){
        this.levelsSet1.draw(canvas);
        this.levelsSet2.draw(canvas);

        this.menuSet.draw(canvas);
        this.settingsSet.draw(canvas);

        this.points.draw(canvas);
    }


}
