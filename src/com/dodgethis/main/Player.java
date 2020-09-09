package com.dodgethis.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random(); //Randomizer
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 35);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);

        // handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.1f, handler));

        collision();
    }

    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //Collision code, triggers when player object hit-box intersects with that of temp object (basic enemy)
                    HUD.HP -= 2;
                }
            }

        }
    }

    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g; //For hit-box generation, visual test code commented below
        //g.setColor(Color.green);
        //g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }



}
