package com.daresasuke.blog.controller;

import com.daresasuke.blog.entity.Blog;
import com.daresasuke.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * show markdown
 * @Author:DareSasuke
 * @DATA:2021/10/30:22:38
 */
@Controller
public class Preview {
    @Resource
    BlogService blogService;
    @GetMapping("/preview/{id}")
    public String preview(String markdown
            ,Model model
            ,@PathVariable int id){
        Blog blog = blogService.queryById(id);
        model.addAttribute("blog",blog);
        return "preview";
    };
}
