package com.dodgethis.main;

import java.awt.*;

//Visual effects; Not the most optimised or efficient implementation, but intuitive
public class Trail extends GameObject{

    private float alpha = 1;
    private float life; //life variable used to control length or duration of trail

    private Handler handler;
    private Color color;

    private int width, height;
    public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    public void tick() {
        if(alpha > life){
            alpha -= life - 0.0001f;
        } else handler.removeObject(this);
    } // Trail decay rate

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x, y, width, height);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    } //template method to render transparency visual effect

    public Rectangle getBounds() {
        return null;
    }
}
