package net.xdclass.demo_project.controller;

import net.xdclass.demo_project.config.WXConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName : FreemakerController  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-22 21:36  //时间
 */
@Controller
@RequestMapping("freemarker")
public class FreemakerController {
    @Autowired
    private WXConfig wxConfig;
    @GetMapping("test")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("setting",wxConfig);
        return "user/fm/index";
    }
}
