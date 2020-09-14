package com.dodgethis.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private Shop shop;

    public Menu(Game game, Handler handler, HUD hud, Shop shop){
        this.game =  game;
        this.handler = handler;
        this.hud = hud;
        this.shop = shop;
    }

    public void mousePressed(MouseEvent e){ //Stores x & y coordinates of mouse press
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == Game.STATE.Menu){
            //Play button
            if(mouseOver(mx, my, 215, 150, 200, 64)){

                game.gameState = Game.STATE.Select;
                /* game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemies();
                // for(int i = 0; i < 10; i++) Sample loop to generate set number of game objects
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                 */

                return;
            }

            //Help button
            if(mouseOver(mx, my, 215, 250, 200, 64)){
                game.gameState = Game.STATE.Help;
                handler.clearEnemies();
            }

            //Quit button
            if(mouseOver(mx, my, 215, 350, 200, 64)){
                System.exit(1);
            }
        }

        if(game.gameState == Game.STATE.Select){
            //Classic difficulty button
            if(mouseOver(mx, my, 215, 150, 200, 64)){
                game.gameState = Game.STATE.Game;
                hud.bounds = 0;
                handler.spd = 5;
                shop.B1 = 500;
                shop.B2 = 500;
                shop.B3 = 100;

                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemies();
                // for(int i = 0; i < 10; i++) Sample loop to generate set number of game objects
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));

                game.diff = 0;
            }

            //Hardcore difficulty button
            if(mouseOver(mx, my, 215, 250, 200, 64)){
                game.gameState = Game.STATE.Game;
                hud.bounds = 0;
                handler.spd = 5;
                shop.B1 = 500;
                shop.B2 = 500;
                shop.B3 = 100;

                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemies();
                // for(int i = 0; i < 10; i++) Sample loop to generate set number of game objects
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));

                game.diff = 1;
            }

            //Back button
            if(mouseOver(mx, my, 215, 350, 200, 64)){
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

        //Back button for help menu
        if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 215, 350, 200, 64)){
                game.gameState = Game.STATE.Menu;
                for (int i = 0; i < 15; i++) {
                    handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
                }
            }
        }

        //Try Again button in Game Over screen
        if(game.gameState == Game.STATE.End){
            if(mouseOver(mx, my, 215, 350, 200, 64)){
                hud.setLevel(1);
                hud.setScore(0);
                game.gameState = Game.STATE.Menu;
            }
        }

    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            return my > y && my < y + height;
        } else return false;
    } //returns true when mouseOver location is within designated bounds, for button press area

    public void tick(){

    }

    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu) { //Convert to switch-case, possibly?
            Font fnt = new Font("arial", Font.BOLD, 50);
            Font fnt2 = new Font("arial", Font.BOLD, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Dodge This!", 175, 70);

            g.setFont(fnt2);
            g.drawRect(215, 150, 200, 64);
            g.drawString("Play", 280, 190);

            g.drawRect(215, 250, 200, 64);
            g.drawString("Help", 280, 290);

            g.drawRect(215, 350, 200, 64);
            g.drawString("Quit", 280, 390);
        } else if(game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", Font.BOLD, 50);
            Font fnt2 = new Font("arial", Font.BOLD, 30);
            Font fnt3 = new Font("arial", Font.BOLD, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 245, 70);

            g.setFont(fnt3);
            g.drawString("Use WASD keys to move player and dodge enemies", 50, 200);
            g.drawString("Press P to pause the game", 50, 250);
            g.drawString("Press SPACE to access the Shop", 50, 300);

            g.setFont(fnt2);
            g.drawRect(215, 350, 200, 64);
            g.drawString("Back", 280, 390);
        } else if(game.gameState == Game.STATE.End){
            Font fnt = new Font("arial", Font.BOLD, 50);
            Font fnt2 = new Font("arial", Font.BOLD, 30);
            Font fnt3 = new Font("arial", Font.BOLD, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 185, 70);

            g.setFont(fnt2);
            g.drawRect(215, 350, 200, 64);
            g.drawString("Your score: " + hud.getScore(), 200, 200);

            g.setFont(fnt3);
            g.drawString("Try Again", 270, 390);
        } else if(game.gameState == Game.STATE.Select) { //Convert to switch-case, possibly?
            Font fnt = new Font("arial", Font.BOLD, 50);
            Font fnt2 = new Font("arial", Font.BOLD, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Select Difficulty", 150, 70);

            g.setFont(fnt2);
            g.drawRect(215, 150, 200, 64);
            g.drawString("Classic", 265, 190);

            g.drawRect(215, 250, 200, 64);
            g.drawString("Hardcore", 250, 290);

            g.drawRect(215, 350, 200, 64);
            g.drawString("Back", 275, 390);
        }
    }

}
