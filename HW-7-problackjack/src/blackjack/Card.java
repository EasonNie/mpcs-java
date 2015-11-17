package blackjack;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 * Created by Eason on 11/13/15.
 */
public class Card {
    private String type;
    private int num;

    private static final String[] CARDS = new String[]{"*", "A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K"};

    public Card(int num, String type) {
        if (num < 1 && num > 13) {
            System.out.println("Illegal card info.");
            return;
        } else if (!(type.equals("C") || type.equals("D") || type.equals("H") || type.equals("S"))) {
            System.out.println("Illegal card info.");
            return;
        }
        this.type = type;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "" + CARDS[num] + type;
    }

    public void drawBack(Graphics g, int x, int y, ImageObserver observer) {
        BufferedImage image = ImageLoader.getImage("back");
        g.drawImage(image, x, y, observer);
    }

    public void draw(Graphics g, int x, int y, ImageObserver observer) {
        BufferedImage image = ImageLoader.getImage(this.toString());
        g.drawImage(image, x, y, observer);

    }
}
