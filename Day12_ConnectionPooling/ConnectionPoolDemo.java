import java.sql.*;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
public class ConnectionPoolDemo {
    public static void main(String[] args) throws Exception {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(
            "jdbc:mysql://localhost:3306/test");
        ds.setUser("root");
        ds.setPassword("password");
        Connection con = ds.getConnection();
        System.out.println(
            "Connection Obtained Successfully");
        con.close();
    }
}
