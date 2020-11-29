package com.example.rect;

import android.content.Context;
import android.content.Intent;
import android.media.AsyncPlayer;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.ContextCompat.startActivity;


public class Player implements Runnable {
    private int counter = 0;
    private Uri url ;
    private List<AsyncPlayer> asyncPlayers = new ArrayList<>();

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
                Data.queue.take();
                this.playDash();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}
