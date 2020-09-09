package com.dodgethis.main;

import java.awt.*;
import java.util.Random;

public class ProjectileEnemy extends GameObject{

    private Handler handler;
    Random r = new Random();

    public ProjectileEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (r.nextInt(5 - -5) + - 5); //Generates random number between -5 & 5
        velY = 5;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        //if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;

        if(y >= Game.HEIGHT) handler.removeObject(this); //Removes projectile once it is off-screen

        //Enemy goes in opp direction when it hits bounds

        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.magenta, 16, 16, 0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
