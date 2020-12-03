package com.nyb.demo.test;

/**
 * @Author:nyb
 * @DESC: 打印杨辉三角
 * 杨辉三角最本质的特征是，它的两条斜边都是由数字1组成的，而其余的数则是等于它肩上的两个数之和（使用数组实现）
 * @Date: Created in 15:25 2020/9/21
 * @Modified By:
 */
public class YangHuiSanJiao {
    public static void main(String[] args) {
        final int N=10;

        int[] num=new int[N];

        num[0]=1;



        for(int i=1;i!=N;i++){

            for(int j=0;j!=i;j++){

                System.out.print(num[j]+"\t");

            }

            System.out.println();

            num[i]=1;



            for(int j=i-1;j!=0;j--){

                num[j]=num[j]+num[j-1];

            }

        }

    }
}
