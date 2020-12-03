package com.nyb.demo.thread.thread2;

/**
 * @Author:nyb
 * @DESC: 多线程交替打印
 * @Date: Created in 16:19 2020/9/18
 * @Modified By:
 */
public class ThreadExchangePrint {

    static int count = 0;

    public synchronized void run() {
        while (count++ <= 49) {
            try {
                System.out.println(Thread.currentThread().getName() + "输出: " + count);
                if (count % 5 == 0) {
                    notify();
                    wait();
                }
            } catch (Exception e) {}
        }
        notify();
    }

}
