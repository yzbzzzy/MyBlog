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
 * markdown editor
 * @Author:DareSasuke
 * @DATA:2021/10/30:21:51
 */
@Controller
public class Editor {
    @Resource
    BlogService blogService;
    @GetMapping("/editor")
    public String editor(){
        return "editor";
    }

    @GetMapping("/changeEditor")
    public String changeEditor(@PathParam("id") int id,Model model){
        Blog blog = blogService.queryById(id);
        model.addAttribute("blog",blog.getContext());
        model.addAttribute("title",blog.getTitle());
        model.addAttribute("id",id);
        return "/changeEditor";
    }
    @PostMapping("/edited")
    public String edited(@PathParam("title")String title
            ,@PathParam("context") String context
            ,@PathParam("id")int id){
        Blog blog = blogService.queryById(id);
        blog.setContext(context);
        blog.setTitle(title);
        blogService.update(blog);
        return "index";

    }
}
