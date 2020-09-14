package com.dodgethis.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {

    Handler handler;
    HUD hud;

    public int B1 = 500;
    public int B2 = 500;
    public int B3 = 100;

    public Shop(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.BOLD, 48));
        g.drawString("SHOP", Game.WIDTH/2-100, 50);

        //box 1
        g.setFont(new Font("arial", Font.PLAIN, 12));
        g.drawString("Upgrade Max HP", 110, 120);
        g.drawString("Cost: " + B1, 110, 140);
        g.drawRect(100, 100, 100, 80);

        //box 2
        g.drawString("Upgrade Speed", 260, 120);
        g.drawString("Cost: " + B2, 260, 140);
        g.drawRect(250, 100, 100, 80);

        //box 3
        g.drawString("Recover HP", 410, 120);
        g.drawString("Cost: " + B3, 410, 140);
        g.drawRect(400, 100, 100, 80);

        g.drawString("SCORE: " + hud.getScore(), Game.WIDTH/2-50, 300);
        g.drawString("Press SPACE to return", Game.WIDTH/2-50, 330);
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //Mouse press bounds to toggle box 1
        if(mx >= 100 && mx <= 200){
            if(my >= 100 && my <= 180){
                // System.out.println("Box 1"); for debugging
                if(hud.getScore() >= B1){
                    hud.setScore(hud.getScore() - B1);
                    B1 += 500;
                    hud.bounds += 20;
                    hud.HP = 100 + (hud.bounds)/2;
                }
            }
        }

        //mouse press bounds to toggle box 2
        if(mx >= 250 && mx <= 350){
            if(my >= 100 && my <= 180){
                if(hud.getScore() >= B2){
                    hud.setScore(hud.getScore() - B2);
                    B2 += 500;
                    handler.spd++;
                }
            }
        }

        //mouse press bounds to toggle box 3
        if(mx >= 400 && mx <= 500){
            if(my >= 100 && my <= 180){
                if(hud.getScore() >= B3){
                    hud.setScore(hud.getScore() - B3);
                    B3 = B3*2;
                    hud.HP = 100 + (hud.bounds)/2;
                }
            }
        }
    }

}
