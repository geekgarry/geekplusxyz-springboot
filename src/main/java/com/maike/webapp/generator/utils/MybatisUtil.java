package com.maike.webapp.generator.utils;

import com.maike.webapp.generator.dao.TableDao;
import com.maike.webapp.generator.entity.TableColumnInfo;
import com.maike.webapp.generator.entity.TableInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring-boot-api-project-seed
 * @description: 代码生成工具类
 * @author: GarryChan
 * @create: 2020-11-18 11:31
 **/
public class MybatisUtil {
    //factory实例化的过程是一个比较耗费性能的过程.
    //保证有且只有一个factory
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
    private static String CONFIG_PATH= "mybatis/mybatis.xml";

    static{
        try {
            InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 获取SqlSession的方法
     */
    public static SqlSession getSqlSession(){
        SqlSession session = tl.get();
        if(session==null){
            tl.set(factory.openSession());
        }
        return tl.get();
    }

    /*
     * 获取数据库访问链接
     */
    public static SqlSession getSqlSession2() {
        SqlSession session = null;
        try {
            InputStream stream = Resources.getResourceAsStream(CONFIG_PATH);
            // 可以根据配置的相应环境读取相应的数据库环境
            // SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
            // stream, "development");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
        SqlSession session = tl.get();
        if(session!=null){
            session.close();
        }
        tl.set(null);
    }
    public static List<String> getTableNameList(){
        List<String> tableNameList = null;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TableDao tableDao = sqlSession.getMapper(TableDao.class);
        tableNameList=tableDao.listTableName();
        MybatisUtil.closeSqlSession(null);
        return tableNameList;
    }
    //查询所有表
    public static List<TableInfo> getTableInfoList(String[] tableNames){
        List<TableInfo> tableList = null;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TableDao tableDao = sqlSession.getMapper(TableDao.class);
        if(tableNames!=null){
            tableList = tableDao.listTableByNames(tableNames);
        }else {
            tableList=tableDao.listTable();
        }
        MybatisUtil.closeSqlSession(null);
        return tableList;
    }
    public static List<TableInfo> getTableInfoList(){
        List<TableInfo> tableList = new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TableDao tableDao = sqlSession.getMapper(TableDao.class);
        List<String> tableNames=tableDao.listTableName();
        for(String tableName:tableNames) {
            TableInfo tableInfo=null;
            tableInfo=tableDao.selectTableByName(tableName);
            System.out.println(tableDao.selectTableByName(tableName).getTableName());

            tableInfo.setPkColumn(tableDao.selectColumnTableByPk(tableName));
            tableInfo.setAllColumns(tableDao.listColumnTable(tableName));
            tableList.add(tableInfo);
        }
        MybatisUtil.closeSqlSession(null);
        return tableList;
    }
    public static TableInfo getTableByName(String tableName){
        TableInfo tableInfo = null;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TableDao tableDao = sqlSession.getMapper(TableDao.class);
        tableInfo = tableDao.selectTableByName(tableName);
        //System.out.println(tableDao.selectTableByName(tableName));
        tableInfo.setPkColumn(tableDao.selectColumnTableByPk(tableName));
        tableInfo.setAllColumns(tableDao.listColumnTable(tableName));
        MybatisUtil.closeSqlSession(null);
        return tableInfo;
    }
    public static List<TableColumnInfo> getColumnTableList(String tableName){
        List<TableColumnInfo> tableList = null;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TableDao tableDao = sqlSession.getMapper(TableDao.class);
        tableList = tableDao.listColumnTable(tableName);
        MybatisUtil.closeSqlSession(null);
        return tableList;
    }

    public static void main(String[] args) {
        //System.out.println("数据表的信息 = [tableList:" + getTableInfoList().get(0).getPkColumn().get(0).getJavaField() + "]");
        System.out.println("表的详细数据 = [" + JSONObjectUtil.objectToJson(getTableByName("fire_company")) + "]");
    }
}
