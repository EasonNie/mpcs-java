package blackjack;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 * Created by Eason on 11/13/15.
 */
public class Player {
    private static final int DRAW_RANGE = 30;

    private String name;
    private ArrayList<Card> hand;

    private int money;

    private boolean show;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        show = true;
    }

    public void reset() {
        this.hand.clear();
    }

    public int getHandPoints() {
        int aceNum = 0;
        int points = 0;

        for (Card c : hand) {
            if (c.getNum() == 1) {
                aceNum++;
                points += 11;
            } else if (c.getNum() >= 10) {
                points += 10;
            } else {
                points += c.getNum();
            }
        }

        while (points > 21 && aceNum > 0) {
            points -= 10;
            aceNum--;
        }
        return points;
    }

    public boolean addCard(Card card) {
        System.out.println(card);
        hand.add(card);
        if (this.getHandPoints() > 21) {
            return false;
        } else {
            return true;
        }
    }

    public boolean check17() {
        int aceNum = 0;
        int points = 0;

        for (Card c : hand) {
            if (c.getNum() == 1) {
                aceNum++;
                points += 11;
            } else if (c.getNum() >= 10) {
                points += 10;
            } else {
                points += c.getNum();
            }
        }

        while (points > 21 && aceNum > 0) {
            points -= 10;
            aceNum--;
        }

        if (points > 17) {
            return false;
        } else if (points == 17 && aceNum == 0) {
            return false;
        } else if (points == 17 && aceNum >= 1) {
            return true;
        } else {
            return true;
        }

    }

    public void draw(Graphics g, int x, int y, ImageObserver observer) {

        if (this.name.equals("Dealer")) {
            g.setColor(Color.BLUE);
            if (show) {
                g.drawString("Current Points: " + this.getHandPoints(), 30, 70);
            } else {
                g.drawString("Current Points: ???", 30, 70);

            }
        } else {
            g.setColor(Color.RED);
            g.drawString("Money: " + this.money + "$", 30, 200);
            g.drawString("Current Points: " + this.getHandPoints(), 30, 70);
        }
        if (this.getHandPoints() > 21) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 18));
            g.drawString("Bust!", 30, 100);
        }
        if (show) {
            int range = 0;
            for (Card card : hand) {
                card.draw(g, x + range, y, observer);
                range = range + DRAW_RANGE;
            }
        } else {
            if (hand.size() >= 2) {
                hand.get(0).draw(g, x, y, observer);
                hand.get(1).drawBack(g, x + DRAW_RANGE, y, observer);
            }
        }
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
