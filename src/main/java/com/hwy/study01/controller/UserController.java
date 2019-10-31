package com.hwy.study01.controller;

import com.hwy.study01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public String test() {

//        userService.add();
//        userService.list();
//        userService.update();
        return "success";
    }
}
