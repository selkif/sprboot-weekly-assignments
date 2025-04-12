package com.example.sprbootw4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/create")
    public String create() {
        return "post/create";
    }

    @RequestMapping("/list")
    public String list() {
        return "post/list";
    }

    @RequestMapping("/detail")
    public String detail() {
        return "post/detail";
    }
}
