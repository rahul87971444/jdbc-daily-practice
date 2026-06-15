import java.sql.*;
public class UpdateStudent {
    public static void main(String[] args) {
        try {
            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");
            PreparedStatement ps =
                con.prepareStatement(
                    "UPDATE Student SET name=? WHERE id=?");
            ps.setString(1, "Rahul Kumar");
            ps.setInt(2, 101);
            int rows = ps.executeUpdate();
            System.out.println(
                rows + " Record Updated");
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
