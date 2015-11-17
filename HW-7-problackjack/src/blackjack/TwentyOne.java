package blackjack;

import com.oracle.deploy.update.UpdateCheck;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eason on 11/15/15.
 */
public class TwentyOne extends JFrame {
    private JPanel mPanel;
    private PlayerHand dealer_deck;
    private PlayerHand player_deck;
    private JButton a10$Button;
    private JButton a20$Button;
    private JButton a50$Button;
    private JButton a100$Button;
    private JButton resetbet;
    private JButton bet;
    private JPanel selectPanel;
    private JPanel moneyselect;
    private JPanel selectAction;

    private InfoBoard infoBoard;

    private JTextField betpool;

    private ActionListener monitor;

    private JButton hitButton;
    private JButton standButton;
    private JButton newRoundButton;
    private JButton restart;

    private Deck deck;

    private Player dealer;
    private Player player;
    private Font defaultFT;
    private int iswin;

    private int state;  //0 bet 1 select 2 end

    class PlayerHand extends JComponent {
        Player p;

        public PlayerHand(String name, Player p) {
            this.p = p;
            this.setBorder(new TitledBorder(new EtchedBorder(), name));
            this.setPreferredSize(new Dimension(800, 300));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.p.draw(g, 200, 50, this);

        }
    }

    class InfoBoard extends JComponent {
        public InfoBoard() {
            this.setPreferredSize(new Dimension(800, 70));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (state == 0) {
                g.setFont(defaultFT);
                g.drawString("Please select your bet.", 300, 35);
            } else if (state == 1) {
                g.setFont(defaultFT);
                g.drawString("Hit or Stand", 300, 35);
            } else if (state == 2) {
                if (iswin == -1) {
                    g.setFont(defaultFT);
                    g.drawString("You lose", 300, 35);
                } else if (iswin == 1) {
                    g.setFont(defaultFT);
                    g.drawString("You win", 300, 35);
                } else {
                    g.setFont(defaultFT);
                    g.drawString("Tie", 300, 35);
                }
            }
        }
    }

    class Monitor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(restart)) {
                restart();
            } else if (e.getSource().equals(resetbet)) {
                player.setMoney(player.getMoney() + Integer.parseInt(betpool.getText()));
                betpool.setText("");
            } else if (e.getSource().equals(a10$Button)) {
                addbet(10);
            } else if (e.getSource().equals(a20$Button)) {
                addbet(20);
            } else if (e.getSource().equals(a50$Button)) {
                addbet(50);
            } else if (e.getSource().equals(a100$Button)) {
                addbet(100);
            } else if (e.getSource().equals(bet)) {
                bet();
            } else if (e.getSource().equals(hitButton)) {
                hit();
            } else if (e.getSource().equals(standButton)) {
                stand();
            } else if (e.getSource().equals(newRoundButton)) {
                newHand();
            }
            updateAll();
        }
    }

    public TwentyOne() {
        this.init();
        this.createUIComponents();
    }

    public void test() {
        dealer.addCard(deck.getOneCard());
        dealer.addCard(deck.getOneCard());
        dealer.addCard(deck.getOneCard());
        dealer.addCard(deck.getOneCard());
        //state = 2;
        //a10$Button.setEnabled(false);
    }

    private void init() {
        dealer = new Player("Dealer");
        player = new Player("Player");
        deck = new Deck();
        player.setMoney(1000);
        dealer.setShow(false);
        iswin = 0;
        state = 0;
        //betpool.setText("");
    }

    private void restart() {
        dealer.reset();
        player.reset();
        deck = new Deck();
        player.setMoney(1000);
        dealer.setShow(false);
        iswin = 0;
        state = 0;
        betpool.setText("");
    }

    private void newHand() {
        deck = new Deck();
        dealer.reset();
        player.reset();
        dealer.setShow(false);
        iswin = 0;
        state = 0;
        betpool.setText("");
    }

    private void bet() {
        player.addCard(deck.getOneCard());
        dealer.addCard(deck.getOneCard());
        player.addCard(deck.getOneCard());
        dealer.addCard(deck.getOneCard());

        //dealer.addCard(new Card(10, "H"));
        //dealer.addCard(new Card(1, "H"));
        //player.addCard(new Card(10, "H"));
        //player.addCard(new Card(1, "H"));

        state = 1;

        if (player.getHandPoints() == 21) {
            state = 2;
            comparePoints();
        } else if (dealer.getHandPoints() == 21) {
            state = 2;
            comparePoints();
        }
    }

    private void addbet(int bet) {
        if (player.getMoney() - bet >= 0) {
            player.setMoney(player.getMoney() - bet);
            int obet = 0;
            if (betpool.getText().trim().equals("")) {
                obet = 0;
            } else {
                obet = Integer.parseInt(betpool.getText().trim());
            }
            betpool.setText(obet + bet + "");
        }
    }

    private void hit() {
        if (player.addCard(deck.getOneCard())) {

        } else {
            comparePoints();
            state = 2;
        }
    }

    private void stand() {
        dealer.setShow(true);
        while (dealer.check17()) {
            dealer.addCard(deck.getOneCard());
        }
        comparePoints();
        state = 2;
    }

    private void comparePoints() {
        dealer.setShow(true);
        int obet = 0;
        if (betpool.getText().trim().equals("")) {
            obet = 0;
        } else {
            obet = Integer.parseInt(betpool.getText().trim());
        }
        if (player.getHandPoints() > 21) {
            iswin = -1;
        } else if (dealer.getHandPoints() > 21) {
            iswin = 1;
            player.setMoney(player.getMoney() + obet * 2);
        } else if (player.getHandPoints() > dealer.getHandPoints()) {
            iswin = 1;
            player.setMoney(player.getMoney() + obet * 2);
        } else if (player.getHandPoints() < dealer.getHandPoints()) {
            iswin = -1;
        } else {
            iswin = 0;
            player.setMoney(player.getMoney() + obet);
        }
    }

    private void createUIComponents() {
        defaultFT = new Font("Arial", Font.BOLD, 18);

        mPanel = new JPanel();
        mPanel.setLayout(new GridLayout(2, 1));

        dealer_deck = new PlayerHand("Dealer", dealer);

        player_deck = new PlayerHand("Player", player);

        mPanel.add(dealer_deck);
        mPanel.add(player_deck);

        selectPanel = new JPanel();
        selectAction = new JPanel();
        infoBoard = new InfoBoard();
        selectPanel.setLayout(new GridLayout(3, 1));

        selectPanel.add(infoBoard);

        a10$Button = new JButton("10$");
        a20$Button = new JButton("20$");
        a50$Button = new JButton("50$");
        a100$Button = new JButton("100$");
        resetbet = new JButton("Reset");
        bet = new JButton("Bet");

        moneyselect = new JPanel();
        moneyselect.add(a10$Button);
        moneyselect.add(a20$Button);
        moneyselect.add(a50$Button);
        moneyselect.add(a100$Button);
        moneyselect.add(resetbet);
        moneyselect.add(bet);

        betpool = new JTextField();
        betpool.setColumns(5);
        betpool.setEditable(false);
        moneyselect.setBorder(new TitledBorder(new EtchedBorder(), "Bet"));
        moneyselect.add(betpool);

        hitButton = new JButton("Hit");
        standButton = new JButton("Stand");
        newRoundButton = new JButton("New Hand");
        restart = new JButton("Restart Game");
        selectAction.add(hitButton);
        selectAction.add(standButton);
        selectAction.add(newRoundButton);
        selectAction.add(restart);
        selectAction.setBorder(new TitledBorder(new EtchedBorder(), "Your Selection"));

        selectPanel.add(moneyselect);
        selectPanel.add(selectAction);


        this.add(mPanel, BorderLayout.CENTER);
        this.add(selectPanel, BorderLayout.SOUTH);

        createActionMonitor();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void createActionMonitor() {
        monitor = new Monitor();
        a10$Button.addActionListener(monitor);
        a20$Button.addActionListener(monitor);
        a50$Button.addActionListener(monitor);
        a100$Button.addActionListener(monitor);
        resetbet.addActionListener(monitor);
        bet.addActionListener(monitor);

        hitButton.addActionListener(monitor);
        standButton.addActionListener(monitor);
        newRoundButton.addActionListener(monitor);
        restart.addActionListener(monitor);
    }

    public void stateUpdate() {
        if (state == 0) {
            a10$Button.setEnabled(true);
            a20$Button.setEnabled(true);
            a50$Button.setEnabled(true);
            a100$Button.setEnabled(true);
            resetbet.setEnabled(true);
            bet.setEnabled(true);

            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            newRoundButton.setEnabled(false);
            //restart.setEnabled(false);
        } else if (state == 1) {
            a10$Button.setEnabled(false);
            a20$Button.setEnabled(false);
            a50$Button.setEnabled(false);
            a100$Button.setEnabled(false);
            resetbet.setEnabled(false);
            bet.setEnabled(false);

            hitButton.setEnabled(true);
            standButton.setEnabled(true);
            newRoundButton.setEnabled(false);
        } else if (state == 2) {
            a10$Button.setEnabled(false);
            a20$Button.setEnabled(false);
            a50$Button.setEnabled(false);
            a100$Button.setEnabled(false);
            resetbet.setEnabled(false);
            bet.setEnabled(false);

            hitButton.setEnabled(false);
            standButton.setEnabled(false);
            newRoundButton.setEnabled(true);
        }
    }

    public void updateAll() {
        infoBoard.repaint();
        player_deck.repaint();
        dealer_deck.repaint();
        this.stateUpdate();
    }

}
