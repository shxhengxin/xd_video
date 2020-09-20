package net.xdclass.demo_project.controller;

import net.xdclass.demo_project.config.WXConfig;
import net.xdclass.demo_project.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : TestController  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-20 13:37  //时间
 */
@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {
    @Value("${wxpay.appid}")
    private String PayAppid;
    @Value("${wxpay.secret}")
    private String PaySecret;

    @Autowired
    private WXConfig wxConfig;
    @GetMapping("get_config")
    public JsonData testConfig() {
        Map<String,String> map = new HashMap<>();
        map.put("appid", wxConfig.getPayAppid());
        map.put("secret",wxConfig.getPaySecret());
        System.out.println(wxConfig.getPayMechId());
        return  JsonData.buildSuccess(map);

    }
}
