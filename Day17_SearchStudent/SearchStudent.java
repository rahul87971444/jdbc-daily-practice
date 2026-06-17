import java.sql.*;
public class SearchStudent {
    public static void main(String[] args) {
        try {
            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");
            PreparedStatement ps =
                con.prepareStatement(
                    "SELECT * FROM Student WHERE id=?");
            ps.setInt(1, 101);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id"));
                System.out.println(
                    "Name: " + rs.getString("name"));
            } else {
                System.out.println(
                    "Student Not Found");
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
