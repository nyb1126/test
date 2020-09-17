package com.nyb.demo.thread;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 11:51 2020/9/17
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) {
        EmployeeThread employeeThread = new EmployeeThread();
        employeeThread.doWork();
    }

}
