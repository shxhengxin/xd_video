package net.xdclass.demo_project.mapper;

import net.xdclass.demo_project.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : UserMapper  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 18:56  //时间
 */
public class UserMapper {
    private static Map<Integer, User> userMap = new HashMap<>();
    static {
        userMap.put(1,new User(1,"jack","123"));
        userMap.put(1,new User(2,"xdclass-lw","123"));
        userMap.put(1,new User(3,"tom","123"));
    }
}
