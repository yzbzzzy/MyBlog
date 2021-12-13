package com.daresasuke.blog.controller;

import com.daresasuke.blog.entity.Blog;
import com.daresasuke.blog.service.BlogService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:DareSasuke
 * @DATA:2021/10/31:9:19
 */
@Controller
public class Index {
    @Resource
    private BlogService blogService;
    @GetMapping("/")
    public String index(Model model){
        List<Blog> blogs = blogService.queryAll();
        Collections.reverse(blogs);
        model.addAttribute("blogs",blogs);
        return "index";
    }
}
