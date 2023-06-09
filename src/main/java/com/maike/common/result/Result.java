package com.maike.common.result;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * 统一API响应结果封装
 */
public class Result<T> extends HashMap {
    private int code;
    private String msg;
    private T data;

    public Result(){
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, T data, String msg) {
        this.code = code;
        this.data=data;
        this.msg = msg;
    }

    public Result(ResultStatusEnum status) {
        this(status,null);
    }

    public Result(ResultStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public Result(ResultStatusEnum status, String msg, T data) {
        this.code = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    public Result setCode(ResultStatusEnum resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> Result success(){
        Result result = new Result();
        result.setCode(ResultStatusEnum.SUCCESS);
        result.setMsg(ResultStatusEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> Result success(T data){
        Result result = new Result();
        result.setCode(ResultStatusEnum.SUCCESS);
        result.setData(data);
        result.setMsg(ResultStatusEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> Result error(){
        Result result = new Result();
        result.setCode(ResultStatusEnum.FAIL);
        result.setMsg(ResultStatusEnum.FAIL.getMsg());
        return result;
    }

    public static <T> Result error(String msg){
        Result result = new Result();
        result.setCode(ResultStatusEnum.FAIL);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result authorizationError(){
        Result result = new Result();
        result.setCode(ResultStatusEnum.UNAUTHORIZED);
        result.setMsg(ResultStatusEnum.UNAUTHORIZED.getMsg());
        return result;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
