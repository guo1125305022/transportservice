package type.jason.action.dataBase;

import java.sql.*;

/**
 * Created by Admin on 2017/5/11.
 * 数据库连接工具类
 */
public class DbConnect {
    private static Connection conn = null;
    private static final String USER_NAME = "root";//数据库连接用户名
    private static final String USER_PWD = "123456";//数据库连接密码
    private static final String ADRR = "localhost";//链接地址
    private static final int PORT = 3306;//链接端口
    private static final String DATABASE_NAME = "gs_transportdb";//链接的数据库名称
    private static final String CHARACTER_ENCODING = "utf-8";//指定数据库连接字符编码
    private static final String USER_UNICODE = "true";//是否使用自定义编码
    private static final String BASE_SQL_CONNECTION_ADRR = "jdbc:mysql://%s:%d/%s?user=%s&password=%s&useUnicode=%s&characterEncoding=%s";

    public static Connection getConnect() {
        if (conn != null) {
            return conn;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String format = String.format(BASE_SQL_CONNECTION_ADRR, ADRR, PORT, DATABASE_NAME, USER_NAME, USER_PWD, USER_UNICODE, CHARACTER_ENCODING);
            conn = DriverManager.getConnection(format);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement sm) {
        if (sm != null) {
            try {
                sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
