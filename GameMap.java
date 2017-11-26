package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.awt.*;

public class GameMap implements Serializable {

    private ArrayList<Entity> entities;
    private Entity player;
    private boolean[] checks;

    public GameMap() {
        entities = null;
    }

    public GameMap(ArrayList<GameButton> grid) {
        entities = new ArrayList<>();

        // Iterate over all buttons in grid
        // If white, ignore; if player, add player; add all others as Entity objects
        for (GameButton g : grid) {
            if (g.getKey() == Constants.WHITE)
                continue;

            if (g.getKey() == Constants.PLAYER) {
                player = new Entity(g.getX(), g.getY(), g.getKey());
                continue;
            }

            entities.add(new Entity(g.getX(), g.getY(), g.getKey()));
        }

        // Perform and update checks
        checks = new boolean[5];
        for (int i = 0; i < 5; i++)
            checks[i] = false;
    }

    public boolean isPlayable() {
        for (boolean b : checks)
            if (!b) return false;
        return true;
    }

    public void movePlayerUp(boolean up) {
        player.moveUp(up);
    }

    public void movePlayerLeft(boolean left) {
        player.moveLeft(left);
    }

    public void movePlayerRight(boolean right) {
        player.moveRight(right);
    }

    public void movePlayerDown(boolean down) {
        player.moveDown(down);
    }

    public void draw(Graphics g) {
        if (entities != null) {
            g.drawImage(Images.getBufferedImage(Constants.BACKGROUND), 0, 0, 640, 640, null, null);

            for (Entity e : entities)
                e.draw(g);

            //todo: check for player unless map must be playable
            player.draw(g);
        }
    }
}
