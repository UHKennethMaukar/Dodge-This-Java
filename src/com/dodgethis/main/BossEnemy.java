package com.dodgethis.main;

import java.awt.*;
import java.util.Random;

public class BossEnemy extends GameObject{

    private Handler handler;
    Random r = new Random();

    private int timer = 80;
    private int timer2 = 50;

    public BossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 0;
        velY = 3;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 96, 96);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(timer <= 0) {
            velY = 0;
            timer2--;
        }
        else timer--;

        if(timer2 <= 0){
            if (velX == 0) velX = 5;
            // if(velX > 0) velX += 0.05f;
            // else if(velX < 0) velX -= 0.05f; //Code for acceleration, redacted for now

            int spawn = r.nextInt(10);
            if (spawn == 0) handler.addObject(new ProjectileEnemy((int)x+48, (int)y+48, ID.BasicEnemy, handler));
        }

        if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1;
        //handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 96, 96, 0.008f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, 96, 96);
    }
}
