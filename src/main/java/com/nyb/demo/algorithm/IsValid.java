package com.nyb.demo.algorithm;

import java.util.Stack;

/**
 * @Author:nyb
 * @DESC: 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * @Date: Created in 11:48 2020/11/11
 * @Modified By:
 */
public class IsValid {

    public static boolean solution(String s){
        if(s.length()<1){
            return false;
        }
        if (s.length()%2==1){
            return false;
        }

        if(!isV(s.substring(0,1),(s.substring(1,2)))){
            return false;
        }
        for(int i=2,k=1;i<s.length()-1;k++,i=2*k){
            String left=s.substring(i,i+1);
            String right=s.substring(i+1,i+2);
            if (!isV(left,right)){
                return isV(left,right);
            }
        }
        return true;
    }

    public static boolean isV(String left,String right){
        if(!((left.equals("[")&&right.equals("]"))
                ||(left.equals("{")&&right.equals("}"))
                ||(left.equals("(")&&right.equals(")")))){
            return false;
        }
        return true;
    }

    /**
     *示例 1:
     *
     * 输入: "()"
     * 输出: true
     *
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     * @param s
     * @return
     */
    public static boolean isV2(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c=='{'){
                stack.push('}');
            }else if (c=='['){
                stack.push(']');
            }else if (c=='('){
                stack.push(')');
            }else if (stack.empty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String string = "{}()[]{{}}";
        boolean solution = isV2(string);
        System.out.println(solution);
    }
}
