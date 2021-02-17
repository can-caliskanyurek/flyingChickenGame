/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities.creatures;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.gfx.Animation;
import dev.can.flyingchicken.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author can
 */
public class Chicken extends Creature {
    // Animations
    private Animation animFront, animLeft, animRight;
    
    public Chicken(Game game, float x, float y) {
        super(game, x, y, 1, 80, 80);
        
        // Animations
        animFront = new Animation(100, Assets.chickenFront);
        animLeft = new Animation(100, Assets.chickenLeft);
        animRight = new Animation(100, Assets.chickenRight);

        speed = 2.0f;

        bounds.x = 10;
        bounds.y = 0;
        bounds.width = 50;
        bounds.height = 72;
    }

    @Override
    public void tick() {
        // Animations
        animFront.tick();
        animLeft.tick();
        animRight.tick();
        
        // Movement
        getInput();
        moveX();
    }
    
    private void getInput() {
        xMove = 0;
        
        if (game.getKeyManager().left)
            xMove = -speed;
        if (game.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);
    }
    
    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else {
            return animFront.getCurrentFrame();
        }
    }
}