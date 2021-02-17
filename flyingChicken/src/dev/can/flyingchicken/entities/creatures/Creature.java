/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities.creatures;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.Entity;

/**
 *
 * @author can
 */
public abstract class Creature extends Entity {
    public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
    protected float xMove, yMove;
    
    public Creature(Game game, float x, float y, int id, int width, int height) {
        super(game, x, y, id, width, height);

        xMove = 0;
        yMove = 0;
    }
    
    public void moveX() {
        if (xMove > 0) { //moving right 
            int tx = (int) (x + xMove + width);
            
            if (tx <= game.getWidth())
                x += xMove;
        } else if (xMove < 0) { //moving left
            int tx = (int) (x + xMove);
            
            if (tx >= 0)
                x += xMove; 
        }
    }
    
    public void moveY() {
        y += yMove;
    }

    public void setxMove(float xMove) { this.xMove = xMove; }
    public float getxMove() { return xMove; }

    public void setyMove(float yMove) { this.yMove = yMove; }
    public float getyMove() { return yMove; }
}
