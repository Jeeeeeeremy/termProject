import utils.JDBCUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class test {
    public static void main(String[] args) {
        Connection con = JDBCUtil.getConnection();
        System.out.println(con);
    }


}
