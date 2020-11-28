package com.example.rect;

import android.content.Context;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.rect.enemies.Enemy;
import com.example.rect.levels.Level;
import com.example.rect.particles.Particle;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Data {
    public static MyRect myRect = new MyRect(700, 350, 700 ,350);
    public static Paint paint = new Paint();
    public static LinkedList<Enemy> enemies = new LinkedList<>();
    public static LinkedList<Particle> particles = new LinkedList<>();

    public static Menu menu = new Menu();

    public static Context context;
    public static Player player;

    public static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    public static BlockingQueue<Boolean> start = new LinkedBlockingQueue<>();

    public static int levelSPoints = 0;
    public static Level currentLevel = null;
    public static boolean end = false;

    public static int gameWidth = 1400;
    public static int gameHeight = 700;

    public static int fps = 0;
    public static boolean drawing = false;

    public static int deviceWidth = 0;
    public static int deviceHeight = 0;

    public static int lvl1Points = 0;
    public static int lvl2Points = 0;
    public static int lvl3Points = 0;
    public static int lvl4Points = 0;
}
