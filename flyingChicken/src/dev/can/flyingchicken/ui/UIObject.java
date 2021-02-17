/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author can
 */
public abstract class UIObject {
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean hovering = false;
    
    public UIObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        bounds = new Rectangle((int) x, (int) y, width, height);
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void onClick();
    
    public void onMouseMove(MouseEvent e) {
        if (bounds.contains(e.getX(), e.getY())) {
            hovering = true;
        } else {
            hovering = false;
        }
    }
    
    public void onMouseRelease(MouseEvent e) {
        if (hovering)
            onClick();
    }

    // Getters and Setters
    public void setX(float x) { this.x = x; }
    public float getX() { return x; }

    public void setY(float y) { this.y = y; }
    public float getY() { return y; }
    
    public void setWidth(int width) { this.width = width; }
    public int getWidth() { return width; }
    
    public void setHeight(int height) { this.height = height; }
    public int getHeight() { return height; }
}
