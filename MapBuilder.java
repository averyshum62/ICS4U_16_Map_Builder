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
import java.awt.event.*;
import java.util.ArrayList;

public class MapBuilder extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    private JPanel pGrid, pGridWrapper, pButtons, pTiles, pEntities, pCommands;
    private JButton bWall1, bWall2;   // Tiles
    private JButton bExit, bPortalBlue, bPortalOrange, bPlayer, bCoin, bBag, bMonster, bSword; // Entities
    private JButton bSave, bClear;    // Game commands
    private ArrayList<JButton> grid;
    private ImageIcon iconToSet;
    private boolean drag;
    private int uniqueID;
    private static final int NO_ID = -1, PLAYER = 0, EXIT = 1, PORTAL_BLUE = 2, PORTAL_ORANGE = 3;
    private JButton[] uniques = new JButton[4];
    private JButton bNull;  // Dummy button for reference

    public MapBuilder(String s) {
        super(s);

        // Assign variable to represent content pane
        Container cont = getContentPane();

        // Set white icon as default
        iconToSet = GImages.getImageIcon(GImages.WHITE);

        /* Initialise JPanels */
        pGrid = new JPanel();
        pGridWrapper = new JPanel();
        pButtons = new JPanel();
        pTiles = new JPanel();
        pEntities = new JPanel();
        pCommands = new JPanel();
        /* End init */

        /* Initialise unique references */
        uniqueID = NO_ID;
        bNull = new JButton();
        clearUniques();
        /* End init */

        /* Map grid */
        pGrid.setLayout(new GridLayout(20, 20, 0, 0));

        // Initialise list of grid buttons
        grid = new ArrayList<>();

        for (int i = 0; i < 400; i++) {
            grid.add(i, new JButton());
            clearGridButton(i);

            grid.get(i).addActionListener(this);
            grid.get(i).setActionCommand("GRID");
            grid.get(i).addMouseListener(this);
            grid.get(i).addMouseMotionListener(this);

            grid.get(i).setMargin(new Insets(0, 0, 0, 0));
            grid.get(i).setBorder(BorderFactory.createEmptyBorder());
            grid.get(i).setSize(new Dimension(32, 32));

            pGrid.add(grid.get(i));
        }

        pGrid.setSize((new Dimension(700, 700)));

        // Wrap
        pGridWrapper.setLayout(new GridBagLayout());
        pGridWrapper.add(pGrid);
        /* End map grid */

        /* Tiles - background images */
        pTiles.setLayout(new FlowLayout());

        bWall1 = new JButton("Wall 1", GImages.getImageIcon(GImages.WALL_1));
        bWall1.setFont(new Font("Arial", Font.BOLD, 32));
        bWall1.setBackground(Color.WHITE);
        bWall1.addActionListener(this);
        bWall1.setActionCommand("ADD_" + GImages.WALL_1);
        pTiles.add(bWall1);

        bWall2 = new JButton("Wall 2", GImages.getImageIcon(GImages.WALL_2));
        bWall2.setFont(new Font("Arial", Font.BOLD, 32));
        bWall2.setBackground(Color.WHITE);
        bWall2.addActionListener(this);
        bWall2.setActionCommand("ADD_" + GImages.WALL_2);
        pTiles.add(bWall2);
        /* End tiles */

        /* Entities - collision-tested objects */
        pEntities.setLayout(new FlowLayout());

        bPlayer = new JButton("Player", GImages.getImageIcon(GImages.PLAYER));
        bPlayer.setFont(new Font("Arial", Font.BOLD, 32));
        bPlayer.setForeground(Color.RED);
        bPlayer.setBackground(Color.WHITE);
        bPlayer.addActionListener(this);
        bPlayer.setActionCommand("SET_" + GImages.PLAYER);
        pEntities.add(bPlayer);

        bPortalBlue = new JButton("Blue Portal", GImages.getImageIcon(GImages.PORTAL_BLUE));
        bPortalBlue.setFont(new Font("Arial", Font.BOLD, 32));
        bPortalBlue.setForeground(Color.RED);
        bPortalBlue.setBackground(Color.WHITE);
        bPortalBlue.addActionListener(this);
        bPortalBlue.setActionCommand("SET_" + GImages.PORTAL_BLUE);
        pEntities.add(bPortalBlue);

        bPortalOrange = new JButton("Orange Portal", GImages.getImageIcon(GImages.PORTAL_ORANGE));
        bPortalOrange.setFont(new Font("Arial", Font.BOLD, 32));
        bPortalOrange.setForeground(Color.RED);
        bPortalOrange.setBackground(Color.WHITE);
        bPortalOrange.addActionListener(this);
        bPortalOrange.setActionCommand("SET_" + GImages.PORTAL_ORANGE);
        pEntities.add(bPortalOrange);

        bCoin = new JButton("Coin", GImages.getImageIcon(GImages.COIN));
        bCoin.setFont(new Font("Arial", Font.BOLD, 32));
        bCoin.setBackground(Color.WHITE);
        bCoin.addActionListener(this);
        bCoin.setActionCommand("ADD_" + GImages.COIN);
        pEntities.add(bCoin);
        /* End entities */

        /* Game commands */
        pCommands.setLayout(new FlowLayout());

        bSave = new JButton("Save Map");
        bSave.setFont(new Font("Arial", Font.BOLD, 32));
        bSave.setBackground(Color.LIGHT_GRAY);
        pCommands.add(bSave);

        bClear = new JButton("Clear");
        bClear.setFont(new Font("Arial", Font.BOLD, 32));
        bClear.setBackground(Color.LIGHT_GRAY);
        bClear.addActionListener(this);
        bClear.setActionCommand("CLEAR");
        pCommands.add(bClear);
        /* End game commands */

        /* Buttons */
        pButtons.setLayout(new BoxLayout(pButtons, BoxLayout.PAGE_AXIS));
        pButtons.setPreferredSize(new Dimension(450, 700));
        pButtons.add(Box.createVerticalGlue());
        pButtons.add(pTiles);
        pButtons.add(Box.createVerticalGlue());
        pButtons.add(pEntities);
        pButtons.add(Box.createVerticalGlue());
        pButtons.add(pCommands);
        pButtons.add(Box.createVerticalGlue());
        /* End buttons */

        // Add JPanels to container
        cont.setLayout(new BorderLayout());
        cont.add(pGridWrapper, BorderLayout.CENTER);
        cont.add(pButtons, BorderLayout.EAST);

        // Set window options
        setMinimumSize(new Dimension(1200, 730));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("GRID")) {
            // pass, todo: maybe do something if necessary but currently deprecated
        }

        // ADD commands (wall tiles, common entities)
        else if (e.getActionCommand().contains("ADD")) {
            iconToSet = GImages.getImageIcon(e.getActionCommand().substring(4));
            uniqueID = NO_ID;
        }

        // SET commands (uniques: exit tile, portals, player)
        else if (e.getActionCommand().contains("SET")) {
            String com = e.getActionCommand().substring(4);

            iconToSet = GImages.getImageIcon(com);

            // Set unique ID given command
            switch (com) {
                case GImages.PLAYER:
                    uniqueID = PLAYER;
                    break;
                case GImages.EXIT:
                    uniqueID = EXIT;
                    break;
                case GImages.PORTAL_BLUE:
                    uniqueID = PORTAL_BLUE;
                    break;
                case GImages.PORTAL_ORANGE:
                    uniqueID = PORTAL_ORANGE;
                    break;
            }
        }

        // CLEAR command: clear grid, reset icon
        else if (e.getActionCommand().equals("CLEAR")) {
            clearGrid();
            iconToSet = GImages.getImageIcon(GImages.WHITE);
        }
    }

    @Override
    public void mouseMoved(MouseEvent m) {
        // Pass
    }

    @Override
    public void mouseDragged(MouseEvent m) {
        // Pass
    }

    @Override
    public void mouseEntered(MouseEvent m) {
        if (drag && uniqueID == NO_ID) {
            JButton source = (JButton) m.getSource();

            clearGridButton(grid.indexOf(source));
            if (SwingUtilities.isLeftMouseButton(m))
                source.setIcon(iconToSet);
        }
    }

    @Override
    public void mouseExited(MouseEvent m) {
        if (drag && uniqueID == NO_ID) {
            JButton source = (JButton) m.getSource();

            clearGridButton(grid.indexOf(source));
            if (SwingUtilities.isLeftMouseButton(m))
                source.setIcon(iconToSet);
        }
    }

    @Override
    public void mousePressed(MouseEvent m) {
        drag = true;
    }

    @Override
    public void mouseReleased(MouseEvent m) {
        drag = false;
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        JButton source = (JButton) m.getSource();

        clearGridButton(grid.indexOf(source));          // Clear first for safety; also allows right-click to act as clear

        if (SwingUtilities.isLeftMouseButton(m)) {
            source.setIcon(iconToSet);

            if (uniqueID != NO_ID) {
                uniques[uniqueID].setIcon(GImages.getImageIcon(GImages.WHITE));
                uniques[uniqueID].setBackground(Color.WHITE);
                uniques[uniqueID] = source;
            }
        }
    }

    /**
     * Clears a button in the map grid. If the button represents a unique entity, resets the unique entity reference.
     *
     * @param i index of the button
     */
    private void clearGridButton(int i) {
        grid.get(i).setIcon(GImages.getImageIcon("white"));
        grid.get(i).setBackground(Color.WHITE);

        for (int u = 0; u < uniques.length; u++) {
            if (uniques[u] == grid.get(i)) {
                uniques[u] = bNull;
                break;
            }
        }
    }

    /**
     * Clears the entire map grid.
     */
    private void clearGrid() {
        for (int i = 0; i < 400; i++)
            clearGridButton(i);
        uniqueID = NO_ID;
    }

    /**
     * Resets all unique entity references.
     */
    private void clearUniques() {
        for (int i = 0; i < uniques.length; i++)
            uniques[i] = bNull;
    }

    public static void main(String[] args) {
        GImages.load();

        MapBuilder frame = new MapBuilder("Map Builder");
        frame.setVisible(true);
    }
}
