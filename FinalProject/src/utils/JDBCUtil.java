package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static final String URL="jdbc:mysql://localhost:3306/final?useSSL=false";
    private static final String NAME="root";
    private static final String PASSWORD="rootrootroot";

    private static Connection conn=null;
    //静态代码块（将加载驱动、连接数据库放入静态块中）



    //对外提供一个方法来获取数据库连接
    public static Connection getConnection(){
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得数据库的连接
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn){
        try {
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}