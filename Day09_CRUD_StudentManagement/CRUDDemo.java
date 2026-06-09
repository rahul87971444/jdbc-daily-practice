import java.sql.*;
public class CRUDDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password");
        Statement st = con.createStatement();
        // INSERT
        st.executeUpdate(
                "INSERT INTO Student VALUES(10,'Rahul')");
        // UPDATE
        st.executeUpdate(
                "UPDATE Student SET name='Kumar' WHERE id=10");
        // SELECT
        ResultSet rs =
                st.executeQuery(
                        "SELECT * FROM Student");
        while(rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name"));
        }
        // DELETE
        st.executeUpdate(
                "DELETE FROM Student WHERE id=10");
        con.close();
    }
}
