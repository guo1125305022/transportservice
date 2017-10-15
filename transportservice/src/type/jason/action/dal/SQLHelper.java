package type.jason.action.dal;

import type.jason.action.dataBase.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by JKX_GXL on 2017/5/12.
 * sql语句执行帮助类
 */
public class SQLHelper {

    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection connection = DbConnect.getConnect();
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public static boolean execute(String sql) throws SQLException {
        Connection connection = DbConnect.getConnect();
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }
}
