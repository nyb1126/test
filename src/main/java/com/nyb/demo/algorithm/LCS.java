package com.nyb.demo.algorithm;

import java.net.URLEncoder;

/**
 * 求两个字符串的最长公共子串
 */
public class LCS {

    /**
     * longest common substring
     * 求两个字符串的最长公共子串
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String solution(String str1,String str2){
        StringBuffer result = new StringBuffer();
        int start = 0;
        int end = 1;
        while (end<str1.length()+1){
            if (str2.contains(str1.substring(start,end))){
                if (result.length()<end-start){
                    result.delete(0,result.length());
                    result.append(str1,start,end);
                }
                end++;
            }else {
                start++;
            }
        }
        if (result.length()==0){
            return "-1";
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        String str1="qweertasd1234";
        String str2="ar234weertdsf";
        String solution = solution(str1, str2);
//        System.out.println(solution);
        String qw="https://ybpacas.console.tg.unicom.local/copnet/intelligence/requestFromTianGong?callback=http%3A%2F%2F10.236.10.92%3A8888%2Ft668681789468%2Ftcc%2Fapi%2Fv1%2Fexternal-cas%2Flogin#/bigdata/instances/21";
        String encode = URLEncoder.encode(qw, "UTF-8");
        System.out.println(encode);
    }

}
