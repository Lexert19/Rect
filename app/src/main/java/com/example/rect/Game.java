package com.example.rect;

import java.util.concurrent.TimeUnit;

public class Game implements Runnable{
    private MyCanvas myCanvas;
    private long framesTime= 0;
    private int frames= 0;
    private int counter = 0;

    public Game(MyCanvas myCanvas) {
        this.myCanvas = myCanvas;
    }

    @Override
    public void run() {
        while (true){
            this.frame();
        }
    }

    public void frame(){
       /* if(!gameSpeed(3)){
            this.myWait(0);
            return;
        }*/

        try {
            long start = System.currentTimeMillis();
            myCanvas.postInvalidate();
            Data.start.poll(2000, TimeUnit.MILLISECONDS);
            long stop = System.currentTimeMillis();
            long time = (stop - start);
            this.getFPS(time);
            this.myWait(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void myWait(long time){
        try {
            if(time < 17){
                Thread.sleep(17-time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean gameSpeed(int number){
        if(counter == number){
            counter = 0;
            return true;
        }else {
            counter++;
            return false;
        }
    }

    private void getFPS(long time){
        if(time<17){
            this.framesTime += 17;
        }else {
            this.framesTime += time;
        }
        this.frames += 1;
        if(this.framesTime > 1000){
            Data.fps = frames;
            this.frames = 0;
            this.framesTime = 0;
        }
    }


}
