package com.example.rect;

import android.graphics.Canvas;

import com.example.rect.buttons.LevelBtn;
import com.example.rect.buttons.StartBtn;
import com.example.rect.labels.Points;
import com.example.rect.levels.Level1;
import com.example.rect.levels.Level2;
import com.example.rect.levels.Level3;
import com.example.rect.levels.Level4;

public class Menu {
    private Points points = new Points();
    private StartBtn startBtn = new StartBtn();

    private LevelBtn level1;
    private LevelBtn level2;
    private LevelBtn level3;
    private LevelBtn level4;

    public Menu() {
        this.level1 = new LevelBtn("Level 1", Data.gameWidth/2-170, Data.gameHeight/2-150, new Level1());
        this.level2 = new LevelBtn("Level 2", Data.gameWidth/2-170, Data.gameHeight/2-50, new Level2());
        this.level3 = new LevelBtn("Level 3", Data.gameWidth/2-170, Data.gameHeight/2+50, new Level3());
        this.level4 = new LevelBtn("Level 4", Data.gameWidth/2-170, Data.gameHeight/2+150, new Level4());
    }

    public void click(int x, int y){
        if(this.startBtn.click(x,y) == true){
           showLevels();
        }
        if(level1.click(x,y)){
            hideLevels();
        }
        if(level2.click(x,y)){
            hideLevels();
        }
        if(level3.click(x,y)){
            hideLevels();
        }
        if(level4.click(x,y)){
            hideLevels();
        }
    }

    public void showLevels(){
        level1.setShowing(true);
        level2.setShowing(true);
        level3.setShowing(true);
        level4.setShowing(true);
    }

    private void hideLevels(){
        level1.setHiding(true);
        level2.setHiding(true);
        level3.setHiding(true);
        level4.setHiding(true);
    }

    public void draw(Canvas canvas){
        this.level1.draw(canvas);
        this.level2.draw(canvas);
        this.level3.draw(canvas);
        this.level4.draw(canvas);

        this.startBtn.draw(canvas);
        this.points.draw(canvas);
    }


}
