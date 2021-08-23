package com.kmk.jdbc;

import com.kmk.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kemengkai
 * @create 2021-08-20 11:05
 *
 *  PreparedStatement除了解决Statement的拼串、sql注入问题之外，PreparedStatement还有哪些好处？
 *   1. PreparedStatement可以操作Blob的数据，而Statement做不到
 *   2. PreparedStatement可以实现更搞笑的批量操作
 */
public class PreparedStatementForQuery {
    public static void main(String[] args) {
        PreparedStatementForQuery customerForQuery = new PreparedStatementForQuery();
        //        customerForQuery.testQuery1();
        String sql = "SELECT * FROM t_role WHERE id = ?";
        Role role = customerForQuery.queryForRole(sql, 1);
        System.out.println("role = " + role);

        sql = "SELECT id, role_name FROM t_role WHERE id = ?";
        role = customerForQuery.queryForRole(sql, 1);
        System.out.println("role = " + role);
    }

    /**
     * 一个对象通用的查询方法
     */
    public <T> T queryForRole3(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据: ResultSetMetaData
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            // ResultSetMetaData获取结果集中的列数
            int columnCount = resultSetMetaData.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                // 处理数据集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);

                    // getColumnName: 获取每个列的列名,非别名 --- 不推荐使用
                    // getColumnLabel: 获取每个列的别名
                    //                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);

                    // 给Employee对象指定的columnName属性，赋值为columnName: 通过反射
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    /**
     * 针对t_role表的通用的查询操作优化
     * 针对于表的字段名与类的属性名不相同的情况:
     *   1. 必须声明sql时， 使用类的属性名来命名字段的别名
     *   2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
     *      获取列的别名
     *   说明：如果sql中没有给字段起别名，getColumnLabel() 获取的就是列名
     */
    public Role queryForRole2(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据: ResultSetMetaData
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            // ResultSetMetaData获取结果集中的列数
            int columnCount = resultSetMetaData.getColumnCount();
            if (rs.next()) {
                Role employee = new Role();
                // 处理数据集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);

                    // getColumnName: 获取每个列的列名,非别名 --- 不推荐使用
                    // getColumnLabel: 获取每个列的别名
                    //                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);

                    // 给Employee对象指定的columnName属性，赋值为columnName: 通过反射
                    Field declaredField = Role.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(employee, columnValue);
                }
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    /**
     * 针对t_role表的通用的查询操作
     */
    public Role queryForRole(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据: ResultSetMetaData
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            // ResultSetMetaData获取结果集中的列数
            int columnCount = resultSetMetaData.getColumnCount();
            if (rs.next()) {
                Role employee = new Role();
                // 处理数据集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);

                    // getColumnName: 获取每个列的列名,非别名 --- 不推荐使用
                    // getColumnLabel: 获取每个列的别名
//                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    // 针对于表的字段名与类的属性名不相同的情况:
                    // 必须声明sql时， 使用类的属性名来命名字段的别名
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);

                    // 给Employee对象指定的columnName属性，赋值为columnName: 通过反射
                    Field declaredField = Role.class.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(employee, columnValue);
                }
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select * from t_role where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 1);

            // 执行, 并返回结果集
            resultSet = ps.executeQuery();

            // 处理结果集
            // 判断结果集的下一条是否有数据，如果有数据返回true，并指针下移;
            // 如果返回false指针不会下移
            if (resultSet.next()) {
                // 获取当前这条数据的各个字段值
                Long id = resultSet.getLong(1);
                String roleName = resultSet.getString(2);
                String remark = resultSet.getString(3);
                Long parentId = resultSet.getLong(4);
                Integer sort = resultSet.getInt(5);
                Timestamp updateTime = resultSet.getTimestamp(6);
                Timestamp createTime = resultSet.getTimestamp(7);

                // 方式一： 直接显示
                //            System.out.println("remark = " + remark);

                // 方式二: 封装到数组中
                //            Object[] data = new Object[] {id, role_name, remark, parent_id, sort, update_time, create_time};

                // 方式三:
                Role employee = new Role(id, roleName, remark, parentId, sort, updateTime, createTime);
                System.out.println("employee = " + employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }

    /**
     * 多个对象通用的查询方法
     */
    public <T> List<T> queryForRole4(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据: ResultSetMetaData
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            // ResultSetMetaData获取结果集中的列数
            int columnCount = resultSetMetaData.getColumnCount();
            // 创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                // 处理数据集一行数据中的每一个列: 给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);

                    // getColumnName: 获取每个列的列名,非别名 --- 不推荐使用
                    // getColumnLabel: 获取每个列的别名
                    //                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    String columnLabel = resultSetMetaData.getColumnLabel(i + 1);

                    // 给Employee对象指定的columnName属性，赋值为columnName: 通过反射
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t, columnValue);
                }
                // 添加t到集合中
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
