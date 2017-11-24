package Builder;

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

import Game.Constants;
import Game.Images;
import Game.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MapBuilder extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    private ArrayList<JButton> grid;
    private ImageIcon iconToSet;
    private boolean drag;
    private int uniqueID;
    private static final int NO_ID = -1;
    private Hashtable<Integer, JButton> uniques = new Hashtable<>();
    private static JButton bNull = new JButton();  // Dummy button for reference

    public MapBuilder(String title) {
        super(title);

        // Reference to content pane
        Container cont = this.getContentPane();

        // Set white icon as default
        iconToSet = Images.getImageIcon(Constants.WHITE);

        /* Declare JPanels and JButtons */
        JPanel pGrid, pGridWrapper, pButtons, pTiles, pEntities, pCommands;
        JButton bWall1, bWall2;   // Tiles
        JButton bExit, bPortalBlue, bPortalOrange, bPlayer, bCoin, bBag, bFire, bFireDis, bFireEx, bMonster, bSword; // Entities
        JButton bSave, bClear, bHelp;    // Game commands
        /* End declaration */

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
        uniques.put(Constants.PLAYER, bNull);
        uniques.put(Constants.EXIT, bNull);
        uniques.put(Constants.PORTAL_BLUE, bNull);
        uniques.put(Constants.PORTAL_ORANGE, bNull);
        uniques.put(Constants.COIN_BAG, bNull);
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

        /* Tiles */
        pTiles.setLayout(new FlowLayout());

        bWall1 = new JButton(Images.getImageIcon(Constants.WALL_1));
        bWall1.setToolTipText("Wall 1");
        bWall1.setBackground(Color.WHITE);
        bWall1.addActionListener(this);
        bWall1.setActionCommand("ADD_" + Constants.WALL_1);
        pTiles.add(bWall1);

        bWall2 = new JButton(Images.getImageIcon(Constants.WALL_2));
        bWall2.setToolTipText("Wall 2");
        bWall2.setBackground(Color.WHITE);
        bWall2.addActionListener(this);
        bWall2.setActionCommand("ADD_" + Constants.WALL_2);
        pTiles.add(bWall2);

        pTiles.setMaximumSize(new Dimension(450, bWall1.getHeight()));
        /* End tiles */

        /* Entities */
        pEntities.setLayout(new FlowLayout());

        bPlayer = new JButton(Images.getImageIcon(Constants.PLAYER));
        bPlayer.setToolTipText("Player");
        bPlayer.setBackground(Color.WHITE);
        bPlayer.addActionListener(this);
        bPlayer.setActionCommand("SET_" + Constants.PLAYER);
        pEntities.add(bPlayer);

        bExit = new JButton(Images.getImageIcon(Constants.EXIT));
        bExit.setToolTipText("Exit");
        bExit.setBackground(Color.WHITE);
        bExit.addActionListener(this);
        bExit.setActionCommand("SET_" + Constants.EXIT);
        pEntities.add(bExit);

        bPortalBlue = new JButton(Images.getImageIcon(Constants.PORTAL_BLUE));
        bPortalBlue.setToolTipText("Blue Portal");
        bPortalBlue.setBackground(Color.WHITE);
        bPortalBlue.addActionListener(this);
        bPortalBlue.setActionCommand("SET_" + Constants.PORTAL_BLUE);
        pEntities.add(bPortalBlue);

        bPortalOrange = new JButton(Images.getImageIcon(Constants.PORTAL_ORANGE));
        bPortalOrange.setToolTipText("Orange Portal");
        bPortalOrange.setBackground(Color.WHITE);
        bPortalOrange.addActionListener(this);
        bPortalOrange.setActionCommand("SET_" + Constants.PORTAL_ORANGE);
        pEntities.add(bPortalOrange);

        bCoin = new JButton(Images.getImageIcon(Constants.COIN));
        bCoin.setToolTipText("Coin");
        bCoin.setBackground(Color.WHITE);
        bCoin.addActionListener(this);
        bCoin.setActionCommand("ADD_" + Constants.COIN);
        pEntities.add(bCoin);

        bBag = new JButton(Images.getImageIcon(Constants.COIN_BAG));
        bBag.setToolTipText("Coin Bag");
        bBag.setBackground(Color.WHITE);
        bBag.addActionListener(this);
        bBag.setActionCommand("SET_" + Constants.COIN_BAG);
        pEntities.add(bBag);

        bFire = new JButton(Images.getImageIcon(Constants.FIRE));
        bFire.setToolTipText("Fire");
        bFire.setBackground(Color.WHITE);
        bFire.addActionListener(this);
        bFire.setActionCommand("ADD_" + Constants.FIRE);
        pEntities.add(bFire);

        bFireDis = new JButton(Images.getImageIcon(Constants.FIRE_DISTINGUISHER));
        bFireDis.setToolTipText("Fire Distinguisher");
        bFireDis.setBackground(Color.WHITE);
        bFireDis.addActionListener(this);
        bFireDis.setActionCommand("ADD_" + Constants.FIRE_DISTINGUISHER);
        pEntities.add(bFireDis);

        bFireEx = new JButton(Images.getImageIcon(Constants.FIRE_EXTINGUISHER));
        bFireEx.setToolTipText("Fire Extinguisher");
        bFireEx.setBackground(Color.WHITE);
        bFireEx.addActionListener(this);
        bFireEx.setActionCommand("ADD_" + Constants.FIRE_EXTINGUISHER);
        pEntities.add(bFireEx);

        bMonster = new JButton(Images.getImageIcon(Constants.MONSTER));
        bMonster.setToolTipText("Monster");
        bMonster.setBackground(Color.WHITE);
        bMonster.addActionListener(this);
        bMonster.setActionCommand("ADD_" + Constants.MONSTER);
        pEntities.add(bMonster);

        bSword = new JButton(Images.getImageIcon(Constants.SWORD));
        bSword.setToolTipText("Sword");
        bSword.setBackground(Color.WHITE);
        bSword.addActionListener(this);
        bSword.setActionCommand("ADD_" + Constants.SWORD);
        pEntities.add(bSword);

        pEntities.setPreferredSize(new Dimension(450, 100));
        /* End entities */

        /* Game commands */
        pCommands.setLayout(new FlowLayout());

        bSave = new JButton("Save", Images.getImageIcon(Constants.SAVE));
        bSave.setFont(new Font("Arial", Font.BOLD, 32));
        bSave.setIconTextGap(10);
        bSave.setBackground(new Color(230, 230, 230));
        bSave.addActionListener(this);
        bSave.setActionCommand("SAVE");
        pCommands.add(bSave);

        bClear = new JButton("Clear", Images.getImageIcon(Constants.CLEAR));
        bClear.setFont(new Font("Arial", Font.BOLD, 32));
        bClear.setIconTextGap(10);
        bClear.setBackground(new Color(230, 230, 230));
        bClear.addActionListener(this);
        bClear.setActionCommand("CLEAR");
        pCommands.add(bClear);

        bHelp = new JButton("Help", Images.getImageIcon(Constants.HELP));
        bHelp.setFont(new Font("Arial", Font.BOLD, 32));
        bHelp.setIconTextGap(10);
        bHelp.setBackground(new Color(230, 230, 230));
        bHelp.addActionListener(this);
        bHelp.setActionCommand("HELP");
        pCommands.add(bHelp);

        pCommands.setPreferredSize(new Dimension(450, bSave.getHeight()));
        /* End game commands */

        /* Buttons */
        pButtons.setLayout(new BoxLayout(pButtons, BoxLayout.Y_AXIS));
        pButtons.add(Box.createVerticalStrut(25));
        pButtons.add(pTiles);
        pButtons.add(Box.createVerticalGlue());
        pButtons.add(pEntities);
        pButtons.add(Box.createVerticalGlue());
        pButtons.add(pCommands);
        pButtons.add(Box.createVerticalStrut(25));
        pButtons.setPreferredSize(new Dimension(450, cont.getHeight()));
        /* End buttons */

        // Add components to content pane
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
            iconToSet = Images.getImageIcon(Integer.parseInt(e.getActionCommand().substring(4)));
            uniqueID = NO_ID;
        }

        // SET commands (uniques: exit tile, portals, player)
        else if (e.getActionCommand().contains("SET")) {
            int com = Integer.parseInt(e.getActionCommand().substring(4));

            iconToSet = Images.getImageIcon(com);
            uniqueID = com;
        }

        // SAVE command: save map data to a file
        else if (e.getActionCommand().equals("SAVE")) {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("save"));
            //todo: maybe try block
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File fSave = fc.getSelectedFile();
                saveMap(fSave);
            }
        }

        // CLEAR command: clear grid, reset icon
        else if (e.getActionCommand().equals("CLEAR")) {
            clearGrid();
            iconToSet = Images.getImageIcon(Constants.WHITE);
        }

        // HELP command: show help for map builder GUI
        else if (e.getActionCommand().equals("HELP")) {
            JOptionPane.showMessageDialog(this,
                    "Select a tile or entity from the right-side menu and click on the grid to place it.\n\n" +
                    "Some objects are unique and will have at most one instance on the grid.\n\n" +
                    "To clear a grid location, right click on it.\n\n" +
                    "All placing and clearing actions can be dragged across the grid\n" +
                    "so long as the item to place is not unique.\n\n" +
                    "When you are finished, click 'Save' to save your map to a file.",
                    "Map Builder Help", JOptionPane.INFORMATION_MESSAGE);
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
                uniques.get(uniqueID).setIcon(Images.getImageIcon(Constants.WHITE));
                uniques.get(uniqueID).setBackground(Color.WHITE);
                uniques.put(uniqueID, source);
            }
        }
    }

    /**
     * Clears a button in the map grid. If the button represents a unique entity, resets the unique entity reference.
     *
     * @param i index of the button
     */
    private void clearGridButton(int i) {
        grid.get(i).setIcon(Images.getImageIcon(Constants.WHITE));
        grid.get(i).setBackground(Color.WHITE);

        // Update uniques if current grid button contains a unique
        for (java.util.Map.Entry<Integer, JButton> u : uniques.entrySet()) {
            if (grid.get(i).equals(u.getValue())) {
                uniques.put(u.getKey(), bNull);
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

    private void saveMap(File fSave) {
        Map map = new Map(grid);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fSave));
            out.writeObject(map);
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        Images.load();

        MapBuilder frame = new MapBuilder("Map Builder");
        frame.setVisible(true);
    }
}
