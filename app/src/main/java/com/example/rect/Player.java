package com.example.rect;

import android.media.AsyncPlayer;
import android.media.AudioManager;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;


public class Player implements Runnable {
    private int counter = 0;
    private Uri url ;
    private List<AsyncPlayer> asyncPlayers = new ArrayList<>();
    private boolean sound = true;

    public Player() {
        url = Uri.parse("android.resource://" + Data.context.getPackageName() + "/" + R.raw.dash);
        for(int i=0; i<7; i++){
            AsyncPlayer asyncPlayer = new AsyncPlayer("");
            asyncPlayers.add(asyncPlayer);
        }
    }

    public void playDash() {
        if(counter == 7){
            counter = 0;
        }
        this.asyncPlayers.get(counter).play(Data.context, url, false, AudioManager.STREAM_MUSIC);
        counter++;

    }

    @Override
    public void run() {
        while (true){
            try {
                int msg = Data.playerQueue.take();
                if(msg == 0){
                    this.sound = false;
                }else if(msg == 1){
                    this.sound = true;
                }else if(msg == 2){
                    if(this.sound){
                        this.playDash();
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
