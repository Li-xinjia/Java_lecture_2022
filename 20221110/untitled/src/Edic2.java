import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Edic2 extends JFrame implements ActionListener {
    private final JTextField t1;
    private final JLabel l1;
    private final JButton b1, b2, b3;
    private final HashMap<String, String> map;

    public Edic2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(210, 120);
        setTitle("Edic2");
        setResizable(false);
        Container c = getContentPane();

        t1 = new JTextField("", 16);

        b1 = new JButton("Print");
        b2 = new JButton("Clear");
        b3 = new JButton("Quit");
        l1 = new JLabel("Welcome to Edic");

        map = new HashMap<String, String>();

        try (BufferedReader buff = new BufferedReader(new FileReader("dic.txt"));) {
            String jp_buff;
            String en_buff;
            do {
                jp_buff = buff.readLine();
                en_buff = buff.readLine();
                map.put(jp_buff, en_buff);
            } while (jp_buff != null && en_buff != null);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error: Can't found dic.txt");
            b1.setEnabled(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: Can't read dic.txt");
            b1.setEnabled(false);
        }

        c.setLayout(new FlowLayout());
        c.add(t1);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(l1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String str = t1.getText();
            String trans;
            trans = map.get(str);
            l1.setText(Objects.requireNonNullElse(trans, "Nor found"));
        } else if (e.getSource() == b2) {
            t1.setText("");
        } else if (e.getSource() == b3) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Edic2 mf = new Edic2();

        mf.setVisible(true);
    }
}
