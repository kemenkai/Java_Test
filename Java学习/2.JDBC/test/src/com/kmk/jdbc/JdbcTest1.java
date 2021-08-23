package com.kmk.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author kemengkai
 * @create 2021-08-20 9:07
 */
public class JdbcTest1 {
    public static void main(String[] args) throws Exception {
        JdbcTest1 jdbcTest1 = new JdbcTest1();
        jdbcTest1.testConnection5();
    }

    /**
     * 方式1
     */
    void testConnection1() throws Exception {
        // 获取Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/smart-admin-dev";

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection connect = driver.connect(url, info);

        System.out.println("connect1 = " + connect);
    }

    /**
     * 方式二： 对方式1的迭代, 在如下的程序中不出现第三方的api, 是的程序具有更好的可移植性
     */
    void testConnection2() throws Exception {
        // 1. 获取Driver实现类对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");

        Driver driver = (Driver)clazz.newInstance();

        // 2. 提供要链接的数据库
        String url = "jdbc:mysql://localhost:3306/smart-admin-dev";

        // 3. 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        // 4. 获取链接
        Connection connect = driver.connect(url, info);

        System.out.println("connect2 = " + connect);
    }

    /**
     * 方式三： 使用DriverManager替换Driver
     */
    void testConnection3() throws Exception {
        // 1. 获取Driver实现类对象
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        // 1.2 获取对象
        Driver driver = (Driver)clazz.newInstance();
        // 1.3 注册驱动
        DriverManager.registerDriver(driver);
        // 提供另外三个链接的基本信息
        String url = "jdbc:mysql://localhost:3306/smart-admin-dev";
        String user = "root";
        String password = "root";
        // 1.4 获取链接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("connect3 = " + connection);
    }

    /**
     * 方式四： 在三的基础上优化, 可以只是加载驱动，不用显示的注册驱动了
     */
    void testConnection4() throws Exception {
        // 提供另外三个链接的基本信息
        String url = "jdbc:mysql://localhost:3306/smart-admin-dev";
        String user = "root";
        String password = "root";

        // 1. 加载Driver
        Class.forName("com.mysql.jdbc.Driver");
        // 相较于方式三，可以省略如下的操作
        // 1.2 获取对象
        //       Driver driver= (Driver) clazz.newInstance();
        // 1.3 注册驱动
        //        DriverManager.registerDriver(driver);
        // 为什么可以省略上述操作呢？
        /**
         * 在mysqlde Driver实现类中，声明了如下的操作
         * static {
         *         try {
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         */
        // 1.4 获取链接
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("connect4 = " + connection);
    }

    /**
     * 方式五(final版)： 将数据库链接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取链接
     *
     * 此种方式的好处？
     *  1. 实现了数据与代码的分离。实现了解耦
     *  2. 如果需要修改配置文件信息，可以避免程序重写打包
     *
     */
    void testConnection5() throws Exception {
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
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("connection5 = " + connection);
    }

}
