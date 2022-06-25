package com.myth.hrmanage.interceptor;

import com.myth.hrmanage.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println("拦截器标识");
        if(user==null){
            System.out.println(request.getRequestURL());
            response.sendRedirect("/loginForm.html");
            return false;
        }
        return true;
    }

}
