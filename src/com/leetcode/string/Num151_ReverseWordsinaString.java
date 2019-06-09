package com.leetcode.string;

public class Num151_ReverseWordsinaString {


    public static String reverseWords(String s) {
        s.trim(); // 去掉首位的空格
        String[] strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=strings.length-1; i>-1; i--){
            String tmp = strings[i];
            if(tmp.equals(""))
                continue;
            sb.append(tmp);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = "a good   example";

        String ans = reverseWords(s3);
        System.out.println(ans);
    }
}
