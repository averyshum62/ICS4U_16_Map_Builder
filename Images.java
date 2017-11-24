package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Images {
    private static ArrayList<BufferedImage> buff = new ArrayList<>(15);
    private static ArrayList<ImageIcon> icons = new ArrayList<>(15);

    public static void load() {
        // BufferedImages
        try {
            buff.add(Constants.BACKGROUND, ImageIO.read(new File("res/background.png")));
            buff.add(Constants.WALL_1, ImageIO.read(new File("res/wall_1.png")));
            buff.add(Constants.WALL_2, ImageIO.read(new File("res/wall_2.png")));
            buff.add(Constants.PLAYER, ImageIO.read(new File("res/player.png")));
            buff.add(Constants.EXIT, ImageIO.read(new File("res/exit.png")));
            buff.add(Constants.PORTAL_BLUE, ImageIO.read(new File("res/portal_blue.png")));
            buff.add(Constants.PORTAL_ORANGE, ImageIO.read(new File("res/portal_orange.png")));
            buff.add(Constants.COIN, ImageIO.read(new File("res/coin.png")));
            buff.add(Constants.COIN_BAG, ImageIO.read(new File("res/coin_bag.png")));
            buff.add(Constants.FIRE, ImageIO.read(new File("res/fire.png")));
            buff.add(Constants.FIRE_DISTINGUISHER, ImageIO.read(new File("res/fire_distinguisher.png")));
            buff.add(Constants.FIRE_EXTINGUISHER, ImageIO.read(new File("res/fire_extinguisher.png")));
            buff.add(Constants.MONSTER, ImageIO.read(new File("res/monster.png")));
            buff.add(Constants.SWORD, ImageIO.read(new File("res/sword.png")));
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }

        // ImageIcons
        icons.add(Constants.BACKGROUND, new ImageIcon("res/background.png"));
        icons.add(Constants.WALL_1, new ImageIcon("res/wall_1.png"));
        icons.add(Constants.WALL_2, new ImageIcon("res/wall_2.png"));
        icons.add(Constants.PLAYER, new ImageIcon("res/player.png"));
        icons.add(Constants.EXIT, new ImageIcon("res/exit.png"));
        icons.add(Constants.PORTAL_BLUE, new ImageIcon("res/portal_blue.png"));
        icons.add(Constants.PORTAL_ORANGE, new ImageIcon("res/portal_orange.png"));
        icons.add(Constants.COIN, new ImageIcon("res/coin.png"));
        icons.add(Constants.COIN_BAG, new ImageIcon("res/coin_bag.png"));
        icons.add(Constants.FIRE, new ImageIcon("res/fire.png"));
        icons.add(Constants.FIRE_DISTINGUISHER, new ImageIcon("res/fire_distinguisher.png"));
        icons.add(Constants.FIRE_EXTINGUISHER, new ImageIcon("res/fire_extinguisher.png"));
        icons.add(Constants.MONSTER, new ImageIcon("res/monster.png"));
        icons.add(Constants.SWORD, new ImageIcon("res/sword.png"));
        icons.add(Constants.WHITE, new ImageIcon("res/white.png"));
        icons.add(Constants.SAVE, new ImageIcon("res/save.png"));
        icons.add(Constants.CLEAR, new ImageIcon("res/clear.png"));
        icons.add(Constants.HELP, new ImageIcon("res/help.png"));
        icons.add(Constants.LOAD, new ImageIcon("res/load.png"));
    }

    public static BufferedImage getBufferedImage(int key) {
        return buff.get(key);
    }

    public static ImageIcon getImageIcon(int key) {
        return icons.get(key);
    }

    public static int getKey(ImageIcon icon) {
        return icons.indexOf(icon);
    }
}
