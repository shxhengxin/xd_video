package net.xdclass.demo_project.controller;

import net.xdclass.demo_project.domain.Video;
import net.xdclass.demo_project.service.VideoService;
import net.xdclass.demo_project.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private VideoService videoService;
    //@RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("list")
    public Object list() {
        List<Video> list = videoService.listVideo();
        return JsonData.buildSuccess(list);
    }
}
