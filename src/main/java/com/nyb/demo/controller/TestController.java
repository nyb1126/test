package com.nyb.demo.controller;

import com.nyb.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 14:55 2020/5/25
 * @Modified By:
 */
@Controller
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World...";
    }

    @RequestMapping("/test")
    public Object test(){
        return testService.test();
    }

}
