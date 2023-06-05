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

    public static AjaxResult genSuccessResult() {
        return new AjaxResult()
                .setCode(ResultStatusEnum.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> AjaxResult<T> genSuccessResult(T data) {
        return new AjaxResult()
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

    public static AjaxResult genFailResult(String message) {
        return new AjaxResult()
                .setCode(ResultStatusEnum.FAIL)
                .setMsg(message);
    }
}
