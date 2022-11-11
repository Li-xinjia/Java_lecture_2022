/////// MyLabel ///////
import java.awt.*;
import javax.swing.*;

class MyLabel extends JFrame {
    Container c;
    JLabel label;

    MyLabel(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 100);
        setTitle("MyLabel");

        c = getContentPane();
        c.setLayout(new FlowLayout());
        label = new JLabel("Hello World!!");
        c.add(label);
    }

    public static void main(String[] args) {
        MyLabel o = new MyLabel();
        o.setVisible(true);
    }
}