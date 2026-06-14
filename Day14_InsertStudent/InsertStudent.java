import java.sql.*;
public class InsertStudent {
    public static void main(String[] args) {
        try {
            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");
            PreparedStatement ps =
                con.prepareStatement(
                    "INSERT INTO Student VALUES(?, ?)");
            ps.setInt(1, 101);
            ps.setString(2, "Rahul");
            int rows = ps.executeUpdate();
            System.out.println(
                rows + " Record Inserted");
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
