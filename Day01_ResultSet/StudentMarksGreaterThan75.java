import java.sql.*;
public class StudentMarksGreaterThan75 {
    public static void main(String[] args) {
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/universitydb",
                "root",
                "password"
            );
            Statement st = con.createStatement();
        ) {
            ResultSet rs = st.executeQuery(
                "SELECT * FROM Student WHERE marks > 75"
            );
            System.out.println("ID\tNAME\t\tEMAIL");
            System.out.println("--------------------------------");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("ID") + "\t" +
                    rs.getString("NAME") + "\t" +
                    rs.getString("EMAILID")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
