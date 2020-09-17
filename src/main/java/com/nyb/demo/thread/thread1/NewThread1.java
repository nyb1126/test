package com.nyb.demo.thread.thread1;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author:nyb
 * @DESC: 异步线程调用
 * @Date: Created in 15:24 2020/9/17
 * @Modified By:
 */
@Component
public class NewThread1 {

    @Async
    public void run(){
        try {
            System.out.println("线程启动开始");
            Thread.sleep(8000);
            System.out.println("线程结束");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
