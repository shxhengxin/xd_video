package net.xdclass.demo_project.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demo_project.domain.User;
import net.xdclass.demo_project.service.impl.UserServiceImpl;
import net.xdclass.demo_project.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName : LoginFilter  //类名
 * @Description :   //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-20 17:11  //时间
 */
//@WebFilter(urlPatterns = {"/api/v1/pri/*"},filterName = "loginFilter")
public class LoginFilter implements Filter {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=======init LoginFilter=========");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("=======doFilter LoginFilter======");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String token = req.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            token = req.getParameter("token");
        }

        if(!StringUtils.isEmpty(token)) {
            //判断token是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if(user != null) {
                chain.doFilter(request,response);
            }else {
                renderJson(res,objectMapper.writeValueAsString(JsonData.buildError(-2,"登录失败,token无效")));
            }
        }else {
            renderJson(res,objectMapper.writeValueAsString(JsonData.buildError(-3,"未登录")));
        }


        
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

    @Override
    public void destroy() {
        System.out.println("=======destroy LoginFilter=========");
    }
}
