package net.xdclass.demo_project.controller;

import net.xdclass.demo_project.domain.User;
import net.xdclass.demo_project.service.UserService;
import net.xdclass.demo_project.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : UserController  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 20:00  //时间
 */
@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {
    @Autowired
    private UserService userService;
   /* @PostMapping("login")
    public JsonData login(String pwd,String username) {
        System.out.println("pwd="+ pwd + "  username=" + username);
        return JsonData.buildSuccess("");
    }*/
   @PostMapping("login")
   public JsonData login(@RequestBody User user) {
       String token = userService.login(user);
       return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("帐号密码错误");
   }
   /***
    * @author shenhengxin
    * @description 列出所有用户
    * @Date 22:38 2020/9/19
    * @Param []
    * @return net.xdclass.demo_project.utils.JsonData
    */
   @GetMapping("list")
   public JsonData list() {
       List<User> list = userService.listUser();
       return JsonData.buildSuccess(list);
   }
}
