package P11_22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Eason on 10/31/15.
 */
public class Driver {
    final int DEFAULT_WIDTH = 450;
    final int DEFAULT_HEIGHT = 300;
    private JPanel mainPanel;
    private Canvass canvass;
    private int clickCount;
    private Point[] points;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Driver");
        frame.setContentPane(new Driver().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        canvass = new Canvass();
        canvass.addMouseListener(new MouseMonitor(canvass));
        mainPanel.add(canvass);
        clickCount = 0;
        points = new Point[3];
    }

    class Canvass extends JComponent {
        public Canvass() {
            this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        }

        @Override
        protected void paintComponent(Graphics g) {
            this.setPreferredSize(mainPanel.getSize());
            super.paintComponent(g);
            if (points[0] != null) {
                g.drawLine((int) points[0].getX(), (int) points[0].getY(), (int) points[0].getX(), (int) points[0].getY());
            }
            if (points[1] != null) {
                g.drawLine((int) points[0].getX(), (int) points[0].getY(), (int) points[1].getX(), (int) points[1].getY());
            }
            if (points[2] != null) {
                g.drawLine((int) points[2].getX(), (int) points[2].getY(), (int) points[1].getX(), (int) points[1].getY());
                g.drawLine((int) points[2].getX(), (int) points[2].getY(), (int) points[0].getX(), (int) points[0].getY());
            }
        }
    }

    class MouseMonitor extends MouseAdapter {
        private JComponent canvass;
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            clickCount++;
            if (clickCount % 3 == 1) {
                points[0] = new Point();
                points[0].setLocation(e.getX(), e.getY());
                points[1] = null;
                points[2] = null;
            } else if (clickCount % 3 == 2) {
                points[1] = new Point();
                points[1].setLocation(e.getX(), e.getY());
            } else if (clickCount % 3 == 0) {
                points[2] = new Point();
                points[2].setLocation(e.getX(), e.getY());
            }
            this.canvass.repaint();
        }

        public MouseMonitor(JComponent canvass) {
            this.canvass = canvass;
        }
    }
}
