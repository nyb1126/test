package com.nyb.demo.thread.thread1.service.serviceImpl;

import com.nyb.demo.thread.thread1.service.AsyncTestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 16:14 2020/9/17
 * @Modified By:
 */
@Service
public class AsyncTestServiceImpl implements AsyncTestService {

    @Override
    //至于后面加上("getExecutor")，是为了指定读取自己写的配置信息例如线程名称那些
    @Async("getExecutor")
    public void AsynTest1() {
        System.out.println("测试1开始");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("测试1结束");
    }

    @Override
    public void AsynTest2() {

    }

    @Override
    public void AsynTest3() {

    }
}
