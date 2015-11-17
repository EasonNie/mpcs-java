package blackjack;

import java.awt.image.BufferedImage;
import java.util.Collections;

public class Stub {
    //nothing implemented here
    public static void main(String[] args) {
        Deck d = new Deck();
        Player p = new Player("nyx");
        while (p.check17()) {
            p.addCard(d.getOneCard());
        }
        System.out.println(p.getHandPoints());
        System.out.println(p.check17());

        BufferedImage image = ImageLoader.getImage(new Card(9, "D").toString());
    }
}
