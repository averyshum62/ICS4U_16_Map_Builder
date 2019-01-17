package game;

import javax.swing.*;

public class GameButton extends JButton {

    private int key;

    public GameButton() {
        super();
        key = Constants.NIL;
    }

    public GameButton(int key) {
        setKey(key);
    }

    public void setKey(int key) {
        this.key = key;
        setIcon(Images.getImageIcon(key));
    }

    public int getKey() {
        return key;
    }
}
