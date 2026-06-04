import java.sql.*;
public class StudentTableProgram {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "root",
            "password"
        );
        Statement st = con.createStatement();
        st.executeUpdate(
            "CREATE TABLE Student(" +
            "id INT PRIMARY KEY, " +
            "name VARCHAR(30), " +
            "email VARCHAR(30), " +
            "branch VARCHAR(20), " +
            "marks INT)"
        );
        st.executeUpdate(
            "INSERT INTO Student VALUES" +
            "(4,'Sneha','s@gmail.com','CSE',76)," +
            "(5,'Karan','k@gmail.com','EEE',65)"
        );
        st.executeUpdate(
            "CREATE INDEX idx_email ON Student(email)"
        );
        ResultSet rs = st.executeQuery(
            "SELECT * FROM Student WHERE marks > 75"
        );
        while(rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +
                rs.getString("name")
            );
        }
        con.close();
    }
}
