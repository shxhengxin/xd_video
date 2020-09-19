package net.xdclass.demo_project.controller;

import net.xdclass.demo_project.domain.Chapter;
import net.xdclass.demo_project.domain.Video;
import net.xdclass.demo_project.service.VideoService;
import net.xdclass.demo_project.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    //@RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("list")
    public JsonData list() {
        List<Video> list = videoService.listVideo();
        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video) {

        for (Chapter chapter: video.getChapterList()
             ) {
            chapter.setVideoId(video.getId());
        }
        System.out.println(video.toString());
        return  JsonData.buildSuccess(video);
    }
}
