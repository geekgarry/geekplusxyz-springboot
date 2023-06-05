package com.maike.webapp.generator.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @program: spring-boot-project-mybatis
 * @description: 代码生成的操作以及一些字段属性以及表名的一些操作
 * @author: GarryChan
 * @create: 2020-11-27 10:45
 **/
public class GenUtil {
    /**
     * 首字母大写
     * @param str
     * @return
     */
    public static String capitaFirstLetter(String str) {
        if (null == str) {
            return null;
        } else if ("".equals(str)) {
            return str;
        }
        return Character.toTitleCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 把表名中的_替换掉，把被_隔开的首字母都变为大写
     * @param tableName
     * @return
     */
    public static String mapUnderscoreToCamelCase(String tableName){
        StringBuilder sb = new StringBuilder();
        // 清除sb缓存
        sb.setLength(0);
        String tableNameNew = tableName.replaceFirst("tb_", "");
        String [] tableNameArray =  tableNameNew.split("_");
        Integer length = tableNameArray.length;
        // 重新赋值
        for(int i=0;i<length;i++){
            sb.append((tableNameArray[i].charAt(0)+"").toUpperCase());
            sb.append(tableNameArray[i].substring(1));
        }
        return sb.toString();
    }
    /**
     * 把表名中的_替换掉，把被_隔开的首字母都变为大写，但第一段的首字母为小写
     * @param tableName
     * @return
     */
    public static String mapTableNameToVarName(String tableName){
        StringBuilder sb = new StringBuilder();

        // 清除sb缓存
        sb.setLength(0);
        String tableNameNew = tableName.replaceFirst("tb_", "");
        String [] tableNameArray =  tableNameNew.split("_");
        Integer length = tableNameArray.length;
        // 重新赋值
        sb.append(tableNameArray[0]);
        for(int i=1;i<length;i++){
            sb.append((tableNameArray[i].charAt(0)+"").toUpperCase());
            sb.append(tableNameArray[i].substring(1));
        }
        return sb.toString();
    }
    /**
     * 将表中列名去下划线且下划线后每一段首字母大写其他字母小写
     * @param columnName 表中列名
     * @return java类属性名
     */
    public static String columnNameToProName(String columnName) {
        if (columnName == null) {
            return null;
        }
        StringBuilder fieldName = new StringBuilder();
        boolean toUpper = false;
        for (int i = 0; i < columnName.length(); i++) {
            char ch = columnName.charAt(i);
            if (ch == '_') {
                toUpper = true;
            } else if (toUpper == true) {
                fieldName.append(Character.toUpperCase(ch));
                toUpper = false;
            } else {
                fieldName.append(Character.toLowerCase(ch));
            }
        }
        return capitaFirstLetter(fieldName.toString());
    }

    /**
     * 将表中列名去下划线且下划线后第一段字符串首字母小写其他每段首字母都大写
     * @param columnName 表中列名
     * @return java类属性名
     */
    public static String columnNameToVarName(String columnName) {
        if (columnName == null) {
            return null;
        }
        StringBuilder fieldName = new StringBuilder();
        boolean toUpper = false;
        for (int i = 0; i < columnName.length(); i++) {
            char ch = columnName.charAt(i);
            if (ch == '_') {
                toUpper = true;
            } else if (toUpper == true) {
                fieldName.append(Character.toUpperCase(ch));
                toUpper = false;
            } else {
                fieldName.append(Character.toLowerCase(ch));
            }
        }
        return fieldName.toString();
    }
    /**
     * 将数据库类型转换成java类型
     * @param columnType 数据库类型
     * @return java类型
     */
    public static String dbTypeToJavaType(String columnType) {
        String type = "";
        if (columnType == null || columnType.trim().equals("")) {
            return null;
        }
        if (columnType.equals("VARCHAR")||columnType.equals("varchar")) {
            type = "String";
        } else if (columnType.equals("DATE")||columnType.equals("date")) {
            type = "Date";
        } else if (columnType.equals("DATETIME")||columnType.equals("datetime")) {
            type = "Date";
        } else if (columnType.equals("CHAR")||columnType.equals("char")) {
            type = "String";
        } else if (columnType.equals("INT")||columnType.equals("int")) {
            type = "Integer";
        } else if (columnType.equals("INT UNSIGNED")||columnType.equals("int unsigned")) {
            type = "Integer";
        } else if (columnType.equals("TINYINT")||columnType.equals("tinyint")) {
            type = "Integer";
        } else if (columnType.equals("BIGINT")||columnType.equals("bigint")) {
            type = "Long";
        } else if (columnType.equals("SMALLINT")||columnType.equals("smallint")) {
            type = "Integer";
        } else if (columnType.equals("TEXT")||columnType.equals("text")) {
            type = "String";
        } else if (columnType.equals("MEDIUMBLOB")||columnType.equals("mediumblob")) {
            type = "byte[]";
        } else if (columnType.equals("DOUBLE")||columnType.equals("double")) {
            type = "Double";
        } else if (columnType.equals("FLOAT")||columnType.equals("float")) {
            type = "Float";
        } else if (columnType.equals("DECIMAL")||columnType.equals("decimal")) {
            type = "BigDecimal";
        } else {
            System.out.println("columnType[" + columnType + "]");
            type = null;
        }
        return type;
    }
    /**
     * 将数据库类型转换成mybatis配置文件类型
     * @param sqlTypeName 数据库类型
     * @return mybatis配置文件类型
     */
    public static String mybatisType(String sqlTypeName){
        String type = "";
        if (sqlTypeName == null || sqlTypeName.trim().equals("")) {
            return null;
        }
        if(sqlTypeName.equals("varchar") || sqlTypeName.equals("text")){
            type = "VARCHAR";
        }else if(sqlTypeName.equals("tinyblob") || sqlTypeName.equals("blob") || sqlTypeName.equals("mediumblob")){
            type = "BLOB";
        } else if (sqlTypeName.equals("bigint")) {
            type = "INTEGER";
        } else if (sqlTypeName.equals("tinyint")) {
            type = "INTEGER";
        } else if (sqlTypeName.equals("smallint")) {
            type = "INTEGER";
        } else if (sqlTypeName.equals("char")) {
            type = "CHAR";
        } else if (sqlTypeName.equals("int")) {
            type = "INTEGER";
        } else if (sqlTypeName.equals("datetime") || sqlTypeName.equals("date")) {
            type = "TIMESTAMP";
        } else if (sqlTypeName.equals("decimal")) {
            type = "DECIMAL";
        } else if (sqlTypeName.equals("int unsigned")) {
            type = "INTEGER";
        } else {
            System.out.println("sqlTypeName[" + sqlTypeName + "]");
            type = null;
        }
        return type;
    }
    public static String getFileName(String tableName, String flag){
        String retName;
        switch(flag){
            case "Dto"  : retName = tableName + "Dto"; break;
            case "Vo"  : retName = tableName + "Vo"; break;
            default : retName = null;
        }
        return retName;
    }

    public static String getRequestMapping(String tableName){
        StringBuilder sb = new StringBuilder();
        // 清除sb缓存
        sb.setLength(0);
        String tableNameNew = tableName.replaceFirst("tb_", "");
        String [] tableNameArray =  tableNameNew.split("_");
        Integer length = tableNameArray.length;
        // 重新赋值
        for(int i=0;i<length;i++){
            sb.append("/"+tableNameArray[i]);
        }
        return sb.toString();
    }

    /**
     * 获取数据库类型字段
     *
     * @param columnType 列类型
     * @return 截取后的列类型
     */
    public static String getDbColumnType(String columnType)
    {
        if (StringUtils.indexOf(columnType, "(") > 0)
        {
            return StringUtils.substringBefore(columnType, "(");
        }
        else
        {
            return columnType;
        }
    }

    /**
     * 获取字段长度
     *
     * @param columnType 列类型
     * @return 截取后的列类型
     */
    public static Integer getColumnLength(String columnType)
    {
        if (StringUtils.indexOf(columnType, "(") > 0)
        {
            String length = StringUtils.substringBetween(columnType, "(", ")");
            return Integer.valueOf(length);
        }
        else
        {
            return 0;
        }
    }

    /**
     * 把表名以_分割转换为每一小段的首字母缩写，用于表的别名
     * @param tableName
     * @return
     */
    public static String getFirstChar(String tableName){
        StringBuilder sb = new StringBuilder();
        // 清除sb缓存
        sb.setLength(0);
        String tableNameNew = tableName.replaceFirst("tb_", "");
        String [] tableNameArray =  tableNameNew.split("_");
        for(String name:tableNameArray){
            sb.append(name.substring(0,1));
        }
        return sb.toString();
    }
    /**
     * 包名处理成路径名
     * @param packageName
     * @return
     */
    public static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

    public static void main(String[] args) {
        //System.out.println("args = [" + mapTableNameToVarName("login_user") + "]");
        System.out.println(getRequestMapping("fire_company"));
        //System.out.println(getFirstChar("fire_company_hazard"));
    }

}
