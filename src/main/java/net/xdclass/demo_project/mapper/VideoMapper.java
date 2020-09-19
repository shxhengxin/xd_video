package net.xdclass.demo_project.mapper;

import net.xdclass.demo_project.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : VideoMapper  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 18:44  //时间
 */
@Repository
public class VideoMapper {
    private static Map<Integer, Video> videoMap = new HashMap<>();
    static {
        videoMap.put(1,new Video(1,"java基础课程"));
        videoMap.put(2,new Video(2,"SpringBoot2.x"));
        videoMap.put(3,new Video(3,"微服务SpringCloud"));
        videoMap.put(4,new Video(4,"SpringBoot实战微信支付课程"));
        videoMap.put(5,new Video(5,"小滴课堂面试专题"));
    }

    public List<Video> listVideo() {
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }
}
