package com.myth.hrmanage.controller;

import com.github.pagehelper.PageInfo;
import com.myth.hrmanage.entity.Document;
import com.myth.hrmanage.entity.User;
import com.myth.hrmanage.service.DocumentService;
import com.myth.hrmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;
import java.util.List;

/**
 * (Document)表控制层
 *
 * @author makejava
 * @since 2022-06-22 14:26:17
 */
@RestController
@RequestMapping("document")
public class DocumentController {
    /**
     * 服务对象
     */
    @Resource
    private DocumentService documentService;

    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public ModelAndView addForm(Integer id,HttpSession session){
        ModelAndView mv=new ModelAndView();
        if(id!=null){
            User user = (User) session.getAttribute("user");
            Document document=documentService.queryById(id);
            if(!document.getUserId().equals(user.getId())){
                mv.setViewName("redirect:/document/list?pageNum=1&pageSize=6");
            }else{
                mv.addObject("document",document);
            }
        }
        mv.setViewName("page/document/add");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute Document document,HttpSession session) throws IOException {
        ModelAndView mv=new ModelAndView("redirect:/document/list?pageNum=1&pageSize=6");
        if(document.getFile().getSize()==0){
            return mv;
        }
        if(document.getId()!=null){
            document.setFilename(document.getFile().getOriginalFilename());
            documentService.update(document);
            documentService.saveFile(document);
        }else{
            User user = (User) session.getAttribute("user");
            document.setUserId(user.getId());
            documentService.insert(document);
        }

        return mv;
    }

    @GetMapping("/list")
    public ModelAndView list(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize,
                             String content){
        ModelAndView mv=new ModelAndView("page/document/list");
        System.out.println("get_document_list");
        PageInfo pageInfo=documentService.selectAll(pageNum,pageSize,content);
        pageInfo.getList().stream().forEach((document)->{
            System.out.println(document.toString());
            ((Document)document).setUserName(userService.queryById(((Document) document).getUserId()).getUsername());
        });
        mv.addObject("documents",pageInfo.getList());
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @DeleteMapping("/{id}")
    public Boolean list(@PathVariable("id")Integer id){
        boolean b = documentService.deleteById(id);
        return b;
    }

}

