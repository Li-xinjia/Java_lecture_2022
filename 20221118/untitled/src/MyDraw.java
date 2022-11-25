import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Point;

class point {
    public int start_x = 0, start_y = 0;
    public int end_x = 0, end_y = 0;
}

public class MyDraw extends JPanel implements MouseListener {

    private int now_p = 0;
    private Vector<Point> startPoints = new Vector<Point>();
    private Vector<Point> endPoints = new Vector<Point>();

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setTitle("MyDraw");
        Container c = f.getContentPane();

        MyDraw ml = new MyDraw();
        c.add(ml);
        f.setVisible(true);
    }

    public MyDraw() {
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < startPoints.size(); i++) {
            g.drawLine(startPoints.get(i).x, startPoints.get(i).y, endPoints.get(i).x, endPoints.get(i).y);
        }
    }

    public void mousePressed(MouseEvent e) {
        Point temp_p = new Point();
        temp_p.x = e.getX();
        temp_p.y = e.getY();
        startPoints.add(temp_p);
    }

    public void mouseReleased(MouseEvent e) {
        Point temp_p = new Point();
        temp_p.x = e.getX();
        temp_p.y = e.getY();
        endPoints.add(temp_p);
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
