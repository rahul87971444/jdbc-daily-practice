import java.sql.*;
public class SortStudents {
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
                    "SELECT * FROM Student ORDER BY marks DESC");
            System.out.println(
                "ID\tNAME\tMARKS");
            while(rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("marks"));
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
