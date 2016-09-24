package com.alibaba.druid.bvt.sql;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcConstants;
import junit.framework.TestCase;

import java.util.Collections;
import java.util.Map;

/**
 * Created by wenshao on 16/9/25.
 */
public class MappingTest_delete extends TestCase {
    private String sql = "delete from user";
    Map<String, String> mapping = Collections.singletonMap("user", "user_01");

    public void test_mapping() throws Exception {
        String result = SQLUtils.refactor(null, sql, mapping);
        assertEquals("DELETE FROM user_01", result);
    }

    public void test_mapping_mysql() throws Exception {
        String result = SQLUtils.refactor(JdbcConstants.MYSQL, sql, mapping);
        assertEquals("DELETE FROM user_01", result);
    }

    public void test_mapping_pg() throws Exception {
        String result = SQLUtils.refactor(JdbcConstants.POSTGRESQL, sql, mapping);
        assertEquals("DELETE FROM user_01", result);
    }

    public void test_mapping_oracle() throws Exception {
        String result = SQLUtils.refactor(JdbcConstants.ORACLE, sql, mapping);
        assertEquals("DELETE FROM user_01", result);
    }

    public void test_mapping_sqlserver() throws Exception {
        String result = SQLUtils.refactor(JdbcConstants.SQL_SERVER, sql, mapping);
        assertEquals("DELETE FROM user_01", result);
    }

    public void test_mapping_db2() throws Exception {
        String result = SQLUtils.refactor(JdbcConstants.DB2, sql, mapping);
        assertEquals("DELETE FROM user_01", result);
    }
}
