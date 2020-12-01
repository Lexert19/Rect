package com.example.rect.enemies;

import android.graphics.Color;

import com.example.rect.Data;
import com.example.rect.particles.DeathCircle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlueEnemy extends Enemy {
    public BlueEnemy(int x, int y, float speedX, float speedY) {
        super(x,y,speedX,speedY);
        this.color = Color.parseColor("#6464ff");

    }

    @Override
    public void kill(){
        DeathCircle deathCircle = new DeathCircle("#556464ff", this.x, this.y+24, 6, 10);
        Data.particles.add(deathCircle);
        Data.levelSPoints++;
        this.playDash();
    }
}
