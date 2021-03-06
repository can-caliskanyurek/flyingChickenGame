package dev.can.flyingchicken.states;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.EntityManager;
import dev.can.flyingchicken.entities.creatures.Chicken;
import dev.can.flyingchicken.entities.features.Cloud;
import dev.can.flyingchicken.gfx.Assets;
import dev.can.flyingchicken.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelPassMorning extends State {
    private BufferedImage morning;
    private EntityManager entityManager;
    private double timer = 0;

    public LevelPassMorning(Game game) {
        super(game);

        entityManager = new EntityManager(game, new Chicken(game, game.getWidth()/2 - 40, game.getHeight()/3));
        entityManager.addEntity(new Cloud(game));
        morning = ImageLoader.loadImage("/img/morning.png");
    }

    @Override
    public void tick() {
        entityManager.tick();

        timer += 0.5;

        if (timer%40 == 0) {
            entityManager.addEntity(new Cloud(game));
        } else if (timer%97 == 0) {
            entityManager.addEntity(new Cloud(game));
        }

        if (timer > 200) {
            State.setState(game.levelState);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(morning, 0, 0, 640, 960, null);
        entityManager.render(g);
        g.drawImage(Assets.label_level[0], game.getWidth()/2 - 120, game.getHeight()/2 - 120, 240, 240, null);
        g.drawImage(Assets.level_rule[0], game.getWidth()/2 - 150, game.getHeight()/2 + 30, 300, 75, null);
    }
}