package com.dodgethis.main;

import java.awt.*;

public class HUD {

    public static float HP = 100;
    // private float greenValue = 255; //RGB green value set to max

    private int score = 0;
    private int level = 1;

    public void tick(){
        HP = Game.clamp(HP, 0, 100);

        //greenValue = Game.clamp(greenValue, 0, 255);
        //greenValue = HP*2;

        score++; //Score increases with time
    }

    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.getHSBColor( (1f * HP) / 360, 1f, 1f)); //HP bar color transitions with change in hp
        g.fillRect(15, 15, (int) HP * 2,32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200,32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);
    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

}
