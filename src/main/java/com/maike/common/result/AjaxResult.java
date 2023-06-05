package com.maike.common.result;

import com.alibaba.fastjson.JSON;
import com.maike.common.constant.HttpStatus;

import java.util.HashMap;

/**
 * 统一API响应结果封装
 */
public class AjaxResult<T> extends HashMap {
    private int code;
    private String msg;
    private T data;

    public AjaxResult(){
    }

    public AjaxResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResult(int code, T data, String msg) {
        this.code = code;
        this.data=data;
        this.msg = msg;
    }

    public AjaxResult(ResultStatusEnum status) {
        this(status,null);
    }

    public AjaxResult(ResultStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public AjaxResult(ResultStatusEnum status, String msg, T data) {
        this.code = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    public AjaxResult setCode(ResultStatusEnum resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public AjaxResult setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> AjaxResult success(){
        AjaxResult result = new AjaxResult();
        result.setCode(ResultStatusEnum.SUCCESS);
        result.setMsg(ResultStatusEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> AjaxResult success(T data){
        AjaxResult result = new AjaxResult();
        result.setCode(ResultStatusEnum.SUCCESS);
        result.setData(data);
        result.setMsg(ResultStatusEnum.SUCCESS.getMsg());
        return result;
    }

    public static <T> AjaxResult error(){
        AjaxResult result = new AjaxResult();
        result.setCode(ResultStatusEnum.FAIL);
        result.setMsg(ResultStatusEnum.FAIL.getMsg());
        return result;
    }

    public static <T> AjaxResult error(String msg){
        AjaxResult result = new AjaxResult();
        result.setCode(ResultStatusEnum.FAIL);
        result.setMsg(msg);
        return result;
    }

    public static <T> AjaxResult authorizationError(){
        AjaxResult result = new AjaxResult();
        result.setCode(ResultStatusEnum.UNAUTHORIZED);
        result.setMsg(ResultStatusEnum.UNAUTHORIZED.getMsg());
        return result;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
