package com.dodgethis.main;

import java.awt.*;
import java.util.LinkedList;

//Handler functions to maintain, update & render the game objects
public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i = 0; i < object.size(); i++){ //loops through all game objects
            GameObject tempObject = object.get(i); //fetches id of objects in the linked list

            tempObject.tick();

        }
    }

    public void clearEnemies(){
        object.removeIf(gameObject -> gameObject.getId()!= ID.Player);
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

}
