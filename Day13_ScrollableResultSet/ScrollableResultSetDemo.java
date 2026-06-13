import java.sql.*;
public class ScrollableResultSetDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "root",
            "password");
        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery(
            "SELECT * FROM Student");
        rs.first();
        System.out.println(
            "First Record: " +
            rs.getInt("id") + " " +
            rs.getString("name"));
        rs.last();
        System.out.println(
            "Last Record: " +
            rs.getInt("id") + " " +
            rs.getString("name"));
        rs.previous();
        System.out.println(
            "Previous Record: " +
            rs.getInt("id") + " " +
            rs.getString("name"));
        con.close();
    }
}
