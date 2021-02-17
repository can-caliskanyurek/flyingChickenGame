/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.states;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.EntityManager;
import dev.can.flyingchicken.entities.creatures.Chicken;
import dev.can.flyingchicken.entities.features.Cloud;
import dev.can.flyingchicken.gfx.Assets;
import dev.can.flyingchicken.gfx.ImageLoader;
import dev.can.flyingchicken.ui.ClickListener;
import dev.can.flyingchicken.ui.UIImageButton;
import dev.can.flyingchicken.ui.UIManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author can
 */
public class MenuState extends State {
    private EntityManager entityManager;
    private UIManager uiManager;
    private BufferedImage sky, title;
    private double timer = 0;

    public MenuState(Game game) {
        super(game);
        
        entityManager = new EntityManager(game, new Chicken(game, game.getWidth()/2 - 40, game.getHeight()/3));
        uiManager = new UIManager(game);
        game.getMouseManager().setUIManager(uiManager);

        entityManager.addEntity(new Cloud(game));
        
        uiManager.addObject(new UIImageButton(game.getWidth()/2 - 80, game.getHeight()/2 + 100, 160, 160, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(new ChooseDiffState(game));
            }
        }));

        sky = ImageLoader.loadImage("/img/morning.png");
        title = ImageLoader.loadImage("/img/name.png");
    }

    @Override
    public void tick() {
        uiManager.tick();
        entityManager.tick();
        
        timer += 0.5;
        
        if (timer%40 == 0) {
            entityManager.addEntity(new Cloud(game));
        } else if (timer%97 == 0) {
            entityManager.addEntity(new Cloud(game));
        }
        
        if (timer >= 1000) {
            timer = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sky, 0, 0, 640, 960, null);
        entityManager.render(g);
        uiManager.render(g);
        g.drawImage(title, game.getWidth()/2 - 300, game.getHeight()/8, 600, 120, null);
    }
}
