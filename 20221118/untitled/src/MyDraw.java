import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * 変更点：
 * - 完全にMCVモデルを変わるのが困難で、画板とツールバーを分離した。
 * - Starを描画できるようにした。
 */

enum StatueDraw {
    LINE, RECT, OVAL, STAR
}

class DrawControlWindow extends JFrame {
    public static final JButton bLine = new JButton("Line");
    public static final JButton bRect = new JButton("Rect");
    public static final JButton bOval = new JButton("Oval");
    public static final JButton bStar = new JButton("Star");
    public static final JButton bBlack = new JButton("Black");
    public static final JButton bRed = new JButton("Red");
    public static final JButton bGreen = new JButton("Green");
    public static final JButton bClear = new JButton("Clear");
    public static final JButton bQuit = new JButton("Quit");

    public DrawControlWindow(MyDraw ml) {
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(400, 200);
        this.setTitle("ToolBar");
        Container cTool = this.getContentPane();
        cTool.setLayout(new FlowLayout());

        cTool.add(bLine);
        cTool.add(bRect);
        cTool.add(bOval);
        cTool.add(bStar);
        cTool.add(bBlack);
        cTool.add(bRed);
        cTool.add(bGreen);
        cTool.add(bClear);
        cTool.add(bQuit);

        bLine.addActionListener(ml);
        bRect.addActionListener(ml);
        bOval.addActionListener(ml);
        bStar.addActionListener(ml);
        bBlack.addActionListener(ml);
        bRed.addActionListener(ml);
        bGreen.addActionListener(ml);
        bClear.addActionListener(ml);
        bQuit.addActionListener(ml);
    }

    public void showToolBar() {
        this.setVisible(true);
    }

    public void unShowToolBar() {
        this.setVisible(false);
    }
}

public class MyDraw extends JPanel implements MouseListener, ActionListener {
    private final Vector<Point> startPointsVector = new Vector<>();
    private final Vector<Point> endPointsVector = new Vector<>();
    private final Vector<StatueDraw> statueDrawVector = new Vector<>();
    private final Vector<Color> statueColorVector = new Vector<>();

    private static final JMenuBar menuBar = new JMenuBar();
    private static final JMenu menuTool = new JMenu("Tools");
    private static final JMenuItem menuItemToolBar = new JMenuItem("ToolBar");
    private final DrawControlWindow toolBar = new DrawControlWindow(this);

    private StatueDraw statue_d = StatueDraw.LINE;
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

        f.setVisible(true);
    }

    public MyDraw() {
        addMouseListener(this);
        menuBar.add(menuTool);
        menuTool.add(menuItemToolBar);
        menuItemToolBar.addActionListener(this);
        this.setLayout(null);
        menuBar.setSize(50,30);
        menuBar.setLocation(0,0);
        this.add(menuBar);
    }

    public void drawStar(Graphics g, int x, int y, int width, int height) {
        g.drawLine(x + width / 2, y, (int) (x + 0.1755 * width), y + height);
        g.drawLine(x + width / 2, y, (int) (x + 0.8244 * width), y + height);
        g.drawLine(x, (int) (y + 0.3292 * height), x + width, (int) (y + 0.3292 * height));
        g.drawLine(x, (int) (y + 0.3292 * height), (int) (x + 0.8244 * width), y + height);
        g.drawLine(x + width, (int) (y + 0.3292 * height), (int) (x + 0.1755 * width), y + height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < startPointsVector.size(); i++) {
            g.setColor(statueColorVector.get(i));

            int width = (endPointsVector.get(i).x - startPointsVector.get(i).x);
            int height = (endPointsVector.get(i).y - startPointsVector.get(i).y);

            if (statueDrawVector.get(i) == StatueDraw.LINE){
                g.drawLine(startPointsVector.get(i).x, startPointsVector.get(i).y, endPointsVector.get(i).x, endPointsVector.get(i).y);
                continue;
            }

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
                case RECT -> g.drawRect(startPointsVector.get(i).x, startPointsVector.get(i).y, width, height);
                case OVAL -> g.drawOval(startPointsVector.get(i).x, startPointsVector.get(i).y, width, height);
                case STAR -> drawStar(g, startPointsVector.get(i).x, startPointsVector.get(i).y, width, height);
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
        if (e.getSource() == DrawControlWindow.bLine) {
            statue_d = StatueDraw.LINE;
        } else if (e.getSource() == DrawControlWindow.bRect) {
            statue_d = StatueDraw.RECT;
        } else if (e.getSource() == DrawControlWindow.bOval) {
            statue_d = StatueDraw.OVAL;
        } else if (e.getSource() == DrawControlWindow.bStar) {
            statue_d = StatueDraw.STAR;
        } else if (e.getSource() == DrawControlWindow.bBlack) {
            statue_c = Color.black;
        } else if (e.getSource() == DrawControlWindow.bRed) {
            statue_c = Color.red;
        } else if (e.getSource() == DrawControlWindow.bGreen) {
            statue_c = Color.green;
        } else if (e.getSource() == DrawControlWindow.bClear) {
            startPointsVector.clear();
            endPointsVector.clear();
            statueDrawVector.clear();
            statueColorVector.clear();
            repaint();
        } else if (e.getSource() == DrawControlWindow.bQuit) {
            System.exit(0);
        }else if (e.getSource() == menuItemToolBar){
            toolBar.showToolBar();
        }
    }
}
