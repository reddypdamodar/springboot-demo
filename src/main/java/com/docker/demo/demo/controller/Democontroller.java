package com.docker.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Democontroller {
    @GetMapping("/dockerdemo")
    public String methodname (){
        return "this is docker demo v2";
    }
}
