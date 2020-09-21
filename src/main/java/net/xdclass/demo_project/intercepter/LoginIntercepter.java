package net.xdclass.demo_project.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.xdclass.demo_project.domain.User;
import net.xdclass.demo_project.service.impl.UserServiceImpl;
import net.xdclass.demo_project.utils.JsonData;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName : LoginIntercepter  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-21 20:28  //时间
 */
public class LoginIntercepter implements HandlerInterceptor {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");


        if(!StringUtils.isEmpty(token)) {
            //判断token是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if(user != null) {
                return true;
            }else {
                renderJson(response,objectMapper.writeValueAsString(JsonData.buildError(-2,"登录失败,token无效")));
                return  false;
            }
        }else {
            renderJson(response,objectMapper.writeValueAsString(JsonData.buildError(-3,"未登录")));
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginIntercepter=========postHandle");
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginIntercepter=========afterCompletion");
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
    private void renderJson(HttpServletResponse response,String json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()) {
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
