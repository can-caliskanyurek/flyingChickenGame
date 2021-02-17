/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.creatures.Chicken;
import dev.can.flyingchicken.entities.creatures.Egg;
import dev.can.flyingchicken.states.GameOverState;
import dev.can.flyingchicken.states.State;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author can
 */
public class EntityManager {
    private Egg egg;
    private Game game;
    private Chicken chicken;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if (a.getId() > b.getId())
                return -1;
            return 1;
        }
    };
    private Random rand;
    
    public EntityManager(Game game, Chicken chicken) {
        this.game = game;
        this.chicken = chicken;
        entities = new ArrayList<Entity>();
        rand = new Random();
        
        addEntity(chicken);
    }

    public void init() {
        chicken.setHealth(3);
        chicken.setPoint(0);

        for (int i = 0; i < entities.size(); i++)
            entities.remove(i);
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
            
            if (e.getId() == 3) {
                if (e.getCollisionBounds().intersects(chicken.getCollisionBounds())) {
                    entities.remove(e);

                    chicken.setHealth(chicken.getHealth() - 1);
                    if (chicken.getHealth() == 0) {
                        State.setState(new GameOverState(game));
                    }
                }
            }
            
            if (e.getId() == 2) {
                if (egg != null) {
                    if (e.checkEntityCollision(e)) {
                        chicken.setPoint(chicken.getPoint() + e.getPoint());
                        entities.remove(e);
                        egg.setFired(false);
                        egg = null;
                    }
                }
            }
            
            if ((e.getY() + e.getHeight()) < 0)
                entities.remove(e);
            
            if (e.getX() > game.getWidth() || e.getX() + e.getWidth() < 0) {
                entities.remove(e);

                if (e.getId() == 0)
                    egg = null;
            }
        }
        entities.sort(renderSorter);
    }
    
    public void render(Graphics g) {
        for (Entity e: entities) {
            e.render(g);
        }
    }

    public void speedUp() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);

            if (e.getId() == 2 || e.getId() == 3 || e.getId() == 4)
                e.setSpeed(e.getSpeed() + 3.0f);
        }
    }

    public void addEntity(Entity e) {
        int set = rand.nextInt()%3;
        int randPosX = rand.nextInt()%game.getWidth();
        
        randPosX *= (randPosX < 0) ? -1 : 1;
        set *= (set < 0) ? -1 : 1;
        
        set = set*20 + 128;
        
        if (e.getId() == 2) {
            e.setWidth(set);
            e.setHeight(set);
            
            if (set == 128) {
                e.setPoint(50);
                e.bounds.x = 32;
                e.bounds.y = 8;
                e.bounds.width = 63;
                e.bounds.height = 60;
            } else if (set == 148) {
                e.setPoint(75);
                e.bounds.x = 36;
                e.bounds.y = 9;
                e.bounds.width = 75;
                e.bounds.height = 69;
            } else if (set == 168) {
                e.setPoint(100);
                e.bounds.x = 41;
                e.bounds.y = 10;
                e.bounds.width = 85;
                e.bounds.height = 78;
            }
            
            if (rand.nextInt()%2 == 0) {
                e.setX(-1*(e.getWidth()/6));
            } else {
                e.setX(game.getWidth() - (5 * e.getWidth())/6);
            }
            
            e.setY(900 + 2*set);
        } else if (e.getId() != 1 && e.getId() != 0) {
            e.setX(randPosX);
            e.setY(900);
        }
        
        entities.add(e);
    }

    public void setEgg(Egg egg) {
        if (this.egg == null)
            entities.add(egg);

        this.egg = egg;
    }
    public Egg getEgg() { return egg; }

    public void setGame(Game game) { this.game = game; }
    public Game getGame() { return game; }

    public void setChicken(Chicken chicken) { this.chicken = chicken; }
    public Chicken getChicken() { return chicken; }

    public void setEntities(ArrayList<Entity> entities) { this.entities = entities; }
    public ArrayList<Entity> getEntities() { return entities; }
}
