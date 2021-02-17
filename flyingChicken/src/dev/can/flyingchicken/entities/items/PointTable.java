package dev.can.flyingchicken.entities.items;

import dev.can.flyingchicken.Game;
import dev.can.flyingchicken.gfx.Assets;

import java.awt.*;
import java.util.ArrayList;

public class PointTable extends Item {
    private ArrayList<Integer> digits;
    private int lastPoint;

    public PointTable(Game game, float x, float y) {
        super(game, x, y, Item.DEFAULT_ITEM_WIDTH, Item.DEFAULT_ITEM_HEIGHT);

        digits = new ArrayList<>();
    }

    @Override
    public void tick() {
        int point = game.getLevelState().getEntityManager().getChicken().getPoint();

        if (getLastPoint() != point) {
            if (digits.size() != 0) {
                for (int i = digits.size() - 1; i >= 0; i--)
                    digits.remove(i);
            }

            while (point > 0) {
                digits.add(point % 10);
                point /= 10;
            }
        }
        setLastPoint(game.getLevelState().getEntityManager().getChicken().getPoint());
    }

    @Override
    public void render(Graphics g) {
        int j;
        if (digits.size() == 0) {
            j = 0;
            while (j < 5 - digits.size()) {
                g.drawImage(Assets.numbers[0], (int) x + j * (width/2), (int) y, width, height, null);
                j++;
            }
        } else if (digits.size() == 1) {
            j = 0;
            while (j < 5 - digits.size()) {
                g.drawImage(Assets.numbers[0], (int) x + j * (width/2), (int) y, width, height, null);
                j++;
            }

            g.drawImage(Assets.numbers[digits.get(0)], (int) x + j * (width/2), (int) y, width, height, null);
        } else if (digits.size() == 2) {
            j = 0;
            while (j < 5 - digits.size()) {
                g.drawImage(Assets.numbers[0], (int) x + j * (width/2), (int) y, width, height, null);
                j++;
            }

            for (int i = digits.size() - 1; i >= 0; i--) {
                g.drawImage(Assets.numbers[digits.get(i)], (int) x + j * (width/2), (int) y, width, height, null);
                j++;
            }
        } else if (digits.size() == 3) {
            j = 0;
            while (j < 5 - digits.size()) {
                g.drawImage(Assets.numbers[0], (int) x + j * (width/2), (int) y, width, height, null);
                j++;
            }

            for (int i = digits.size() - 1; i >= 0; i--) {
                g.drawImage(Assets.numbers[digits.get(i)], (int) x + j * (width / 2), (int) y, width, height, null);
                j++;
            }
        } else if (digits.size() == 4) {
            g.drawImage(Assets.numbers[0], (int) x, (int) y, width, height, null);

            j = 1;
            for (int i = digits.size() - 1; i >= 0; i--) {
                g.drawImage(Assets.numbers[digits.get(i)], (int) x + j * (width/2), (int) y, width, height, null);
                j++;
            }
        } else {
            j = 0;
            for (int i = digits.size() - 1; i >= 0; i--) {
                g.drawImage(Assets.numbers[digits.get(i)], (int) x + j * (width/2), (int) y, width, height, null);
            }
        }

    }

    public void setLastPoint(int lastPoint) { this.lastPoint = lastPoint; }
    public int getLastPoint() { return lastPoint; }
}
