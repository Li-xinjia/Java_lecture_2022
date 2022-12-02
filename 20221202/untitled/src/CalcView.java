import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcView extends JFrame implements ActionListener{

    private CalcCtrl ctrl;
    private Container c;
    private JTextField t1,t2,t3;
    private JLabel l1,l2;
    private JButton b1, b2;

    public CalcView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(180, 100);
        setTitle("Calc");
        setResizable(false);

        ctrl = new CalcCtrl();

        c = getContentPane();

        t1 = new JTextField(4);
        t2 = new JTextField(1);
        t3 = new JTextField(4);
        l1 = new JLabel("=");
        l2 = new JLabel("");
        b1 = new JButton("Calc");
        b2 = new JButton("Clear");

        c.setLayout(new FlowLayout());
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(l1);
        c.add(l2);
        c.add(b1);
        c.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            l2.setText(ctrl.Calc(t2.getText(),t1.getText(),t3.getText()));
        }else if(e.getSource() == b2){
            t1.setText("");
            t2.setText("");
            t3.setText("");
            l2.setText("");
        }
    }

    public static void main(String[] args) {
        CalcView window = new CalcView();

        window.setVisible(true);
    }
}
