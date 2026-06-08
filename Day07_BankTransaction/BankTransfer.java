import java.sql.*;
public class BankTransfer {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bankdb",
            "root",
            "password");
        con.setAutoCommit(false);
        try {
            Statement st = con.createStatement();
            st.executeUpdate(
                "UPDATE Account SET balance=balance-1000 WHERE id=1");
            st.executeUpdate(
                "UPDATE Account SET balance=balance+1000 WHERE id=2");
            con.commit();
            System.out.println("Transfer Successful");
        } catch(Exception e) {
            con.rollback();
            System.out.println("Transaction Failed");
        }
        con.close();
    }
}
