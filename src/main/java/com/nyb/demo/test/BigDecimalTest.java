package com.nyb.demo.test;

import java.math.BigDecimal;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 14:26 2020/9/22
 * @Modified By:
 */
public class BigDecimalTest {

    private static BigDecimal CPUFEE=new BigDecimal("0.5");
    private static BigDecimal MEMORYFEE=new BigDecimal("0.5");
    private static BigDecimal STORAGEFEE=new BigDecimal("0.01");
    private static BigDecimal FTPSTORAGEFEE=new BigDecimal("0.01");

    public static boolean check(String cpu,String memory,String storage,String nodeNum,String ftpStorage,String price){
        BigDecimal cost = new BigDecimal("0.00");
        //计算cpu费用
        if (null!=cpu){
            cost=cost.add((new BigDecimal(cpu).multiply(CPUFEE)));
        }
        //计算内存费用
        if (null!=memory){
            BigDecimal multiply = new BigDecimal(memory).multiply(MEMORYFEE);
            cost=cost.add(multiply);
        }
        //计算总节点费用
        if (null!=nodeNum){
            cost=cost.multiply(new BigDecimal(nodeNum));
        }
        //计算存储费用，不算节点数
        if (null!=storage){
            BigDecimal multiply = new BigDecimal(storage).multiply(STORAGEFEE);
            cost=cost.add(multiply);
        }
        if (null!=ftpStorage){
            BigDecimal multiply = new BigDecimal(ftpStorage).multiply(FTPSTORAGEFEE);
            cost=cost.add(multiply);
        }
        if (cost.compareTo(new BigDecimal(price))!=0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean check = check("2", "2", "4", null, "1", "2.05");
        System.out.println(check);

//        BigDecimal bigDecimal = new BigDecimal("4");
//        BigDecimal add = bigDecimal.multiply(new BigDecimal("0.01"));
//        System.out.println(add);

//        System.out.println(0.01+0.05);
//        System.out.println(1.0-0.42);
//        System.out.println(4.015*100);
//        System.out.println(123.3/100);
//        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.5")));
//        System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.5")));
//        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.5")));
//        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.5")));

    }


}
