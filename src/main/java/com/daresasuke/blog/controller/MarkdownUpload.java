package com.daresasuke.blog.controller;

import com.daresasuke.blog.entity.Blog;
import com.daresasuke.blog.service.BlogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:DareSasuke
 * @DATA:2021/10/30:22:17
 */
@RestController
public class MarkdownUpload {
    @Resource
    BlogService blogService;
    @PostMapping("/markdownupload")
    public Object getmd(String context,String title){
        Blog blog = new Blog();
        blog.setContext(context);
        blog.setTitle(title);
        blogService.insert(blog);
        return context;
    };
}
