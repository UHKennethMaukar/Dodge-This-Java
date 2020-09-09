package com.dodgethis.main;

import java.awt.*;

public class FastEnemy extends GameObject{

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 2;
        velY = 7;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
        //Enemy goes in opp direction when it hits bounds

        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.cyan, 16, 16, 0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}