import java.sql.*;
public class SavepointDemo {
    public static void main(String[] args) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/universitydb",
                "root",
                "password"
            );
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            st.executeUpdate(
                "UPDATE Student SET EMAILID='new@mail.com' WHERE ID=1"
            );
            Savepoint sp =
                con.setSavepoint("after_email_update");
            st.executeUpdate(
                "INSERT INTO Department VALUES(1,'CSE')"
            );
            con.commit();
            System.out.println("Transaction Successful");
        } catch (Exception e) {
            try {
                con.rollback();
                System.out.println("Transaction Rolled Back");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (Exception e) {}
        }
    }
}
