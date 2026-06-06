import java.sql.*;
public class ViewDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "root",
            "password");
        Statement st = con.createStatement();
        st.executeUpdate(
            "DROP VIEW IF EXISTS student_dept_info");
        st.executeUpdate(
            "CREATE VIEW student_dept_info AS " +
            "SELECT s.sname, d.deptName " +
            "FROM Student s, Department d " +
            "WHERE s.majorId=d.deptId");
        System.out.println("View Created");
        con.close();
    }
}
