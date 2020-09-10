package com.dodgethis.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;

        if(scoreKeep >= 100){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1); //Level increments with score in multiples of 500

            //Spawning system set to levels, note order matters, coinciding levels will override
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            if(hud.getLevel() % 10 == 0) {
                handler.clearEnemies();
                handler.addObject(new BossEnemy( (Game.WIDTH/2) - 48, -240, ID.BossEnemy, handler)); //BossEnemy is spawned off-screen
            } else if(hud.getLevel() % 4 == 0) {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            } else if(hud.getLevel() % 3 == 0) {
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }

        }
    }

}
