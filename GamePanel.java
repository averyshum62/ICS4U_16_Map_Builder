package Play;

import Game.GMap;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GamePanel extends JPanel {

    private GMap map;

    public GamePanel() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("res/ics.map"));
            map = (GMap) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void setMap(GMap map) {
        this.map = map;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.draw(g);
    }
}
