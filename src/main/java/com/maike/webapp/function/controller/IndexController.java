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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("message","hello world");
        return "index";
    }
}
