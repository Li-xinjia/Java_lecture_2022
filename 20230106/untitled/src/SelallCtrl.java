import javax.swing.table.DefaultTableModel;

public class SelallCtrl {
    SelallModel selallModel;

    SelallCtrl() {
        selallModel = new SelallModel();
        selallModel.openDatabase("jdbc:sqlite:/home/li-xinjia/university/Java/20221216/stock3.sqlite3", "SELECT * FROM student");
    }

    public String[] getTitle() {
        return new String[]{"sno", "sname", "address", "age"};
    }

    public void addData(DefaultTableModel tm) {
        while (selallModel.isOver()) {
            tm.addRow(selallModel.getData());
        }
    }

    public boolean close() {
        return selallModel.closeDatabase();
    }
}
