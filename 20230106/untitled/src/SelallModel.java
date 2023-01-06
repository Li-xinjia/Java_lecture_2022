import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelallModel {
    Connection con;
    Statement st;
    ResultSet rs;

    SelallModel() {

    }

    public boolean openDatabase(String db_path, String sql) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(db_path);
            st = con.createStatement();

            rs = st.executeQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean closeDatabase() {
        try {
            st.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String[] getData() {
        try {
            String sno = rs.getString("sno");
            String sname = rs.getString("sname");
            String address = rs.getString("address");
            int age = rs.getInt("age");
            String age_s = Integer.toString(age);
            System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);
            String[] buffer = {sno, sname, address, age_s};
            return buffer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean isOver() {
        try {
            return rs.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
