package net.xdclass.demo_project.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @ClassName : VideoOrderTask  //类名
 * @Description : 定时统计订单  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-22 22:06  //时间
 */
@Component
public class VideoOrderTask {

    //每2秒执行一次
    @Scheduled(fixedRate = 2000)
    public void sum() {
        System.out.println(LocalDateTime.now() + "当前交易额=" + Math.random());
    }
}
