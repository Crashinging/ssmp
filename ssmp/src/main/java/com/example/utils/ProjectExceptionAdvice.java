package com.example.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: chenJY
 * @Description: springmvc的异常处理器
 * @Date: 2022-08-10 8:14
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
//        ex.printStackTrace();
        return new R("服务器故障，请稍后再试！");
    }
}
