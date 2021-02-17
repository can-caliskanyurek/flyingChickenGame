/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities.features;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.gfx.Animation;
import dev.can.flyingchicken.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author can
 */
public class Cat extends Feature {
    // Animations
    private Animation animCat;
    
    public Cat(Game game) {
        super(game, 3, 108, 108);
        
        animCat = new Animation(150, Assets.cat);

        speed = 2.0f;
        
        bounds.x = 33;
        bounds.y = 10;
        bounds.width = 45;
        bounds.height = 93;
    }

    @Override
    public void tick() {
        // Animations
        animCat.tick();
        
        // Movement
        yMove = -speed;
        moveY();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animCat.getCurrentFrame(), (int) x, (int) y, width, height, null);
    }
}
