import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyForm3 extends JFrame implements ActionListener{
    private final JTextField t1;
    private final JButton b1, b2;

    public MyForm3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(180, 100);
        setTitle("MyForm3");
        Container c = getContentPane();

        t1 = new JTextField("",16);
        b1 = new JButton("Print");
        b2 = new JButton("Clear");

        c.setLayout(new FlowLayout());
        c.add(t1);
        c.add(b1);
        c.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String str = t1.getText();
            System.out.println(str);
        } else if (e.getSource() == b2) {
            t1.setText("");
        }
    }

    public static void main(String[] args) {
        MyForm3 mf = new MyForm3();

        mf.setVisible(true);
    }
}
