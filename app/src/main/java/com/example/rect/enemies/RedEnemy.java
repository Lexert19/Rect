package com.example.rect.enemies;

import android.graphics.Color;

import com.example.rect.Data;
import com.example.rect.particles.DeathCircle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedEnemy extends Enemy {
    public RedEnemy(int x, int y, float speedX, float speedY) {
        super(x,y,speedX,speedY);
        this.color = Color.parseColor("#ff6464");
    }

    @Override
    public void kill(){
        DeathCircle deathCircle = new DeathCircle("#55ff6464", this.x, this.y+24, 6, 10);
        Data.particles.add(deathCircle);
        Data.myRect.damage(1);
        this.playDash();
    }
}

