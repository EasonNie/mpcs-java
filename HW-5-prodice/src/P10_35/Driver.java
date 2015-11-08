package P10_35;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Eason on 10/31/15.
 */
public class Driver implements ActionListener {
    private static int bill_id = 1;
    private JButton hotChocolateButton;
    private JButton chickenSaladSandwichButton;
    private JButton catfishPoBoySandwichButton;
    private JButton a5LoavesHotTurkeyButton;
    private JButton tilapiaSandwichButton;
    private JButton teriyakiTurkeyBurgerButton;
    private JButton grilledChickenSandwichButton;
    private JButton tilapiaButton;
    private JButton hotWingsButton;
    private JButton friedChickenButton;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton addButton;
    private JButton deleteLastItemButton;
    private JButton resetBillButton1;
    private JButton confirmButton1;
    private JTextField textField2;
    private JButton resetButton;
    private JLabel infoLabel;
    private JPanel mainPanel;
    private Bill bill;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Driver");
        frame.setContentPane(new Driver().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {

        //mainPanel = new JPanel();
        textArea1 = new JTextArea();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textArea1.setEditable(false);
        createButton();
    }

    private void update() {
        if (bill == null) {
            textArea1.setText("");
        } else {
            textArea1.setText(bill.toString());
        }
    }

    private void createButton() {
        hotChocolateButton = new JButton();
        chickenSaladSandwichButton = new JButton();
        catfishPoBoySandwichButton = new JButton();
        a5LoavesHotTurkeyButton = new JButton();
        tilapiaSandwichButton = new JButton();
        teriyakiTurkeyBurgerButton = new JButton();
        grilledChickenSandwichButton = new JButton();
        tilapiaButton = new JButton();
        hotWingsButton = new JButton();
        friedChickenButton = new JButton();

        addButton = new JButton();
        deleteLastItemButton = new JButton();
        resetBillButton1 = new JButton();
        confirmButton1 = new JButton();

        resetButton = new JButton();

        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(hotChocolateButton);
        buttons.add(chickenSaladSandwichButton);
        buttons.add(catfishPoBoySandwichButton);
        buttons.add(a5LoavesHotTurkeyButton);
        buttons.add(tilapiaSandwichButton);
        buttons.add(teriyakiTurkeyBurgerButton);
        buttons.add(grilledChickenSandwichButton);
        buttons.add(tilapiaButton);
        buttons.add(hotWingsButton);
        buttons.add(friedChickenButton);

        buttons.add(addButton);
        buttons.add(resetButton);

        buttons.add(deleteLastItemButton);
        buttons.add(resetBillButton1);
        buttons.add(confirmButton1);
        for (JButton button : buttons) {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(hotChocolateButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Hot Chocolate", 2));
            this.update();
        } else if (e.getSource().equals(chickenSaladSandwichButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Chicken Salad Sandwich", 7));
            this.update();
        } else if (e.getSource().equals(catfishPoBoySandwichButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Catfish Po Boy Sandwich", 6));
            this.update();
        } else if (e.getSource().equals(a5LoavesHotTurkeyButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("5 Loaves Hot Turkey", 5));
            this.update();
        } else if (e.getSource().equals(tilapiaSandwichButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Tilapia Sandwich", 7));
            this.update();
        } else if (e.getSource().equals(teriyakiTurkeyBurgerButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Teriyaki Turkey Burger", 5));
            this.update();
        } else if (e.getSource().equals(grilledChickenSandwichButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Grilled Chicken Sandwich", 6));
            this.update();
        } else if (e.getSource().equals(tilapiaButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Tilapia", 12));
            this.update();
        } else if (e.getSource().equals(hotWingsButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Hot Wings", 6.75));
            this.update();
        } else if (e.getSource().equals(friedChickenButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            bill.addItem(new Item("Fried Chicken", 11));
            this.update();
        } else if (e.getSource().equals(addButton)) {
            if (bill == null) {
                bill = new Bill(bill_id++);
            }
            String name = textField1.getText().trim();
            String price = textField2.getText().trim();
            if (name == "" || price == "") {
                return;
            } else {
                Item item = new Item(name, Double.parseDouble(price));
                bill.addItem(item);
                this.update();
            }
        } else if (e.getSource().equals(resetButton)) {
            textField1.setText("");
            textField2.setText("");
            this.update();
        } else if (e.getSource().equals(deleteLastItemButton)) {
            if (bill == null || bill.items.size() == 0) {
                return;
            } else {
                bill.removeLast();
                this.update();
            }
        } else if (e.getSource().equals(confirmButton1)) {
            if (bill == null) {
                return;
            } else {
                bill.billed();
                this.update();
            }
        } else if (e.getSource().equals(resetBillButton1)) {
            bill = null;
            this.update();
        }
    }
}
