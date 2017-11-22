package Play;

import Game.*;
import javax.swing.*;
import java.awt.*;

public class PlayFrame extends JFrame {

    public PlayFrame(String title) {
        super(title);

        Container cont = this.getContentPane();

        GamePanel gp = new GamePanel();

        JPanel pHUD = new JPanel();
        pHUD.setLayout(new FlowLayout());
        JLabel foo = new JLabel("Hello");
        pHUD.add(foo);

        cont.setLayout(new BorderLayout());
        cont.add(gp, BorderLayout.CENTER);
        cont.add(pHUD, BorderLayout.EAST);

        // Set window options
        setMinimumSize(new Dimension(1200, 730));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GImages.load();

        PlayFrame frame = new PlayFrame("Maze Game");
        frame.setVisible(true);
    }

    //todo: load
}
