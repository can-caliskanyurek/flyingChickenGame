/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities.features;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author can
 */
public class Target extends Feature {
    
    public Target(Game game) {
        super(game, 2, Feature.DEFAULT_FEATURE_WIDTH, Feature.DEFAULT_FEATURE_HEIGHT);
        
        speed = 1.8f;
    }

    @Override
    public void tick() {
        // Movement
        yMove = -speed;
        moveY();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.balloon, (int) x, (int) y, width, height, null);
    }
}
