package com.kmk.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author kemengkai
 * @create 2021-08-20 10:41
 * 操作数据库的工具类
 */
public class JDBCUtils {
    public static Connection getConnection() throws Exception {
        // 1. 读取配置文件中的4个基本信息
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        // 2. 加载驱动
        Class.forName(driverClass);

        // 3. 获取链接
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭链接和Statement的操作
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps) {
        // 7. 资源的关闭
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭链接和Statement的操作
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        // 7. 资源的关闭
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
