package com.dodgethis.main;

import java.awt.*;

public class HUD {

    public static int HP = 100;

    public void tick(){
        HP = Game.clamp(HP, 0, 100);
    }

    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HP * 2,32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200,32);
    }

}
