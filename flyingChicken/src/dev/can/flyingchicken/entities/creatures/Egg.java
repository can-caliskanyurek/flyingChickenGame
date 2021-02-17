/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities.creatures;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author can
 */
public class Egg extends Creature {
    private boolean fired;
    private boolean direction;
    
    public Egg(Game game, float x, float y) {
        super(game, x, y, 0, 72, 72);
        
        speed = 2.5f;
        
        bounds.x = 11;
        bounds.y = 15;
        bounds.width = 30;
        bounds.height = 23;
    }

    @Override
    public void tick() {
        // Movement
        getInput();
        
        if (isFired())
            x += xMove;
    }
    
    public void getInput() {
        xMove = 0;
        
        if (getDirection()) {
            xMove = -speed;
        } else {
            xMove = speed;
        }
    }

    @Override
    public void render(Graphics g) {
        if (isFired()) {
            if (getDirection()) {
                g.drawImage(Assets.egg[0], (int) x, (int) y, width, height, null);
            } else {
                g.drawImage(Assets.egg[1], (int) x, (int) y, width, height, null);
            }
        }
    }
    
    public void setFired(boolean fired) { this.fired = fired; }
    public boolean isFired() { return fired; }

    public void setDirection(boolean direction) { this.direction = direction; }
    public boolean getDirection() { return direction; }
}
