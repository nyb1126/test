package com.nyb.demo.thread;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 11:35 2020/9/17
 * @Modified By:
 */
public class OutsourceThread implements Runnable{

    CallBack callBack;
    public static final String name = "外包";

    public OutsourceThread(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void run() {
        try {
            System.out.println(name+":我来解决问题");
            Thread.sleep(6000);
            System.out.println(name+"搞定，给他结果");
            callBack.call("完事");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
