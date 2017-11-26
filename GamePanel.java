package play;

import game.GameMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private GameMap map;

    public GamePanel() {
        map = new GameMap();
        this.setPreferredSize(new Dimension(640, 640));
    }

    public void setMap(GameMap map) {
        this.map = map;
        repaint();
        setFocusable(true);
        requestFocusInWindow();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        map.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("LOAD")) {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("save"));

            try {
                if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(fc.getSelectedFile()));
                    GameMap load = (GameMap) in.readObject();
                    this.setMap(load);
                    in.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Pass
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            map.movePlayerUp(true);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            map.movePlayerLeft(true);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            map.movePlayerRight(true);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            map.movePlayerDown(true);

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            map.movePlayerUp(false);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            map.movePlayerLeft(false);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            map.movePlayerRight(false);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            map.movePlayerDown(false);
    }
}
