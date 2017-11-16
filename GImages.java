import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class GImages {
    private static Hashtable<String, ImageIcon> img = new Hashtable<>();

    private static Hashtable<String, BufferedImage> buff = new Hashtable<>();
    private static Hashtable<String, ImageIcon> icons = new Hashtable<>();

    public static final String
        GROUND = "ground",
        WALL_1 = "wall_1",
        WALL_2 = "wall_2",
        PLAYER = "player",
        EXIT = "exit",
        PORTAL_BLUE = "portal_blue",
        PORTAL_ORANGE = "portal_orange",
        COIN = "coin",
        COIN_BAG = "coin_bag",
        FIRE = "fire",
        FIRE_DISTINGUISHER = "fire_distinguisher",
        FIRE_EXTINGUISHER = "fire_extinguisher",
        MONSTER = "monster",
        SWORD = "sword",
        WHITE = "white";

    public static void load() {
        // BufferedImages
        try {
            buff.put(GROUND, ImageIO.read(new File("res/ground.png")));
            buff.put(WALL_1, ImageIO.read(new File("res/wall_1.png")));
            buff.put(WALL_2, ImageIO.read(new File("res/wall_2.png")));
            buff.put(PLAYER, ImageIO.read(new File("res/player.png")));
            buff.put(EXIT, ImageIO.read(new File("res/exit.png")));
            buff.put(PORTAL_BLUE, ImageIO.read(new File("res/portal_blue.png")));
            buff.put(PORTAL_ORANGE, ImageIO.read(new File("res/portal_orange.png")));
            buff.put(COIN, ImageIO.read(new File("res/coin.png")));
            buff.put(COIN_BAG, ImageIO.read(new File("res/coin_bag.png")));
            buff.put(FIRE, ImageIO.read(new File("res/fire.png")));
            buff.put(FIRE_DISTINGUISHER, ImageIO.read(new File("res/fire_distinguisher.png")));
            buff.put(FIRE_EXTINGUISHER, ImageIO.read(new File("res/fire_extinguisher.png")));
            buff.put(MONSTER, ImageIO.read(new File("res/monster.png")));
            buff.put(SWORD, ImageIO.read(new File("res/SWORD.png")));
        } catch (IOException ioe) {
            // Pass
        }

        // ImageIcons
        icons.put(GROUND, new ImageIcon("res/ground.png"));
        icons.put(WALL_1, new ImageIcon("res/wall_1.png"));
        icons.put(WALL_2, new ImageIcon("res/wall_2.png"));
        icons.put(PLAYER, new ImageIcon("res/player.png"));
        icons.put(EXIT, new ImageIcon("res/exit.png"));
        icons.put(PORTAL_BLUE, new ImageIcon("res/portal_blue.png"));
        icons.put(PORTAL_ORANGE, new ImageIcon("res/portal_orange.png"));
        icons.put(COIN, new ImageIcon("res/coin.png"));
        icons.put(COIN_BAG, new ImageIcon("res/coin_bag.png"));
        icons.put(FIRE, new ImageIcon("res/fire.png"));
        icons.put(FIRE_DISTINGUISHER, new ImageIcon("res/fire_distinguisher.png"));
        icons.put(FIRE_EXTINGUISHER, new ImageIcon("res/fire_extinguisher.png"));
        icons.put(MONSTER, new ImageIcon("res/monster.png"));
        icons.put(SWORD, new ImageIcon("res/SWORD.png"));
        icons.put(WHITE, new ImageIcon("res/white.png"));
    }

    public static BufferedImage getBufferedImage(String key) {
        return buff.get(key);
    }

    public static ImageIcon getImageIcon(String key) {
        return icons.get(key);
    }
}
