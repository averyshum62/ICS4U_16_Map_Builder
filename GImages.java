package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GImages {
    private static ArrayList<BufferedImage> buff = new ArrayList<>(15);
    private static ArrayList<ImageIcon> icons = new ArrayList<>(15);

    public static void load() {
        // BufferedImages
        try {
            buff.add(GConstants.GROUND, ImageIO.read(new File("res/ground.png")));
            buff.add(GConstants.WALL_1, ImageIO.read(new File("res/wall_1.png")));
            buff.add(GConstants.WALL_2, ImageIO.read(new File("res/wall_2.png")));
            buff.add(GConstants.PLAYER, ImageIO.read(new File("res/player.png")));
            buff.add(GConstants.EXIT, ImageIO.read(new File("res/exit.png")));
            buff.add(GConstants.PORTAL_BLUE, ImageIO.read(new File("res/portal_blue.png")));
            buff.add(GConstants.PORTAL_ORANGE, ImageIO.read(new File("res/portal_orange.png")));
            buff.add(GConstants.COIN, ImageIO.read(new File("res/coin.png")));
            buff.add(GConstants.COIN_BAG, ImageIO.read(new File("res/coin_bag.png")));
            buff.add(GConstants.FIRE, ImageIO.read(new File("res/fire.png")));
            buff.add(GConstants.FIRE_DISTINGUISHER, ImageIO.read(new File("res/fire_distinguisher.png")));
            buff.add(GConstants.FIRE_EXTINGUISHER, ImageIO.read(new File("res/fire_extinguisher.png")));
            buff.add(GConstants.MONSTER, ImageIO.read(new File("res/monster.png")));
            buff.add(GConstants.SWORD, ImageIO.read(new File("res/sword.png")));
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        // ImageIcons
        icons.add(GConstants.GROUND, new ImageIcon("res/ground.png"));
        icons.add(GConstants.WALL_1, new ImageIcon("res/wall_1.png"));
        icons.add(GConstants.WALL_2, new ImageIcon("res/wall_2.png"));
        icons.add(GConstants.PLAYER, new ImageIcon("res/player.png"));
        icons.add(GConstants.EXIT, new ImageIcon("res/exit.png"));
        icons.add(GConstants.PORTAL_BLUE, new ImageIcon("res/portal_blue.png"));
        icons.add(GConstants.PORTAL_ORANGE, new ImageIcon("res/portal_orange.png"));
        icons.add(GConstants.COIN, new ImageIcon("res/coin.png"));
        icons.add(GConstants.COIN_BAG, new ImageIcon("res/coin_bag.png"));
        icons.add(GConstants.FIRE, new ImageIcon("res/fire.png"));
        icons.add(GConstants.FIRE_DISTINGUISHER, new ImageIcon("res/fire_distinguisher.png"));
        icons.add(GConstants.FIRE_EXTINGUISHER, new ImageIcon("res/fire_extinguisher.png"));
        icons.add(GConstants.MONSTER, new ImageIcon("res/monster.png"));
        icons.add(GConstants.SWORD, new ImageIcon("res/sword.png"));
        icons.add(GConstants.WHITE, new ImageIcon("res/white.png"));
    }

    public static BufferedImage getBufferedImage(int key) {
        return buff.get(key);
    }

    public static ImageIcon getImageIcon(int key) {
        return icons.get(key);
    }

    public static boolean isWhite(ImageIcon icon) {
        return icon.equals(icons.get(GConstants.WHITE));
    }

    public static int getKey(ImageIcon icon) {
        return icons.indexOf(icon);
    }
}
