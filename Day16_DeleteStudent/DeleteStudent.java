import java.sql.*;
public class DeleteStudent {
    public static void main(String[] args) {
        try {
            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");
            PreparedStatement ps =
                con.prepareStatement(
                    "DELETE FROM Student WHERE id=?");
            ps.setInt(1, 101);
            int rows = ps.executeUpdate();
            System.out.println(
                rows + " Record Deleted");
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
