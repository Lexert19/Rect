package com.example.rect;

import android.graphics.Color;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.rect.Menu.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyCanvas myCanvas;
    private VelocityTracker mVelocityTracker = VelocityTracker.obtain();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getHeightAndWidth();

        this.loadData();
        this.createPlayer();
        Data.menu = new Menu();
        this.createCanvasAndGame();
    }

    private void loadData(){
        Data.listOfPoints = new ArrayList<Integer>(9);
        for(int i=0; i<9; i++){
            Data.listOfPoints.add(i,0);
        }
    }

    private void createCanvasAndGame(){
        myCanvas = new MyCanvas(this);

        DrawerLayout.LayoutParams layoutParams = new DrawerLayout.LayoutParams(Data.gameWidth, Data.gameHeight);
        int left = (Data.deviceWidth-Data.gameWidth)/2;
        int top = (Data.deviceHeight-Data.gameHeight)/2;
        layoutParams.setMargins(left, top, 0, 0);

        myCanvas.setLayoutParams(layoutParams);
        myCanvas.setScaleX((float) Data.deviceWidth/Data.gameWidth);
        myCanvas.setScaleY((float) Data.deviceHeight/Data.gameHeight);

        myCanvas.setBackgroundColor(Color.BLACK);
        setContentView(myCanvas);

        Thread game = new Thread(new Game(myCanvas));
        game.start();
    }

    private void createPlayer(){
        Data.context = this;
        Thread player = new Thread(new Player());
        player.start();
    }

    private void getHeightAndWidth(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Data.deviceHeight = displayMetrics.heightPixels;
        Data.deviceWidth = displayMetrics.widthPixels;
        Log.i("dgf",""+Data.deviceHeight);
        Log.i("dgf",""+Data.deviceWidth);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                this.clicked(event.getX(), event.getY());
                scaleAndSendTouch(event.getX(), event.getY());

                break;

            case MotionEvent.ACTION_MOVE:
                scaleAndSendTouch(event.getX(), event.getY());
                break;
        }
        return true;
    }

    private void clicked(float x, float y){
        int scaledX = (int) (x/Data.deviceWidth * Data.gameWidth);
        int scaledY = (int) (y/Data.deviceHeight * Data.gameHeight);
        Data.menu.click(scaledX, scaledY);
    }

    private void scaleAndSendTouch(float x, float y){
        int scaledX = (int) (x/Data.deviceWidth * Data.gameWidth);
        int scaledY = (int) (y/Data.deviceHeight * Data.gameHeight);
        Data.myRect.setX(scaledX);
        Data.myRect.setY(scaledY);
    }
}