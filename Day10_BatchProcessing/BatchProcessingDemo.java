import java.sql.*;
public class BatchProcessingDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "password");
        Statement st = con.createStatement();
        st.addBatch(
                "INSERT INTO Student VALUES(1,'Rahul')");
        st.addBatch(
                "INSERT INTO Student VALUES(2,'Aman')");
        st.addBatch(
                "INSERT INTO Student VALUES(3,'Saswati')");
        int[] result = st.executeBatch();
        System.out.println(
                result.length + " Queries Executed");
        con.close();
    }
}
