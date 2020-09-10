package com.dodgethis.main;

import java.awt.*;

public class SmartEnemy extends GameObject{

    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
        }

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8; //8 is to adjust for player object size
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        //Mathematical formula to calculate distance

        velX = (float) ((-1/distance) * diffX * 1.5);
        velY = (float) ((-1/distance) * diffY * 1.5);
        //Enemy tracks & chases player

        if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
        //Enemy goes in opp direction when it hits bounds

        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.green, 16, 16, 0.04f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
