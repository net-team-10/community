package com.zhouxiaosong.wx_class_project.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @RequestMapping("/index/{name}")
//    public String index(@PathVariable String name){
//        if (name == null){
//            name = "default_body";
//        }
//        return "hello! " + name;
//
//    }

    @RequestMapping("/")
    public String index(){
        return "hello! ";
    }


}
