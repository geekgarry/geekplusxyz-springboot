/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 5/26/23 23:29
 * description: 做什么的？
 */
package com.maike.webapp.function.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("message","hello world");
        return "index";
    }
    @RequestMapping({"/admin"})
    public String admin(Model model){
        model.addAttribute("message","这是管理后台！");
        return "admin/index";
    }
}
