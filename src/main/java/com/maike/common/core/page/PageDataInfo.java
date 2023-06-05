package com.maike.common.core.page;

import java.io.Serializable;

/**
 * @program: SpringBootCodeGenerator
 * @description: 分页数据对应返回的对象
 * @author: GarryChan
 * @create: 2020-12-03 14:55
 **/
public class PageDataInfo<T> implements Serializable {

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private T rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    /**
     * 表格数据对象
     */
    public PageDataInfo(){

    }
    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public PageDataInfo(T list, int total)
    {
        this.rows = list;
        this.total = total;
    }
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
