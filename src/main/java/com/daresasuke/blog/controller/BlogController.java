package com.daresasuke.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.daresasuke.blog.entity.Blog;
import com.daresasuke.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Blog)表控制层
 *
 * @author makejava
 * @since 2021-10-31 18:15:06
 */
@CrossOrigin(origins = "**")
@RestController
public class BlogController {
    @Resource
    BlogService blogService;
    @PostMapping("/api/getallblog")
    public  Object getAllBlog(){
        List<Blog> blogs = blogService.queryAll();
        return blogs;
    }
    @PostMapping("/api/uploadblog")
    public Object uploadBlog(@RequestBody JSONObject jsonParam){
        try{
            Blog blog = new Blog();
            blog.setTitle(jsonParam.getString("title"));
            blog.setContext(jsonParam.getString("context"));
            blogService.insert(blog);
            System.out.println(jsonParam);
        }catch (Exception e){
            e.printStackTrace();
            return "添加失败";
        }
        return "添加成功";
    }
    @PostMapping("/api/blogdelete")
    public Object deleteBlog(@RequestBody JSONObject jsonObject){
        blogService.deleteById(jsonObject.getInteger("id"));
        return "{\"status\":1}";
    }
    @PostMapping("/api/updateblog")
    public Object updateBlog(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        try {
            Blog blog = blogService.queryById(jsonObject.getInteger("id"));
            blog.setTitle(jsonObject.getString("title"));
            blog.setContext(jsonObject.getString("context"));
            blogService.update(blog);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}