import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdTest {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:/home/li-xinjia/university/Java/20221216/stock3.sqlite3");
            Statement st = con.createStatement();

            //Insert
            st.executeUpdate("INSERT INTO student (sno, sname, address, age) VALUES ('4', 'S4', 'Kyoto', null)");

            //Confirm
            ResultSet rs = st.executeQuery("SELECT * FROM student WHERE sno = '4'");
            String sno = rs.getString("sno");
            String sname = rs.getString("sname");
            String address = rs.getString("address");
            int age = rs.getInt("age");
            System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);

            //Update
            st.executeUpdate("UPDATE student SET address = 'Tokyo' WHERE sno = '4'");

            //Confirm
            rs = st.executeQuery("SELECT * FROM student WHERE sno = '4'");
            sno = rs.getString("sno");
            sname = rs.getString("sname");
            address = rs.getString("address");
            age = rs.getInt("age");
            System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
