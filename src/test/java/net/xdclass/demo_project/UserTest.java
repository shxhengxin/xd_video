package net.xdclass.demo_project;

import junit.framework.TestCase;
import net.xdclass.demo_project.controller.UserController;
import net.xdclass.demo_project.domain.User;
import net.xdclass.demo_project.utils.JsonData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @ClassName : UserTest  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-20 14:39  //时间
 */
@SpringBootTest(classes = {DemoProjectApplication.class})
public class UserTest {
    @Autowired
    private UserController userController;
    @Test
    public void loginTest() {
        User user = new User();
        user.setUsername("jack");
        user.setPwd("123");
        JsonData jsonData = userController.login(user);
        System.out.println(jsonData.toString());
        TestCase.assertEquals(0,jsonData.getCode());
    }
}
