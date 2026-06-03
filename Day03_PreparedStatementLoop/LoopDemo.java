import java.sql.*;
public class LoopDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "root",
            "password"
        );
        PreparedStatement ps =con.prepareStatement("INSERT INTO Student VALUES(?, ?)");
        for(int i = 1; i <= 200; i++) {
            ps.setInt(1, i);
            ps.setString(2, "Student" + i);
            ps.executeUpdate();
        }
        System.out.println("200 Records Inserted");
        con.close();
    }
}
