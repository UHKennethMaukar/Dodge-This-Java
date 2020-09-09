package com.dodgethis.main;

import java.awt.*;

//Constructor class for game objects
public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected float velX, velY; //to control movement speed

    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    // For revised implementation, move handler to GameObject constructor below as shown
    // public Handler handler; this.handler = handler; handler.addObject(this);
    // can now implement new Object() with automatic handler, KIV

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds(); //For collision detection, rectangular hit-box

    //Getter & setters for main parameters
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setId(ID id){
        this.id = id;
    }
    public ID getId(){
        return id;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }

}
