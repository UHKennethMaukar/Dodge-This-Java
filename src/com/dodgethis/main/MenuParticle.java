package com.dodgethis.main;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject{

    private Handler handler;

    Random r = new Random();

    private Color col;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (r.nextInt(7 - -7) + - 7); //Generates random number between -5 & 5
        velY = (r.nextInt(7 - -7) + - 7);
        if(velX == 0) velX = (r.nextInt(7 - -7) + - 7);
        if(velY == 0) velY = (r.nextInt(7 - -7) + - 7);

        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)); //To set random colors

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

        handler.addObject(new Trail((int)x, (int)y, ID.Trail, col, 16, 16, 0.05f, handler));
    }

    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
