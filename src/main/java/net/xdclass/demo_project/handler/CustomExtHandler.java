package net.xdclass.demo_project.handler;

import net.xdclass.demo_project.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : CustomExtHandler  //类名
 * @Description : 全局异常处理器  //描述
 * @Author : shenhengxin  //作者
 * @Date: 2020-09-20 15:50  //时间
 */
//@RestControllerAdvice
@ControllerAdvice
public class CustomExtHandler {
    /*@ExceptionHandler(value = Exception.class)
    JsonData handlerException(Exception e, HttpServletRequest request) {
       return JsonData.buildError(-2,e.getMessage());
    }*/


    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }












}
