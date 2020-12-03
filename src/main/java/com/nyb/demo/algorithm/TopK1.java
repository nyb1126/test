package com.nyb.demo.algorithm;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author:nyb
 * @DESC: 数组中出现次数前k多的字符串
 *  1.思路;先定义一个map<Integer,Integer>，key:数组元素，value；该元素出现的次数。
 * 挨个添加进map中，求出每个元素对应的出现次数。
 * 但有一个问题：map是无序的，如何对其value排序？
 * 将map.entry放入list中，对每一个entry中的value排序。
 * @Date: Created in 10:37 2020/11/10
 * @Modified By:
 */
public class TopK1 {
    private static TopK1 instance;
    private TopK1(){};
    public static synchronized TopK1 getInstance(){
        if (instance==null){
            instance=new TopK1();
        }
        return instance;
    }

    public static Map<String, Integer> get(String[] strings,int k){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (map.containsKey(strings[i])){
                map.put(strings[i],map.get(strings[i])+1);
            }else {
                map.put(strings[i],1);
            }
        }
        Map<String, Integer> sortMap = sortByValue(map);
        return sortMap;
    }

    public static void main(String[] args) {
        String[] strings={"q","a","a","er","as","q","q","rt","rt","er","xx"};
        Map<String, Integer> map = get(strings, 3);
        System.out.println(map);
    }

    static <K,V extends Comparable<? super V>> Map<K,V> sortByValue(Map<K,V> map){
        HashMap<K, V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> stream = map.entrySet().stream();
        stream.sorted(Map.Entry.<K,V>comparingByValue().reversed()).forEach(e->result.put(e.getKey(),e.getValue()));
        return result;
    }


}
