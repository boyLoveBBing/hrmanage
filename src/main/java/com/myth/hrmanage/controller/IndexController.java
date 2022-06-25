package com.myth.hrmanage.controller;

import com.myth.hrmanage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DocumentService documentService;

    @Autowired
    DeptService deptService;

    @Autowired
    NoticeService noticeService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/welcome")
    public ModelAndView welCome(){
        ModelAndView mv=new ModelAndView("page/welcome");
        Integer userNum=userService.count();
        Integer deptNum=deptService.count();
        Integer employeeNum=employeeService.count();
        Integer noticeNum=noticeService.count();
        Integer documentNum=documentService.count();

        mv.addObject("userNum",userNum);
        mv.addObject("deptNum",deptNum);
        mv.addObject("employeeNum",employeeNum);
        mv.addObject("noticeNum",noticeNum);
        mv.addObject("documentNum",documentNum);

//        mv.setViewName("welcome");
        return mv;
    }
}
