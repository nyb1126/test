package com.nyb.demo.algorithm;

/**
 * @Author:nyb
 * @DESC: 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 * @Date: Created in 9:46 2020/12/2
 * @Modified By:
 */
public class BinarySearch {

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upperBound(int n,int v,int[] a){
        return recursionBinarySearch(a,v,0,n-1);
    }

    /**
     * 递归实现
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){
        if (arr==null||key<arr[low]||key>arr[high]||low>high){
            return arr.length;
        }
        int middle=(low+high)/2;
        if (key>arr[middle]){
            return recursionBinarySearch(arr,key,middle+1,high);
        }
        if (key<arr[middle]){
            return recursionBinarySearch(arr,key,low,middle-1);
        }
        return middle;
    }

    public static void main(String[] args) {
//        int[] arr = {1,3,5,7,9,11};
        int[] arr = {3,3,4,4,4,5,6,6,6,7,8,8,12,13,15,16,21,21,22,24,24,27,28,32,34,35,35,36,36,39,40,41,41,42,44,44,45,45,47,47,47,47,48,48,50,51,51,53,53,53,54,54,54,56,56,57,59,60,60,60,60,61,62,63,65,65,65,65,67,67,68,70,71,71,74,75,75,79,81,84,84,86,86,87,90,90,90,90,91,92,93,94,94,94,95,97,97,98,98,99};
        int key = 97;
        System.out.println("数组长度："+arr.length);
        System.out.println("查找值："+key);
        int i = upperBound(arr.length, key, arr);
        System.out.println("位置："+i);
    }

}
