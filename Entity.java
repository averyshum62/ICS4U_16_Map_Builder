package Game;

import Game.GImages;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity extends Rectangle {

    private int imgKey;

    public Entity(int x, int y, int imgKey) {
        super(x, y, 32, 32);
        this.imgKey = imgKey;
    }

    public void draw(Graphics g) {
        g.drawImage(GImages.getBufferedImage(imgKey), x, y, 32, 32, null, null);
    }
}
