package com.hwy.study01.controller;

import com.hwy.study01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    UserService userService;

    @RequestMapping("/test1")
    public String test() {
        return "success";
    }
}
