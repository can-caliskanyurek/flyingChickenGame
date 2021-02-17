/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.states;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.EntityManager;
import dev.can.flyingchicken.entities.creatures.Chicken;
import dev.can.flyingchicken.entities.creatures.Egg;
import dev.can.flyingchicken.entities.features.Cat;
import dev.can.flyingchicken.entities.features.Cloud;
import dev.can.flyingchicken.entities.features.Target;
import dev.can.flyingchicken.entities.items.Heart;
import dev.can.flyingchicken.entities.items.PointTable;
import dev.can.flyingchicken.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author can
 */
public class LevelState extends State {
    private PointTable pointTable;
    private Heart heart;
    private Egg egg;
    private EntityManager entityManager;
    private double timer = 0, sleep = 0;
    private BufferedImage morning, noon, night;
    private int point, lastPoint;
    private boolean flag;

    public LevelState(Game game) {
        super(game);

        entityManager = new EntityManager(game, new Chicken(game, game.getWidth()/2 - 40, 128));
        entityManager.addEntity(new Cloud(game));

        pointTable = new PointTable(game, 0, 0);
        heart = new Heart(game, game.getWidth() - 4 * pointTable.getWidth(), -10);
        morning = ImageLoader.loadImage("/img/morning.png");
        noon = ImageLoader.loadImage("/img/noon.png");
        night = ImageLoader.loadImage("/img/nightStar.png");
    }

    @Override
    public void tick() {
        heart.tick();
        pointTable.tick();
        entityManager.tick();

        point = entityManager.getChicken().getPoint();

        if (lastPoint < 250 && point >= 250) {
            timer = 0;
            entityManager.speedUp();
            State.setState(new LevelPassNoon(game));
        } else if (lastPoint < 750 && point >= 750) {
            timer = 0;
            entityManager.speedUp();
            State.setState(new LevelPassNight(game));
        }

        timer += 0.5;

        if (game.levelState.getDifficulty() == 0) {
            if (point < 250) { // LEVEL 1
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%97 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else if (point < 750) { // LEVEL 2
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%83 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else if (point < 1500) { // LEVEL 3
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%73 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else {
                State.setState(new WinState(game));
            }
        } else if (game.levelState.getDifficulty() == 1) {
            if (flag) {
                entityManager.speedUp();
                entityManager.speedUp();
                flag = false;
            }

            if (point < 250) { // LEVEL 1
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%73 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else if (point < 750) { // LEVEL 2
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%63 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else if (point < 1500) { // LEVEL 3
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%53 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else {
                State.setState(new WinState(game));
            }
        } else if (game.levelState.getDifficulty() == 2) {
            if (flag) {
                entityManager.speedUp();
                entityManager.speedUp();
                entityManager.speedUp();
                entityManager.speedUp();
                flag = false;
            }

            if (point < 250) { // LEVEL 1
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%53 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else if (point < 750) { // LEVEL 2
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%43 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else if (point < 1500) { // LEVEL 3
                if (timer%40 == 0) {
                    entityManager.addEntity(new Cloud(game));
                } else if (timer%33 == 0) {
                    entityManager.addEntity(new Cat(game));
                } else if (timer%201 == 0) {
                    entityManager.addEntity(new Cloud(game));
                    entityManager.addEntity(new Target(game));
                }
            } else {
                State.setState(new WinState(game));
            }
        }

        if (game.getKeyManager().left) {
            if (game.getKeyManager().attack) {
                egg = new Egg(game, entityManager.getChicken().getX() - 36, entityManager.getChicken().getY() + 2);
                egg.setDirection(true);
                egg.setFired(true);
                entityManager.setEgg(egg);
            }
        }
        
        if (game.getKeyManager().right) {
            if (game.getKeyManager().attack) {
                egg = new Egg(game, entityManager.getChicken().getX() + entityManager.getChicken().getWidth() - 25, entityManager.getChicken().getY() + 2);
                egg.setDirection(false);
                egg.setFired(true);
                entityManager.setEgg(egg);
            }
        }

        lastPoint = entityManager.getChicken().getPoint();
    }

    @Override
    public void render(Graphics g) {
        if (point < 250) {
            g.drawImage(morning, 0, 0, 640, 960, null);
        } else if (point < 750) {
            g.drawImage(noon, 0, 0, 640, 960, null);
        } else {
            g.drawImage(night, 0, 0, 640, 960, null);
        }

        entityManager.render(g);

        if (point < 250) {
            g.setColor(new Color(9, 48, 189));
            g.fillRect(0, 0, game.getWidth(), 32);
        } else if (point < 750) {
            g.setColor(new Color(173, 2, 2));
            g.fillRect(0, 0, game.getWidth(), 32);
        } else {
            g.setColor(new Color(97, 38, 128));
            g.fillRect(0, 0, game.getWidth(), 32);
        }

        pointTable.render(g);
        heart.render(g);
    }
    
    public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager; }
    public EntityManager getEntityManager() { return entityManager; }
}
