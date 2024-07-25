package com.william.springboot.app.administradorclientes.springboot_jpa.springboot_jpa.interceptors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeLoggerInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        Long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        Long endTime = System.currentTimeMillis();
        Long startTime = (long) request.getAttribute("startTime");

        logger.info("El tiempo transcurrido para la ejecución del método "+((HandlerMethod)handler).getMethod().getName()+" fue: "+(endTime-startTime)+"ms");
        
    }

}
