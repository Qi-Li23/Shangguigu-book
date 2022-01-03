package com.lq.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author qili
 * @create 2021-12-04-13:50
 */
public abstract class BaseDAO<T> {
    private QueryRunner runner = new QueryRunner();
    private Class<T> clazz = null;
    {
        //获取当前BaseDAO的子类继承父类的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取父类的泛型参数
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        //泛型的第一个参数
        clazz = (Class<T>) actualTypeArguments[0];
    }

    /**
     * 通用的增删改操作
     * @param conn 数据库连接
     * @param sql 执行的sql语句
     * @param args sql语句对应的参数
     * @return 如果返回-1表示执行失败，否则返回数据库表中受影响的行数
     */
    public int update(Connection conn, String sql, Object ... args) {
        try {
            int updateCount = runner.update(conn, sql, args);
            return updateCount;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 通用的查询操作，返回数据表中的一条记录
     * @param conn 数据库连接
     * @param sql 执行的sql语句
     * @param args sql语句对应的参数
     * @return 返回该条记录对应的bean对象
     */
    public T queryForOne(Connection conn, String sql, Object ... args) {
        BeanHandler<T> beanHandler = new BeanHandler<T>(clazz);
        try {
            T t = runner.query(conn, sql, beanHandler, args);
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通用的查询操作，返回数据表中的多条记录
     * @param conn 数据库连接
     * @param sql 执行的sql语句
     * @param args sql语句对应的参数
     * @return 返回多条记录对应的bean组成的list
     */
    public List<T> queryForList(Connection conn, String sql, Object ... args) {
        BeanListHandler<T> beanListHandler = new BeanListHandler<>(clazz);
        try {
            List<T> list = runner.query(conn, sql, beanListHandler, args);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通用的查询特殊值操作
     * @param conn 数据库连接
     * @param sql 执行的sql语句
     * @param args sql语句对应的参数
     * @return
     */
    public Object queryForSingleValue(Connection conn, String sql, Object ... args) {
        ScalarHandler scalarHandler = new ScalarHandler();
        try {
            Object query = runner.query(conn, sql, scalarHandler, args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
