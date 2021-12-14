package com.daresasuke.blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daresasuke
 * @date 12/14/2021 2:42 PM
 * @TODO
 */
@RestController
public class LoginController {
    @PostMapping("/login")
    public String login(){
        return "login";
    }
}
