package com.kmk.jdbc2;

import com.kmk.jdbc.PreparedStatementForQuery;
import com.kmk.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author kemengkai
 * @create 2021-08-20 14:54
 */
public class BlobTest1 {
    public static void main(String[] args) {

    }

    /**
     * 批量插入的方式三：
     *  1. addBatch()、 executeBatch()、clearBatch()
     *  2. mysql服务器默认时关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
     *      ?rewriteBatchedStatements=true 卸载配置文件的url后面
     *  3. 使用更新的mysql驱动: mysql-connector-java-5.1.37-bin.jar及以上版本的驱动
     */
    public void testInsert2() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long startTime = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name) values (?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                // 1. "攒"sql
                ps.addBatch();
                if (i % 500 == 0) {
                    // 2. 执行batch
                    ps.executeBatch();

                    // 3. 清空batch
                    ps.clearBatch();
                }
            }

            long endTime = System.currentTimeMillis();

            System.out.println("花费的时间为：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    /**
     * 批量插入的方式四(final版)： 设置链接不允许自动提交数据
     *  1. addBatch()、 executeBatch()、clearBatch()
     *  2. mysql服务器默认时关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
     *      ?rewriteBatchedStatements=true 卸载配置文件的url后面
     *  3. 使用更新的mysql驱动: mysql-connector-java-5.1.37-bin.jar及以上版本的驱动
     */
    public void testInsert4() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            long startTime = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            // 设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql = "insert into goods(name) values (?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <= 20000; i++) {
                ps.setObject(1, "name_" + i);
                // 1. "攒"sql
                ps.addBatch();
                if (i % 500 == 0) {
                    // 2. 执行batch
                    ps.executeBatch();

                    // 3. 清空batch
                    ps.clearBatch();
                }
            }

            // 提交数据
            conn.commit();

            long endTime = System.currentTimeMillis();

            System.out.println("花费的时间为：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }
}
