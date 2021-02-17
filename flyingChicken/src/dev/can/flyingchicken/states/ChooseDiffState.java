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

import java.awt.*;
import java.awt.image.BufferedImage;

public class ChooseDiffState extends State {
    private BufferedImage sky, rules;
    private EntityManager entityManager;
    private UIManager uiManager;
    private double timer = 0;

    public ChooseDiffState(Game game) {
        super(game);

        entityManager = new EntityManager(game, new Chicken(game, game.getWidth()/2 - 270, game.getHeight()/3 - 100));
        uiManager = new UIManager(game);
        game.getMouseManager().setUIManager(null);
        game.getMouseManager().setUIManager(uiManager);

        entityManager.addEntity(new Cloud(game));

        sky = ImageLoader.loadImage("/img/morning.png");
        rules = ImageLoader.loadImage("/img/rules.png");

        uiManager.addObject(new UIImageButton(game.getWidth()/2 - 270, game.getHeight()/2 + 100, 140, 140, Assets.btn_easy, new ClickListener() {
            @Override
            public void onClick() {
                game.levelState.setDifficulty(0);
                State.setState(new LevelPassMorning(game));
            }
        }));

        uiManager.addObject(new UIImageButton(game.getWidth()/2 - 70, game.getHeight()/2 + 100, 140, 140, Assets.btn_medium, new ClickListener() {
            @Override
            public void onClick() {
                game.levelState.setDifficulty(1);
                State.setState(new LevelPassMorning(game));
            }
        }));

        uiManager.addObject(new UIImageButton(game.getWidth()/2 + 130, game.getHeight()/2 + 100, 140, 140, Assets.btn_hard, new ClickListener() {
            @Override
            public void onClick() {
                game.levelState.setDifficulty(2);
                State.setState(new LevelPassMorning(game));
            }
        }));
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
        g.drawImage(rules, game.getWidth()/2 - 205, game.getHeight()/6, 550, 275, null);
        g.drawImage(Assets.label_choose, game.getWidth()/2 - 120, game.getHeight()/2 - 30, 240, 160, null);
    }
}
