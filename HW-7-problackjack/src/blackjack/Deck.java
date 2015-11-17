package blackjack;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Collections;

import java.util.Stack;

/**
 * Created by Eason on 11/13/15.
 */
public class Deck {
    private Stack<Card> cards;

    public Deck() {
        cards = new Stack<Card>();
        for (int i = 1; i <= 13; i++) {
            cards.push(new Card(i, "C"));
            cards.push(new Card(i, "D"));
            cards.push(new Card(i, "H"));
            cards.push(new Card(i, "S"));
        }
        Collections.shuffle(cards);
    }

    public Card getOneCard() {
        if (!cards.isEmpty()) {
            return cards.pop();
        } else {
            return null;
        }
    }

    //For test
    public void showReamin() {
        int i = 1;
        while (!cards.isEmpty()) {
            System.out.println(cards.pop().toString() + " " + i);
            i++;
        }
    }


}
