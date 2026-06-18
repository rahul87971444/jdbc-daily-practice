import java.sql.*;
public class CountStudents {
    public static void main(String[] args) {
        try {
            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "password");
            Statement st =
                con.createStatement();
            ResultSet rs =
                st.executeQuery(
                    "SELECT COUNT(*) AS total FROM Student");
            if(rs.next()) {
                System.out.println(
                    "Total Students: " +
                    rs.getInt("total"));
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
