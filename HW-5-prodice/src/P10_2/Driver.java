package P10_2;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Eason on 10/31/15.
 */
public class Driver implements ActionListener {
    private JButton button1;
    private JButton button2;
    private JPanel BPanel;
    private JPanel ViewPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel MainPanel;
    private int b1_count = 0;
    private int b2_count = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Driver");
        frame.setContentPane(new Driver().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        MainPanel = new JPanel();
        BPanel = new JPanel();
        ViewPanel = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button1.addActionListener(this);
        button2.addActionListener(this);
        textField1 = new JTextField();
        textField2 = new JTextField();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button1)) {
            b1_count++;
            textField1.setText("I was clicked " + b1_count + " times!");
            System.out.println("I was clicked " + b1_count + " times!");
        } else if (e.getSource().equals(button2)) {
            b2_count++;
            textField2.setText("I was clicked " + b2_count + " times!");
            System.out.println("I was clicked " + b2_count + " times!");
        }
    }
}
