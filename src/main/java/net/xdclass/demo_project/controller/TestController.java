package net.xdclass.demo_project.controller;

import net.xdclass.demo_project.config.WXConfig;
import net.xdclass.demo_project.task.AsyncTack;
import net.xdclass.demo_project.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
    private AsyncTack asyncTack;

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
    @GetMapping("async")
    public JsonData testAsync() {
        long begin = System.currentTimeMillis();
        /*asyncTack.task1();
        asyncTack.task2();
        asyncTack.task3();*/
        Future<String> task4 = asyncTack.task4();
        Future<String> task5 = asyncTack.task5();


        for (;;){
            if(task4.isDone() && task5.isDone()) {
                try {
                    String task4Result = task4.get();
                    System.out.println(task4Result);
                    String task5Result = task5.get();
                    System.out.println(task5Result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            }
        }

        long end = System.currentTimeMillis();
       return JsonData.buildSuccess(end-begin);
    }
}
