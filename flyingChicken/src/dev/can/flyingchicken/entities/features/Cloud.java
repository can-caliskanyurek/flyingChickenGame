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
public class Cloud extends Feature {
    
    public Cloud(Game game) {
        super(game, 4, 160, 160);
        
        speed = 2.8f;
        
        bounds.x = 9;
        bounds.y = 44;
        bounds.width = 131;
        bounds.height = 76;
    }

    @Override
    public void tick() {
        // Movement
        yMove = -speed;
        moveY();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cloud, (int) x, (int) y, width, height, null);
    }
}
