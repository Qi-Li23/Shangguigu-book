package com.lq.test;

import com.lq.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author qili
 * @create 2021-12-04-12:35
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }
    }
}
