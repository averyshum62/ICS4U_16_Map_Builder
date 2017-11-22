package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class GMap implements Serializable {

    private ArrayList<Entity> entities = new ArrayList<>();
    private boolean[] checks;

    public GMap(ArrayList<JButton> grid) {
        for (int i = 0; i < grid.size(); i++) {
            if (GImages.isWhite((ImageIcon) grid.get(i).getIcon()))
                continue;

            entities.add(new Entity(grid.get(i).getX(), grid.get(i).getY(), GImages.getKey((ImageIcon) grid.get(i).getIcon())));
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

    public void draw(Graphics g) {
        for (int i = 0; i < entities.size(); i++)
            entities.get(i).draw(g);
    }
}
