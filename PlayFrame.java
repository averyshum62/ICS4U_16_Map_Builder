package Play;

import Game.*;
import javax.swing.*;
import java.awt.*;

public class PlayFrame extends JFrame {

    public PlayFrame(String title) {
        super(title);

        // Reference to content pane
        Container cont = this.getContentPane();

        /* Declare JPanels and JButtons */
        GamePanel gp;
        JPanel pGPWrapper, pHUD;
        JButton bLoad;
        /* End declaration*/

        /* Initialise JPanels */
        gp = new GamePanel();
        pGPWrapper = new JPanel();
        pHUD = new JPanel();
        /* End init */

        /* GamePanel */
        gp.addKeyListener(gp);
        pGPWrapper.setLayout(new GridBagLayout());
        pGPWrapper.add(gp);
        pGPWrapper.setPreferredSize(gp.getPreferredSize());
        /* End GamePanel */

        /* HUD */
        pHUD.setLayout(new BoxLayout(pHUD, BoxLayout.Y_AXIS));

        pHUD.add(Box.createVerticalStrut(20));

        bLoad = new JButton("Load", Images.getImageIcon(Constants.LOAD));
        bLoad.setFont(new Font("Arial", Font.BOLD, 32));
        bLoad.setIconTextGap(10);
        bLoad.setBackground(new Color(230, 230, 230));
        bLoad.addActionListener(gp);
        bLoad.setActionCommand("LOAD");
        pHUD.add(bLoad);

        pHUD.setPreferredSize(new Dimension(450, cont.getHeight()));
        /* End HUD */

        // Add components to content pane
        cont.setLayout(new BorderLayout());
        cont.add(pGPWrapper, BorderLayout.CENTER);
        cont.add(pHUD, BorderLayout.EAST);

        // Set window options
        setMinimumSize(new Dimension(1200, 730));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Images.load();

        PlayFrame frame = new PlayFrame("Maze Game");
        frame.setVisible(true);
    }
}
