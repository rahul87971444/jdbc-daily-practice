CREATE PROCEDURE getStudents()
BEGIN
    SELECT * FROM Student;
END;
-------------------------------------
import java.sql.*;
public class CallableDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "root",
            "password");
        CallableStatement cs =
            con.prepareCall("{call getStudents()}");
        ResultSet rs = cs.executeQuery();
        while(rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name"));
        }
        con.close();
    }
}
