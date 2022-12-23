import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelTest {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:/home/li-xinjia/university/Java/20221216/stock3.sqlite3");
            Statement st = con.createStatement();

            String sql = "SELECT * FROM student";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                System.out.println("sno:" + sno + " sname:" + sname + " address:" + address + " age:" + age);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
