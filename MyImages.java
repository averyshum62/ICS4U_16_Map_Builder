import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class MyImages {
    private static BufferedImage []tile;
    private static BufferedImage []obj;
    public static final int WHITE = 0, PINK = 1, BLUE = 2, COIN = 0;

    public static void load() {
    	tile = new BufferedImage[3];
    	obj = new BufferedImage[1];
        try {
        	tile[0] = ImageIO.read(new File("res/tile_white.png"));
        	tile[1] = ImageIO.read(new File("res/tile_pink.png"));
        	tile[2] = ImageIO.read(new File("res/tile_blue.png"));
        	
        	obj[0] = ImageIO.read(new File("res/tile_coin.png"));
        }
        catch(IOException e){}
    }

    public static BufferedImage getTile(int a) {
    	return tile[a];
    }
    
    public static BufferedImage getObj(int a) {
    	return obj[a];
    }
    
}
