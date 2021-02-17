package dev.can.flyingchicken.entities.items;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.gfx.Assets;

import java.awt.*;

public class Heart extends Item {
    public Heart(Game game, float x, float y) {
        super(game, x, y, 60, 60);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        int health = game.getLevelState().getEntityManager().getChicken().getHealth();

        if (health == 3) {
            g.drawImage(Assets.heart, (int) x, (int) y, width, height, null);
            g.drawImage(Assets.heart, (int) x + 5 + (width/2), (int) y, width, height, null);
            g.drawImage(Assets.heart, (int) x + 10 + width, (int) y, width, height, null);
        } else if (health == 2) {
            g.drawImage(Assets.heart, (int) x + 5 + (width/2), (int) y, width, height, null);
            g.drawImage(Assets.heart, (int) x + 10 + width, (int) y, width, height, null);
        } else if (health == 1) {
            g.drawImage(Assets.heart, (int) x + 10 + width, (int) y, width, height, null);
        }
    }
}
