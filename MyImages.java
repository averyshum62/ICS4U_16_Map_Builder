import javax.swing.*;
import java.util.Hashtable;

public class MyImages {
    private static Hashtable<String, ImageIcon> img = new Hashtable<>();

    public static void load() {
        img.put("blank", new ImageIcon("res/tile_blank.png"));
        img.put("white", new ImageIcon("res/tile_white.png"));
        img.put("pink", new ImageIcon("res/tile_pink.png"));
        img.put("blue", new ImageIcon("res/tile_blue.png"));
        img.put("coin", new ImageIcon("res/tile_coin.png"));
    }

    public static ImageIcon get(String key) {
        return img.get(key);
    }
}
