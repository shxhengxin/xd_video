package net.xdclass.demo_project.controller;

import net.xdclass.demo_project.utils.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : VideoOrderController  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-20 17:08  //时间
 */
@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {
    @PostMapping("save")
    public JsonData saveOrder() {
        return JsonData.buildSuccess("下单成功");
    }
}
