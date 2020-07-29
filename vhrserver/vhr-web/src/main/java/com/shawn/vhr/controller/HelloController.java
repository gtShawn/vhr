package com.shawn.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :shawn
 * @create :2020-07-01 10:36:00
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2()
    {
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3()
    {
        return "/employee/advanced/hello";
    }

}
