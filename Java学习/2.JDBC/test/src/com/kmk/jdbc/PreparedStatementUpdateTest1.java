package com.kmk.jdbc;


import com.kmk.utils.JDBCUtils;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author kemengkai
 * @create 2021-08-20 10:11
 *
 * 使用PreparedStatement来替换Statement, 实现对数据表的增删改操作
 *
 * 增删改查
 *
 *
 */
public class PreparedStatementUpdateTest1 {
    public static void main(String[] args) throws Exception {
        PreparedStatementUpdateTest1 preparedStatementUpdateTest1 = new PreparedStatementUpdateTest1();
    }

    /**
     * 向customers表中添加一条记录
     */
    void test1(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 1. 读取配置文件中的4个基本信息
            InputStream resourceAsStream = JdbcTest1.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            // 2. 加载驱动
            Class.forName(driverClass);

            // 3. 获取链接
            connection = DriverManager.getConnection(url, user, password);
            // 4. ？ 是占位符, 预编译sql语句，返回 PrepareStatement的实例
            String sql = "inset into customers(name, email, birth) values (?, ?, ?)";
            ps = connection.prepareStatement(sql);

            // 5. 填充占位符
            ps.setString(1, "aa1");
            ps.setString(2, "aa@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new Date(date.getTime()));

            // 6. 执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            // 7. 资源的关闭
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }

    /**
     * 修改customers表的一条记录
     *
     */
    public void testUpdate() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数据库的链接
            conn = JDBCUtils.getConnection();
            // 2. 预编译sql语句, 返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            // 3. 填充占位符
            ps.setObject(1,"贝多芬");
            ps.setObject(2,18);
            // 4. 执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    /**
     * 使用通用方法测试删除
     */
    public void testDelete() {
//        String sql = "delete from customers where id = ?";
//        testUpdate2(sql, 3);
        String sql = "update `order` set order_name = ? where order_id = ?";
        testUpdate2(sql, "dd", 2);
    }

    /**
     * 通用的增删改操作
     * sql中占位符的个数与可变形参的长度相同!
     */
    public void testUpdate2(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1. 获取数据库的链接
            conn = JDBCUtils.getConnection();

            // 2. 预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            // 3. 填充占位符
            for (int i = 0; i < args.length; i++ ) {
                // 小心参数声明错误
                ps.setObject(i + 1, args[i]);
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            JDBCUtils.closeResource(conn, ps);
        }
    }


}