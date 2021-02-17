package dev.can.flyingchicken.entities.items;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.entities.Entity;

public abstract class Item extends Entity {
    protected static final int DEFAULT_ITEM_WIDTH = 32, DEFAULT_ITEM_HEIGHT = 32;

    public Item(Game game, float x, float y, int width, int height) {
        super(game, x, y, width, height);
    }
}
