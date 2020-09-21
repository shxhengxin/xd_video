package net.xdclass.demo_project.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName : ApplicationListener  //类名
 * @Description : 应用上下文监听器  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-21 20:10  //时间
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized===========");
        System.out.println("11111111111");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed===========");
    }
}
