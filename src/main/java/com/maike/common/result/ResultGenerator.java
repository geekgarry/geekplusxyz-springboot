package com.maike.common.result;

import com.github.pagehelper.PageInfo;
import com.maike.common.core.page.PageDataInfo;
import com.maike.common.constant.HttpStatus;

import java.util.List;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultStatusEnum.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setCode(ResultStatusEnum.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /**
     * 响应请求分页数据
     */
    public static  PageDataInfo getPageData(List<?> list){
        PageDataInfo rspData = new PageDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultStatusEnum.FAIL)
                .setMsg(message);
    }
}
