package net.xdclass.demo_project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : VideoController  //类名
 * @Description : 视频控制器  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 15:07  //时间
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @RequestMapping("list")
    public Object list() {
        Map<String,String> map = new HashMap<>();
        map.put("1","面试专题");
        map.put("2","SpringCloud微服务");
        return  map;
    }
}
