/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.entities;

import dev.can.flyingchicken.Game;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author can
 */
public abstract class Entity {
    protected static final int DEFAULT_HEALTH = 3;
    protected static final float DEFAULT_SPEED = 2.0f;

    protected Game game;
    protected Rectangle bounds;
    protected float x, y, speed;
    protected int width, height, id, point;
    protected int health;

    public Entity(Game game, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        this.health = DEFAULT_HEALTH;
    }

    public Entity(Game game, int id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.game = game;
        this.health = DEFAULT_HEALTH;
        
        bounds = new Rectangle(0, 0, width, height);
    }
    
    public Entity(Game game, float x, float y, int id, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        this.health = DEFAULT_HEALTH;
        
        bounds = new Rectangle(0, 0, width, height);
    }

    public boolean checkEntityCollision(Entity entity) {
        for (Entity e: game.getLevelState().getEntityManager().getEntities()) {
            if (e.getId() == 0) {
                if (e.getCollisionBounds().intersects(entity.getCollisionBounds())) {
                    game.getLevelState().getEntityManager().getEntities().remove(e);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Rectangle getCollisionBounds() {
        return new Rectangle((int) (x + bounds.x), (int) (y + bounds.y), bounds.width, bounds.height);
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(float x) { this.x = x; }
    public float getX() { return x; }
    
    public void setY(float y) { this.y = y; }
    public float getY() { return y; }
    
    public void setWidth(int width) { this.width = width; }
    public int getWidth() { return width; }
    
    public void setHeight(int height) { this.height = height; }
    public int getHeight() { return height; }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setHealth(int health) { this.health = health; }
    public int getHealth() { return health; }

    public void setPoint(int point) { this.point = point; }
    public int getPoint() { return point; }

    public void setSpeed(float speed) { this.speed = speed; }
    public float getSpeed() { return speed; }
}
