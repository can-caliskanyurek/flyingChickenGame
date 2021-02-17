package dev.can.flyingchicken.states;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.EntityManager;
import dev.can.flyingchicken.entities.creatures.Chicken;
import dev.can.flyingchicken.entities.features.Cloud;
import dev.can.flyingchicken.gfx.Assets;
import dev.can.flyingchicken.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WinState extends State {
    private double timer = 0;
    private EntityManager entityManager;
    private BufferedImage sky;

    public WinState(Game game) {
        super(game);

        entityManager = new EntityManager(game, new Chicken(game, game.getWidth()/2 - 40, game.getHeight()/3));
        entityManager.addEntity(new Cloud(game));

        sky = ImageLoader.loadImage("/img/nightStar.png");
    }

    @Override
    public void tick() {
        entityManager.tick();
        timer += 0.5;

        if (timer%40 == 0) {
            entityManager.addEntity(new Cloud(game));
        } else if (timer%57 == 0) {
            entityManager.addEntity(new Cloud(game));
        }

        if (timer%250 == 0) {
            game.levelState = null;
            game.levelState = new LevelState(game);
            State.setState(new MenuState(game));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sky, 0, 0, 640, 960, null);
        entityManager.render(g);

        g.drawImage(Assets.label_congrats, game.getWidth()/2 - 125, game.getHeight()/2 - 62, 250, 125, null);
    }
}
