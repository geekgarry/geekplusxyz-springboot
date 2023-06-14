/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 2022/4/21 11:15 上午
 * description: 做什么的？
 */
package com.maike.webapp.function.controller;

import com.maike.common.result.Result;
import com.maike.common.utils.http.HttpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
public class Covid19DataController {
    @RequestMapping(value="/getAllData",method = {RequestMethod.POST, RequestMethod.GET})
    public Result getCovidAllData(){
        Object info= HttpUtils.sendGet("https://c.m.163.com/ug/api/wuhan/app/data/list-total","");
//        System.out.println("疫情请求数据："+info);
//        Object covid=JsonUtil.stringToJsonByFastjson("data",info);
        return Result.success(info);
    }
    @RequestMapping(value = "/getCovid19ByProvince",method = {RequestMethod.POST, RequestMethod.GET})
    public Result getCovid19ByProvince(@RequestParam String province){
        if(province.equals("")||province==null){
            province="江苏";
        }
        Object info = HttpUtils.sendGet("https://api.inews.qq.com/newsqa/v1/query/pubished/daily/list",province);
        return Result.success(info);
    }
    @RequestMapping(value = "/getCovid19History",method = {RequestMethod.POST, RequestMethod.GET})
    public Result getCovid19History(){
        Object info = HttpUtils.sendGet("https://view.inews.qq.com/g2/getOnsInfo?name=disease_other","");
        return Result.success(info);
    }
    @RequestMapping(value = "/getCovid19Total",method = {RequestMethod.POST, RequestMethod.GET})
    public Result getCovid19Total(){
        Object info = HttpUtils.sendGet("https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5","");
        return Result.success(info);
    }
    @RequestMapping(value = "/getCovid19Foreign",method = {RequestMethod.POST, RequestMethod.GET})
    public Result getCovid19Foreign(){
        Object info = HttpUtils.sendGet("https://api.inews.qq.com/newsqa/v1/automation/foreign/country/ranklist","");
        return Result.success(info);
    }
    @RequestMapping(value = "/getCovid19GlobalData",method = {RequestMethod.POST, RequestMethod.GET})
    public Result getCovid19AllData(){
        Object info = HttpUtils.sendGet("https://api.inews.qq.com/newsqa/v1/automation/modules/list?modules=FAutoGlobalStatis,FAutoContinentStatis,FAutoGlobalDailyList,FAutoCountryConfirmAdd","");
        return Result.success(info);
    }
}
