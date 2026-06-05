import java.sql.*;
public class MetaDataDemo {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/test",
            "root",
            "password");
        DatabaseMetaData db = con.getMetaData();
        ResultSet rs =
            db.getColumns(null, null, "EMPLOYEE", null);
        while(rs.next()) {
            System.out.println(
                rs.getString("COLUMN_NAME") + " " +
                rs.getString("TYPE_NAME") + " " +
                rs.getInt("COLUMN_SIZE"));
        }
        con.close();
    }
}
