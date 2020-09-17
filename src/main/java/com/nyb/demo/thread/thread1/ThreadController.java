package com.nyb.demo.thread.thread1;

import com.nyb.demo.thread.thread1.service.AsyncTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 15:27 2020/9/17
 * @Modified By:
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/v1/")
public class ThreadController {

    @Autowired
    NewThread1 newThread1;
    @Autowired
    AsyncTestService asyncTestService;

    @RequestMapping(value = "testAsync",method = RequestMethod.GET)
    public String testThread1(){
        newThread1.run();
//        System.out.println("success");
        return "789465";
    }
    @RequestMapping(value = "testAsync2",method = RequestMethod.GET)
    public String testThread2(){
        asyncTestService.AsynTest1();
        return "success";
    }

}
