package P10_26;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Eason on 10/31/15.
 */
public class Driver {

    final int DEFAULT_WIDTH = 450;
    final int DEFAULT_HEIGHT = 300;
    private JPanel MainPanel;
    private JPanel drawPanel;
    private Canvass canvass;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Driver");
        frame.setContentPane(new Driver().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        MainPanel = new JPanel();
        drawPanel = new JPanel();
        canvass = new Canvass();
        drawPanel.add(canvass);
    }

    class Canvass extends JComponent {
        public Canvass() {
            this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        }

        @Override
        protected void paintComponent(Graphics g) {
            this.setPreferredSize(drawPanel.getSize());
            super.paintComponent(g);
            int width = drawPanel.getWidth();
            int height = drawPanel.getHeight();
            int scale = (width + height) / 2;
            int r = scale / 10;
            int border = r / 5;
            drawRing(g, Color.blue, 3 * scale / 10, 2 * scale / 10, r, border);
            drawRing(g, Color.black, 5 * scale / 10, 2 * scale / 10, r, border);
            drawRing(g, Color.red, 7 * scale / 10, 2 * scale / 10, r, border);
            drawRing(g, Color.yellow, 4 * scale / 10, 3 * scale / 10, r, border);
            drawRing(g, Color.green, 6 * scale / 10, 3 * scale / 10, r, border);
        }

        public void drawRing(Graphics g, Color c, int x, int y, int r, int width) {
            g.setColor(c);
            for (int i = r; i > r - width; i--) {
                g.drawOval(x + r - i, y + r - i, i * 2, i * 2);
            }
        }
    }


}
