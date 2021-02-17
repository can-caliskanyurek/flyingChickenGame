/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities.features;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.Entity;

/**
 *
 * @author can
 */
public abstract class Feature extends Entity {
    public static final int DEFAULT_FEATURE_WIDTH = 128, DEFAULT_FEATURE_HEIGHT = 128;

    protected float xMove, yMove;

    public Feature(Game game, int id, int width, int height) {
        super(game, id, width, height);

        xMove = 0;
        yMove = 0;
    }
    
    public void moveX() {
        x += xMove;
    }
    
    public void moveY() {
        y += yMove;
    }

    public void setxMove(float xMove) { this.xMove = xMove; }
    public float getxMove() { return xMove; }

    public void setyMove(float yMove) { this.yMove = yMove; }
    public float getyMove() { return yMove; }
}
