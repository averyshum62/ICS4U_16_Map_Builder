package game;

import java.awt.*;

public class Entity extends Rectangle {

    private int key;
    private boolean up, left, right, down;

    public Entity(int x, int y, int imgKey) {
        super(x, y, 32, 32);
        this.key = imgKey;
    }

    public void moveUp(boolean up) {
        this.up = up;
    }

    public void moveLeft(boolean left) {
        this.left = left;
    }

    public void moveRight(boolean right) {
        this.right = right;
    }

    public void moveDown(boolean down) {
        this.down = down;
    }

    public void draw(Graphics g) {
        if (up) y -= 2;
        if (left) x -= 2;
        if (right) x += 2;
        if (down) y += 2;

        g.drawImage(Images.getBufferedImage(key), x, y, 32, 32, null, null);
    }
}
