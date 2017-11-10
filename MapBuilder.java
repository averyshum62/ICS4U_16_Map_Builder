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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapBuilder extends JFrame implements ActionListener {

    private JPanel pGrid, pButtons, pTiles, pEntities, pCommands;
    private JButton bPink, bBlue, bPlayer, bCoin, bSave, bLoad, bClear;
    private JButton[][] bGrid;
    private ImageIcon iconToSet;

    public MapBuilder(String s) {
        super(s);

        // Assign variable to represent content pane
        Container cont = getContentPane();

        // Assign blank icon
        iconToSet = MyImages.get("white");

        /* JPanels */
        pGrid = new JPanel();
        pButtons = new JPanel();
        pTiles = new JPanel();
        pEntities = new JPanel();
        pCommands = new JPanel();

        // Grid
        pGrid.setLayout(new GridLayout(20, 20));
        pGrid.setPreferredSize((new Dimension(660, 660)));
        bGrid = new JButton[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                bGrid[i][j] = new JButton();
                bGrid[i][j].setBackground(Color.WHITE);
                bGrid[i][j].addActionListener(this);
                bGrid[i][j].setActionCommand("grid");
                bGrid[i][j].setPreferredSize(new Dimension(32, 32));
                pGrid.add(bGrid[i][j]);
            }
        }

        // Tiles
        pTiles.setLayout(new FlowLayout());

        bPink = new JButton(MyImages.get("pink"));
        bPink.setMargin(new Insets(0, 0, 0, 0));
        bPink.addActionListener(this);
        bPink.setActionCommand("add_pink");
        pTiles.add(bPink);

        bBlue = new JButton(MyImages.get("blue"));
        bBlue.setMargin(new Insets(0, 0, 0, 0));
        bBlue.addActionListener(this);
        bBlue.setActionCommand("add_blue");
        pTiles.add(bBlue);

        // Entities
        pEntities.setLayout(new FlowLayout());

        bPlayer = new JButton("B2 player");
        bPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
        pEntities.add(bPlayer);

        bCoin = new JButton(MyImages.get("coin"));
        bCoin.setMargin(new Insets(0,0, 0, 0));
        bCoin.setBackground(Color.WHITE);
        bCoin.addActionListener(this);
        bCoin.setActionCommand("add_coin");
        pEntities.add(bCoin);

        // Commands
        pCommands.setLayout(new FlowLayout());
        JButton btnSave = new JButton("Save"), btnLoad = new JButton("Load"), btnClear = new JButton("Clear");
        btnSave.setFont(new Font("Times New Roman", Font.BOLD, 48));
        btnLoad.setFont(new Font("Times New Roman", Font.BOLD, 48));
        btnClear.setFont(new Font("Times New Roman", Font.BOLD, 48));
        pCommands.add(btnSave);
        pCommands.add(btnLoad);
        pCommands.add(btnClear);

        // Buttons
        pButtons.setLayout(new GridLayout(3, 1));
        pButtons.setPreferredSize(new Dimension(340, 700));
        pButtons.add(pTiles);
        pButtons.add(pEntities);
        pButtons.add(pCommands);

        // Add JPanels to container
        cont.setLayout(new BorderLayout());
        cont.add(pGrid, BorderLayout.CENTER);
        cont.add(pButtons, BorderLayout.EAST);
        /* End JPanels */

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("grid")) {
            JButton source = (JButton) e.getSource();
            source.setIcon(iconToSet);
        } else if (e.getActionCommand().contains("add")) {
            iconToSet = MyImages.get(e.getActionCommand().substring(4));
        }
    }

    public static void main(String[] args) {
        MyImages.load();

        MapBuilder frame = new MapBuilder("Map Builder");

        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
