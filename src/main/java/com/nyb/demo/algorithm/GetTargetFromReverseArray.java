package com.nyb.demo.algorithm;

/**
 * @Author:nyb
 * @DESC: 给出一个转动过的有序数组，你事先不知道该数组转动了多少
 * (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
 * 在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
 * 假设数组中不存在重复项。
 * @Date: Created in 11:07 2020/12/2
 * @Modified By:
 */
public class GetTargetFromReverseArray {

    public static void main(String[] args) {
        int[] arr={10 ,11, 12, 13, 14, 15 ,1, 2, 3};
        int target=10;
        int search = search(arr, target);
        System.out.println(search);
    }

    /**
     * @param arr  int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] arr,int target){
        if (arr.length<=0){
            return -1;
        }
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int middle=low+(high-low)/2;
            if (arr[middle]==target){
                return middle;
            }
            if (arr[middle]<arr[high]){
                if (arr[middle]<target&&target<=arr[high]){
                    low=middle+1;
                }else {
                    high=middle-1;
                }
            }else {
                if (arr[low]<target&&target<=arr[middle]){
                    high=middle-1;
                }else{
                    low=middle+1;
                }
            }
        }
        return -1;
    }

}
