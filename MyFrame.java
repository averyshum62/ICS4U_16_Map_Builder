/*
 * Assignment 16: Map Builder
 *
 * todo: write what this thing does
 *
 * Avery Shum, Marco Yang
 * ICS4U1-04
 * Strelkovska
 * todo: date
 */

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(String s) {
        super(s);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Map Builder");
        frame.setSize(2000, 1500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Assign variable to represent content pane
        Container cont = frame.getContentPane();

        /* JPanels */
        // Grid
        JPanel pGrid = new JPanel(), pButtons = new JPanel(), pB1 = new JPanel(), pB2 = new JPanel(), pB3 = new JPanel();
        pGrid.setLayout(new GridLayout(25, 25));
        for (int i = 1; i <= 625; i++)
            pGrid.add(new JButton("" + i));

        // B1 - Background tiles
        pB1.setLayout(new FlowLayout());
        JButton btnFoo = new JButton("B1 foo"), btnBar = new JButton("B1 bar");
        btnFoo.setFont(new Font("Arial", Font.PLAIN, 48));
        btnBar.setFont(new Font("Arial", Font.PLAIN, 48));
        pB1.add(btnFoo);
        pB1.add(btnBar);

        // B2 - Paths and player
        pB2.setLayout(new FlowLayout());
        JButton btnPlayer = new JButton("B2 player");
        btnPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        pB2.add(btnPlayer);

        // B3 - Game commands
        pB3.setLayout(new FlowLayout());
        JButton btnSave = new JButton("Save"), btnLoad = new JButton("Load"), btnClear = new JButton("Clear");
        btnSave.setFont(new Font("Times New Roman", Font.BOLD, 48));
        btnLoad.setFont(new Font("Times New Roman", Font.BOLD, 48));
        btnClear.setFont(new Font("Times New Roman", Font.BOLD, 48));
        pB3.add(btnSave);
        pB3.add(btnLoad);
        pB3.add(btnClear);

        // Buttons
        pButtons.setLayout(new GridLayout(3, 1));
        pButtons.add(pB1);
        pButtons.add(pB2);
        pButtons.add(pB3);

        // Add JPanels to container
        cont.setLayout(new BorderLayout());
        cont.add(pGrid, BorderLayout.CENTER);
        cont.add(pButtons, BorderLayout.EAST);
        /* End JPanels */

        frame.setVisible(true);
    }
}
