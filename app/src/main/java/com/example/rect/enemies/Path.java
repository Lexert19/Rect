package com.example.rect.enemies;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Point> points;
    private Enemy enemy;

    public Path(Enemy enemy) {
        this.points = new ArrayList<>();
        this.enemy = enemy;
    }

    public void move(){
        for(Point point : points){
            point.move();
        }
    }

    public void addPoint(int x, int y, int speed, int time){
        Point point = new Point(speed, x,y, time, this.enemy);
        points.add(point);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean isEmpty(){
        if(points.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
