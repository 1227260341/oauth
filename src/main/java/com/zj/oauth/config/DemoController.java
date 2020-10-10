package com.zj.oauth.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/order")
public class DemoController {

    @RequestMapping(value="/demo")
    public String getDemo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        User user = (User)auth.getPrincipal();
        return "hello world";
    }

    @GetMapping("/test")
    public String getTest() {
        return "hello";
    }
}