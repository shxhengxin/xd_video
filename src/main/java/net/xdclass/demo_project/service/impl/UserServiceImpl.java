package net.xdclass.demo_project.service.impl;

import net.xdclass.demo_project.domain.User;
import net.xdclass.demo_project.mapper.UserMapper;
import net.xdclass.demo_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName : UserServiceImpl  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-19 19:17  //时间
 */
@Service
public class UserServiceImpl implements UserService {
    public static Map<String,User> sessionMap = new HashMap<>();
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(User user) {
        User userLogin = userMapper.login(user.getUsername(), user.getPwd());
        if(userLogin == null) return  null;
        String token = UUID.randomUUID().toString();
        System.out.println(token);
        sessionMap.put(token,userLogin);
        return  token;
    }

    @Override
    public List<User> listUser() {
        List<User> list = userMapper.list();
        return list;
    }
}
