package com.leetcode.string;

public class NumberMatch {

    // []  ： 字符集合
    //()  ： 分组
    //?   ： 重复 0 ~ 1
    //+   ： 重复 1 ~ n
    //*   ： 重复 0 ~ n
    //.   ： 任意字符
    //\\. ： 转义后的 .
    //\\d ： 数字

    public static boolean match(char[] str){
        if(str==null || str.length==0)
            return false;

        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args){


    }

}
