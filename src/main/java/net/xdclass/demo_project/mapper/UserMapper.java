package net.xdclass.demo_project.mapper;

import net.xdclass.demo_project.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : UserMapper  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 18:56  //时间
 */
@Repository
public class UserMapper {
    private static Map<String, User> userMap = new HashMap<>();
    static {
        userMap.put("jack",new User(1,"jack","123"));
        userMap.put("xdclass-lw",new User(2,"xdclass-lw","123"));
        userMap.put("tom",new User(3,"tom","123"));
    }

    public User login(String username,String pwd) {
        User user = userMap.get(username);
        if(user == null) return null;
        if(pwd == null) return null;
        if(user.getPwd().equals(pwd)) {
            return  user;
        }
        return null;
    }

    public List<User> list() {
        List<User> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;
    }
}
