package builder;

/*
 * Assignment 16: GameMap builder
 *
 * todo: write what this thing does
 *
 * Avery Shum, Marco Yang
 * ICS4U1-04
 * Strelkovska
 * todo: date
 */

import game.Constants;
import game.GameButton;
import game.GameMap;
import game.Images;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BuilderFrame extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    private ArrayList<GameButton> grid;
    private boolean drag;
    private int uniqueID, keyToSet;
    private Hashtable<Integer, GameButton> uniques = new Hashtable<>();
    private static GameButton bDummy = new GameButton();  // Dummy button for reference resets

    public BuilderFrame(String title) {
        super(title);

        // Reference to content pane
        Container cont = this.getContentPane();

        // Set white icon as default
        keyToSet = Constants.WHITE;

        /* Declare JPanels and buttons */
        JPanel pGrid, pGridWrapper, pButtons, pTiles, pEntities, pCommands;
        GameButton bWall1, bWall2;   // Tiles
        GameButton bExit, bPortalBlue, bPortalOrange, bPlayer, bCoin, bBag, bFire, bFireDis, bFireEx, bMonster, bSword; // Entities
        JButton bSave, bClear, bHelp;    // game commands
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
        uniqueID = Constants.NIL;
        uniques.put(Constants.PLAYER, bDummy);
        uniques.put(Constants.EXIT, bDummy);
        uniques.put(Constants.PORTAL_BLUE, bDummy);
        uniques.put(Constants.PORTAL_ORANGE, bDummy);
        uniques.put(Constants.COIN_BAG, bDummy);
        /* End init */

        /* GameMap grid (20 x 20 blocks) */
        pGrid.setLayout(new GridLayout(20, 20, 0, 0));

        // Initialise list of white grid buttons
        grid = new ArrayList<>();

        for (int i = 0; i < 400; i++) {
            grid.add(i, new GameButton());
            clearGridButton(i);

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

        bWall1 = new GameButton(Constants.WALL_1);
        bWall1.setToolTipText("Wall 1");
        bWall1.setBackground(Color.WHITE);
        bWall1.addActionListener(this);
        bWall1.setActionCommand("ADD");
        pTiles.add(bWall1);

        bWall2 = new GameButton(Constants.WALL_2);
        bWall2.setToolTipText("Wall 2");
        bWall2.setBackground(Color.WHITE);
        bWall2.addActionListener(this);
        bWall2.setActionCommand("ADD");
        pTiles.add(bWall2);

        pTiles.setMaximumSize(new Dimension(450, bWall1.getHeight()));
        /* End tiles */

        /* Entities */
        pEntities.setLayout(new FlowLayout());

        bPlayer = new GameButton(Constants.PLAYER);
        bPlayer.setToolTipText("Player");
        bPlayer.setBackground(Color.WHITE);
        bPlayer.addActionListener(this);
        bPlayer.setActionCommand("SET");
        pEntities.add(bPlayer);

        bExit = new GameButton(Constants.EXIT);
        bExit.setToolTipText("Exit");
        bExit.setBackground(Color.WHITE);
        bExit.addActionListener(this);
        bExit.setActionCommand("SET");
        pEntities.add(bExit);

        bPortalBlue = new GameButton(Constants.PORTAL_BLUE);
        bPortalBlue.setToolTipText("Blue Portal");
        bPortalBlue.setBackground(Color.WHITE);
        bPortalBlue.addActionListener(this);
        bPortalBlue.setActionCommand("SET");
        pEntities.add(bPortalBlue);

        bPortalOrange = new GameButton(Constants.PORTAL_ORANGE);
        bPortalOrange.setToolTipText("Orange Portal");
        bPortalOrange.setBackground(Color.WHITE);
        bPortalOrange.addActionListener(this);
        bPortalOrange.setActionCommand("SET");
        pEntities.add(bPortalOrange);

        bCoin = new GameButton(Constants.COIN);
        bCoin.setToolTipText("Coin");
        bCoin.setBackground(Color.WHITE);
        bCoin.addActionListener(this);
        bCoin.setActionCommand("ADD");
        pEntities.add(bCoin);

        bBag = new GameButton(Constants.COIN_BAG);
        bBag.setToolTipText("Coin Bag");
        bBag.setBackground(Color.WHITE);
        bBag.addActionListener(this);
        bBag.setActionCommand("SET");
        pEntities.add(bBag);

        bFire = new GameButton(Constants.FIRE);
        bFire.setToolTipText("Fire");
        bFire.setBackground(Color.WHITE);
        bFire.addActionListener(this);
        bFire.setActionCommand("ADD");
        pEntities.add(bFire);

        bFireDis = new GameButton(Constants.FIRE_DISTINGUISHER);
        bFireDis.setToolTipText("Fire Distinguisher");
        bFireDis.setBackground(Color.WHITE);
        bFireDis.addActionListener(this);
        bFireDis.setActionCommand("ADD");
        pEntities.add(bFireDis);

        bFireEx = new GameButton(Constants.FIRE_EXTINGUISHER);
        bFireEx.setToolTipText("Fire Extinguisher");
        bFireEx.setBackground(Color.WHITE);
        bFireEx.addActionListener(this);
        bFireEx.setActionCommand("ADD");
        pEntities.add(bFireEx);

        bMonster = new GameButton(Constants.MONSTER);
        bMonster.setToolTipText("Monster");
        bMonster.setBackground(Color.WHITE);
        bMonster.addActionListener(this);
        bMonster.setActionCommand("ADD");
        pEntities.add(bMonster);

        bSword = new GameButton(Constants.SWORD);
        bSword.setToolTipText("Sword");
        bSword.setBackground(Color.WHITE);
        bSword.addActionListener(this);
        bSword.setActionCommand("ADD");
        pEntities.add(bSword);

        pEntities.setPreferredSize(new Dimension(450, 100));
        /* End entities */

        /* game commands */
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
        // ADD commands (wall tiles, common entities)
        if (e.getActionCommand().equals("ADD")) {
            keyToSet = ((GameButton) e.getSource()).getKey();
            uniqueID = Constants.NIL;
        }

        // SET commands (uniques: exit tile, portals, player, coin bag)
        else if (e.getActionCommand().equals("SET")) {
            keyToSet = ((GameButton) e.getSource()).getKey();
            uniqueID = keyToSet;
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
            keyToSet = Constants.WHITE;
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
                    "GameMap builder Help", JOptionPane.INFORMATION_MESSAGE);
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
        if (drag && uniqueID == Constants.NIL) {
            GameButton source = (GameButton) m.getSource();

            clearGridButton(grid.indexOf(source));

            if (SwingUtilities.isLeftMouseButton(m))
                source.setKey(keyToSet);
        }
    }

    @Override
    public void mouseExited(MouseEvent m) {
        if (drag && uniqueID == Constants.NIL) {
            GameButton source = (GameButton) m.getSource();

            clearGridButton(grid.indexOf(source));

            if (SwingUtilities.isLeftMouseButton(m))
                source.setKey(keyToSet);
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
        GameButton source = (GameButton) m.getSource();

        clearGridButton(grid.indexOf(source));      // Clear first for safety; also allows right-click to act as clear

        if (SwingUtilities.isLeftMouseButton(m)) {
            source.setKey(keyToSet);

            // Clear former location of this unique
            if (uniqueID != Constants.NIL) {
                uniques.get(uniqueID).setKey(Constants.WHITE);
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
        // Update uniques if current grid button contains a unique
        switch (grid.get(i).getKey()) {
            case Constants.PLAYER:
            case Constants.EXIT:
            case Constants.PORTAL_BLUE:
            case Constants.PORTAL_ORANGE:
            case Constants.COIN_BAG:
                uniques.get(grid.get(i).getKey()).setKey(Constants.WHITE);
                uniques.get(grid.get(i).getKey()).setBackground(Color.WHITE);
                uniques.put(grid.get(i).getKey(), bDummy);
                break;
        }

        grid.get(i).setKey(Constants.WHITE);
        grid.get(i).setBackground(Color.WHITE);
    }

    /**
     * Clears the entire map grid.
     */
    private void clearGrid() {
        for (int i = 0; i < 400; i++)
            clearGridButton(i);
        uniqueID = Constants.NIL;
    }

    private void saveMap(File fSave) {
        GameMap map = new GameMap(grid);

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

        BuilderFrame frame = new BuilderFrame("Map Builder");
        frame.setVisible(true);
    }
}
