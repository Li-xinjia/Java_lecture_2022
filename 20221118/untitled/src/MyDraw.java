import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

enum statueDraw {
    LINE, RECT, OVAL
}

public class MyDraw extends JPanel implements MouseListener, ActionListener {

    private final int now_p = 0;
    private final Vector<Point> startPointsVector = new Vector<Point>();
    private final Vector<Point> endPointsVector = new Vector<Point>();
    private Vector<statueDraw> statueDrawVector = new Vector<statueDraw>();
    private Vector<Color> statueColorVector = new Vector<Color>();

    private static final JButton bLine = new JButton("Line");
    private static final JButton bRect = new JButton("Rect");
    private static final JButton bOval = new JButton("Oval");
    private static final JButton bBlack = new JButton("Black");
    private static final JButton bRed = new JButton("Red");
    private static final JButton bGreen = new JButton("Green");
    private static final JButton bClear = new JButton("Clear");
    private static final JButton bQuit = new JButton("Quit");

    private statueDraw statue_d = statueDraw.LINE;
    private Color statue_c = Color.black;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setTitle("MyDraw");
        Container c = f.getContentPane();

        MyDraw ml = new MyDraw();
        ml.setSize(400, 400);
        ml.setLocation(0, 0);
        c.add(ml);

        ml.add(bLine);
        ml.add(bRect);
        ml.add(bOval);
        ml.add(bBlack);
        ml.add(bRed);
        ml.add(bGreen);
        ml.add(bClear);
        ml.add(bQuit);

        bLine.addActionListener(ml);
        bRect.addActionListener(ml);
        bOval.addActionListener(ml);
        bBlack.addActionListener(ml);
        bRed.addActionListener(ml);
        bGreen.addActionListener(ml);
        bClear.addActionListener(ml);
        bQuit.addActionListener(ml);

        f.setVisible(true);
    }

    public MyDraw() {
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < startPointsVector.size(); i++) {
            g.setColor(statueColorVector.get(i));

            int width = (endPointsVector.get(i).x - startPointsVector.get(i).x);
            int height = (endPointsVector.get(i).y - startPointsVector.get(i).y);

            if (width < 0) {
                int temp = startPointsVector.get(i).x;
                startPointsVector.set(i, new Point(endPointsVector.get(i).x, startPointsVector.get(i).y));
                endPointsVector.set(i, new Point(temp, endPointsVector.get(i).y));
                width = -width;
            }

            if (height < 0) {
                int temp = startPointsVector.get(i).y;
                startPointsVector.set(i, new Point(startPointsVector.get(i).x, endPointsVector.get(i).y));
                endPointsVector.set(i, new Point(endPointsVector.get(i).x, temp));
                height = -height;
            }

            switch (statueDrawVector.get(i)) {
                case LINE:
                    g.drawLine(startPointsVector.get(i).x, startPointsVector.get(i).y, endPointsVector.get(i).x, endPointsVector.get(i).y);
                    break;
                case RECT:
                    g.drawRect(startPointsVector.get(i).x, startPointsVector.get(i).y, width, height);
                    break;
                case OVAL:
                    g.drawOval(startPointsVector.get(i).x, startPointsVector.get(i).y, width, height);
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        statueDrawVector.add(statue_d);
        statueColorVector.add(statue_c);

        Point temp_p = new Point();
        temp_p.x = e.getX();
        temp_p.y = e.getY();
        startPointsVector.add(temp_p);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point temp_p = new Point();
        temp_p.x = e.getX();
        temp_p.y = e.getY();
        endPointsVector.add(temp_p);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLine) {
            statue_d = statueDraw.LINE;
        } else if (e.getSource() == bRect) {
            statue_d = statueDraw.RECT;
        } else if (e.getSource() == bOval) {
            statue_d = statueDraw.OVAL;
        } else if (e.getSource() == bBlack) {
            statue_c = Color.black;
        } else if (e.getSource() == bRed) {
            statue_c = Color.red;
        } else if (e.getSource() == bGreen) {
            statue_c = Color.green;
        } else if (e.getSource() == bClear) {
            startPointsVector.clear();
            endPointsVector.clear();
            statueDrawVector.clear();
            statueColorVector.clear();
            repaint();
        } else if (e.getSource() == bQuit) {
            System.exit(0);
        }
    }
}
