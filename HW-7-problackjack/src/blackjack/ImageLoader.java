package blackjack;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Eason on 11/14/15.
 */
public class ImageLoader {
    private static HashMap<String, BufferedImage> imageMap;
    private static final String PATH = "src/blackjack/cards/";

    //Singleton
    private ImageLoader() {
        imageMap = new HashMap<String, BufferedImage>();
    }

    public static BufferedImage getImage(String name) {
        if (imageMap == null) {
            imageMap = new HashMap<String, BufferedImage>();
        }
        if (imageMap.containsKey(name)) {
            return imageMap.get(name);
        } else {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File(PATH + name + ".png"));
                imageMap.put(name, image);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return imageMap.get(name);
        }
    }
}
