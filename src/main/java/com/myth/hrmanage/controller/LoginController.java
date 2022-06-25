package com.myth.hrmanage.controller;

import com.myth.hrmanage.dto.LoginTo;
import com.myth.hrmanage.entity.User;
import com.myth.hrmanage.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ModelAndView login(LoginTo loginTo, RedirectAttributes redirectAttributes, ModelAndView mv, HttpSession session){
        //验证用户名和密码
        String loginName= loginTo.getLoginname();
        String password= loginTo.getPassword();
        User user=userService.login(loginName, password);
        if(user!=null){
            session.setAttribute("user",user);
            mv.setViewName("redirect:/index");
            return mv;
        }
        redirectAttributes.addFlashAttribute("message","用户名或密码错误!");
//        mv.addObject("message","用户名或密码错误!");
        mv.setViewName("redirect:/loginForm");
        return mv;
    }

    @GetMapping("/loginForm")
    public ModelAndView loginForm(ModelAndView mv){
        mv.setViewName("/loginForm.html");
        return mv;
    }
}
