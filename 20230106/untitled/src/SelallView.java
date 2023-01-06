import java.awt.*;
        import javax.swing.*;
        import javax.swing.table.*;

class SelallView extends JFrame {
    DefaultTableModel tm;
    JTable tb;
    JScrollPane sp;

    SelallCtrl selallCtrl;

    SelallView() {
        selallCtrl = new SelallCtrl();

        getContentPane().setLayout(new FlowLayout());

        String[][] rowData = {};

        tm = new DefaultTableModel(rowData, selallCtrl.getTitle());
        tb = new JTable(tm);
        sp = new JScrollPane(tb);
        sp.setPreferredSize(new Dimension(250, 100));
        setResizable(false);
        getContentPane().add(sp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TableModelTest");
        setSize(250, 150);

        selallCtrl.addData(tm);
        selallCtrl.close();
    }



    public static void main(String[] args) {
        SelallView obj = new SelallView();
        obj.setVisible(true);
    }
}

