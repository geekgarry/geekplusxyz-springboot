package com.maike.webapp.generator.dao;

import com.maike.webapp.generator.entity.TableColumnInfo;
import com.maike.webapp.generator.entity.TableInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TableDao
 * @Description:
 * @author: geekcjj
 * @date: 2018年7月26日 上午11:07:41
 */
public interface TableDao {

	//@Select("select TABLE_NAME,table_comment, create_time, update_time from information_schema.TABLES where TABLE_SCHEMA=(select database())")
	List<String> listTableName();
	List<TableInfo> listTable();
	TableInfo selectTableByName(@Param(value = "tableName") String tableName);
	List<TableInfo> listTableByNames(@Param(value = "tableName") String[] tableName);
	List<TableColumnInfo> listColumnTable(@Param(value = "tableName") String tableName);
	TableColumnInfo selectColumnTableByPk(@Param(value = "tableName") String tableName);
}
