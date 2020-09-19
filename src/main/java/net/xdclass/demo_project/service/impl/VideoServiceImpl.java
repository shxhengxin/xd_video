package net.xdclass.demo_project.service.impl;

import net.xdclass.demo_project.domain.Video;
import net.xdclass.demo_project.mapper.VideoMapper;
import net.xdclass.demo_project.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : VideoServiceImpl  //类名
 * @Description : 视频实现类  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 18:42  //时间
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> listVideo() {
        return  videoMapper.listVideo();
    }
}
