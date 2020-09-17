package com.nyb.demo.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 11:39 2020/9/17
 * @Modified By:
 */
public class EmployeeThread implements CallBack {

    public static ExecutorService service =  Executors.newFixedThreadPool(1);
    public static final String name = "雇员";
    public static boolean flag = true;

    public EmployeeThread() {
    }

    public void doWork(){
        System.out.println("开始写代码");
        System.out.println("交给你了，外包");
        OutsourceThread thread = new OutsourceThread(this);
        Thread thread1 = new Thread(thread);
        service.execute(thread1);
        service.shutdown();
        play();
    }

    public void play(){
        while (flag){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("打游戏");
        }
    }

    @Override
    public void call(String result) {
        System.out.println(name+result);
        System.out.println(name+"完事了，给老板");
        flag=false;
    }
}
