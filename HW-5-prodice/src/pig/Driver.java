package pig;

import javafx.scene.text.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Eason on 10/31/15.
 */
public class Driver implements ActionListener {
    private JPanel mainPanel;
    private JTextField youTextField;
    private JTextField AITextField;
    private JButton rollButton;
    private JButton holdButton;
    private JLabel AILabel;
    private JLabel youLabel;
    private JPanel InfoPanel;
    private JButton restartButton;
    private boolean playersTurn = true;
    private ArrayList<Integer> numInTurn = new ArrayList<>();
    private int totalpointInTurn;
    private Player you;
    private Player AI;
    private Dice dice;
    private boolean running = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Driver");
        frame.setContentPane(new Driver().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createGameElements() {
        you = new Player("You");
        AI = new Player("AI");
        dice = new Dice();
    }

    private void createUIComponents() {
        createGameElements();
        mainPanel = new JPanel();
        youTextField = new JTextField();
        AITextField = new JTextField();
        rollButton = new JButton();
        rollButton.addActionListener(this);
        holdButton = new JButton();
        holdButton.addActionListener(this);
        restartButton = new JButton();
        restartButton.addActionListener(this);
        AILabel = new JLabel();
        youLabel = new JLabel();
        InfoPanel = new JPanel();
    }

    private void update() {


        if (playersTurn) {
            youTextField.setText(numInTurn.toString() + " points gained: " + totalpointInTurn);
            youLabel.setText("Your Total points: " + (you.getCurPoints() + totalpointInTurn));
            if (you.getCurPoints() + totalpointInTurn >= 100) {
                showResult(playersTurn);
                running = false;
            }
        } else {
            AITextField.setText(numInTurn.toString() + " points gained: " + totalpointInTurn);
            AILabel.setText("AI's Total points: " + (AI.getCurPoints() + totalpointInTurn));
            if (AI.getCurPoints() + totalpointInTurn >= 100) {
                showResult(playersTurn);
                running = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(restartButton)) {
            running = true;
            createGameElements();
            clear();
            playersTurn = false;
            update();
            playersTurn = true;
            update();
            clearResult();
        }
        if (running) {
            if (e.getSource().equals(rollButton)) {
                int num = dice.roll();
                numInTurn.add(num);
                if (num == 1) {
                    totalpointInTurn = 0;
                    update();
                    clear();
                    playersTurn = false;
                    aiPlay();
                } else {
                    totalpointInTurn += num;
                    update();
                }
            } else if (e.getSource().equals(holdButton)) {
                you.setCurPoints(you.getCurPoints() + totalpointInTurn);
                //totalpointInTurn = 0;
                //update();
                clear();
                playersTurn = false;
                aiPlay();
            }
        }
    }

    public void clear() {
        totalpointInTurn = 0;
        numInTurn.clear();
    }

    public void aiPlay() {
        int n = 1 + (int) (Math.random() * 10) % 8;
        for (int i = 0; i < n; i++) {
            int num = dice.roll();
            numInTurn.add(num);
            if (num == 1) {
                totalpointInTurn = 0;
                update();
                clear();
                playersTurn = true;
                break;
            } else {
                totalpointInTurn += num;
                update();
            }
        }
        AI.setCurPoints(AI.getCurPoints() + totalpointInTurn);
        //totalpointInTurn = 0;
        //update();
        clear();
        playersTurn = true;
    }

    public void showResult(boolean playersTurn) {
        Graphics g = InfoPanel.getGraphics();
        if (playersTurn) {
            g.setColor(Color.RED);
            g.drawString("You win!", 150, 20);
        } else {
            g.setColor(Color.BLUE);
            g.drawString("You lose!", 150, 20);
        }
    }

    public void clearResult() {
        Graphics g = InfoPanel.getGraphics();
        g.setColor(InfoPanel.getBackground());
        g.fillRect(0, 0, InfoPanel.getWidth(), InfoPanel.getHeight());
    }
}
