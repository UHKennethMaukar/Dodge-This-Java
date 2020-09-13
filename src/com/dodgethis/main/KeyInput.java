package com.dodgethis.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//For Keyboard input
public class KeyInput extends KeyAdapter{

    private Game game;
    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler, Game game){
        this.game = game;
        this.handler = handler;

        keyDown[0]=false;
        keyDown[1]=false;
        keyDown[2]=false;
        keyDown[3]=false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); //To bind key
        //System.out.println(key); //To print activated key input in ASCII values

        for(int i = 0; i < handler.object.size(); i++){ //To define which specific game object(s) has key input
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){
                //key events for player

                if(key == KeyEvent.VK_W) { tempObject.setVelY(-handler.spd); keyDown[0]=true; }
                if(key == KeyEvent.VK_S) { tempObject.setVelY(handler.spd); keyDown[1]=true; }
                if(key == KeyEvent.VK_A) { tempObject.setVelX(-handler.spd); keyDown[2]=true; }
                if(key == KeyEvent.VK_D) { tempObject.setVelX(handler.spd); keyDown[3]=true; }

            }

        }
        if(key == KeyEvent.VK_P) Game.paused = !Game.paused; //For pause menu
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        if(key == KeyEvent.VK_SPACE){
            if(game.gameState == Game.STATE.Game) game.gameState = Game.STATE.Shop;
            else if (game.gameState== Game.STATE.Shop) game.gameState = Game.STATE.Game;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){

                if(key == KeyEvent.VK_W) keyDown[0]=false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) keyDown[1]=false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_A) keyDown[2]=false; //tempObject.setVelX(0);
                if(key == KeyEvent.VK_D) keyDown[3]=false; //tempObject.setVelX(0);
                //Fixed sticky key issues using improved implementation, old version commented out

                if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0); //Vertical movement
                if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0); //Vertical movement
            }
        }

    }

}
