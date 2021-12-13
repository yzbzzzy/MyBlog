package com.daresasuke.blog.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@RestController
public class UploadController {
    @PostMapping("/uploadImage")
    public Object uploadImage(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file) {
        System.out.println("上传");
        System.out.println("文件"+file.toString());
        if (file.isEmpty())
            return 0;
        String filename =String.valueOf(System.currentTimeMillis());
        String path="H:\\java\\spring-blog\\target\\classes\\upload\\images\\";
        File dest = new File(path + filename+".jpg");
        try {
            file.transferTo(dest);
            HashMap res = new HashMap();
            res.put("url","http://localhost:8080/upload/images/"+filename+".jpg");
            res.put("success", 1);
            res.put("message", "upload success!");
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
