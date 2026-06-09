import java.sql.*;
public class IndexDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "root",
            "password");
        Statement st = con.createStatement();
        st.executeUpdate(
            "CREATE INDEX idx_email " +
            "ON Student(email)");
        System.out.println("Index Created");
        con.close();
    }
}
