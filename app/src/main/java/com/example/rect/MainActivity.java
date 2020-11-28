package com.example.rect;

import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {
    private MyCanvas myCanvas;
    private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
    private SoundPool soundPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getHeightAndWidth();

        Data.menu = new Menu();

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            this.soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attributes)
                    .build();
        } else {
            this.soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        }

        int soundId = soundPool.load(this, R.raw.dash, 1);
        this.soundPool.play(soundId, 1,1,1,0,1f);*/

        this.createPlayer();
        this.createCanvasAndGame();
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
        //Data.player = new Player();
    }

    private void getHeightAndWidth(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Data.deviceHeight = displayMetrics.heightPixels;
        Data.deviceWidth = displayMetrics.widthPixels;
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