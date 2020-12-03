package com.nyb.demo.algorithm;

import java.util.Arrays;

/**
 * @Author:nyb
 * @DESC: 快速排序
 * 一般的做法是使用左端、右端和中心位置上的三个元素的中值作为基元。 分割策略： 在分割阶段吧所有小元素移到数组的左边，
 * 大元素移到数组右边。，大小是相对于枢纽元素而言的。 当i在j的左边时，将i右移，移过哪些小于枢纽元的元素，并将j左移，
 * 已过那些大于枢纽元的元素，当i和j停止时，i指向一个大元素，而j指向一个小元素，如果i在j的左边，那么将这两个元素交换，
 * 其效果是把一个大元素推向右边，而把小元素推向左边。
 *
 * @Date: Created in 15:41 2020/11/11
 * @Modified By:
 */
public class QuickSort {

    /**
     * 快速排序
     * 两个方向，左边的i下标一直往右走，当a[i] <= a[center_index]，
     * 其中center_index是中枢元素的数组下标，而右边的j下标一直往左走，当a[j] > a[center_index]
     * 如果i和j都走不动了，i <= j, 交换a[i]和a[j],重复上面的过程，直到i>j
     * 交换a[j]和a[center_index]，完成一趟快速排序
     * 枢轴采用三数中值分割法可以优化
     */
    public static void quickSort(int[] a,int low,int high){
        if (low<high){
            //将数组一分为二
            int partition = partition(a, low, high);
            //将第一部分递归排序
            quickSort(a,low,partition);
            //将第二部分递归排序
            quickSort(a,partition+1,high);
        }
    }

    //partition实现三数中值分割法
    public static int partition(int[] a,int low,int high){
        //选取第一个元素为枢轴记录
        int pivot=a[low];
        while (low<high){
            //将比枢轴小的数据移动到左端
            while (low<high&&a[high]>=pivot){
                high--;
            }
            a[low]=a[high];
            //将比枢轴大的数据移动到右端
            while (low<high&&a[low]<=pivot){
                low++;
            }
            a[high]=a[low];
        }
        //给枢轴所在位置赋值
        a[low]=pivot;
        //返回枢轴所在位置
        return low;
    }

    public static int findKth(int[] a,int n,int k){
        quickSort(a,0,n-1);
        return a[n-k+1-1];
    }

    public static void main(String[] args) {
//        int[] a={4,5,6,8,1,3,9,15,12,7};
//        int kth = findKth(a, 10, 6);
        int[] a={1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int kth=findKth(a,49,24);
        System.out.println(kth);
        System.out.println(Arrays.toString(a));
    }

}
