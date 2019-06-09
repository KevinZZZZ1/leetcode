package com.leetcode.string;


// 字符序列S,要求输出循环左移n位后的结果，比如S=”abcXYZdef”，要求输出循环左移3位后的结果，即“XYZdefabc”。
public class LeftRotateString {

    public String leftRotateString(String str, int n){
        // 先将abcXYZdef中abc和XYZdef分别进行反转，得cba和fedZYX，即cbafedZYX，再对该字符串进行一次反转，得XYZdefabc

        if(str==null || str.length()==0)
            return "";
        if(n<=0)
            return str;
        char[] cs = str.toCharArray();
        reverse(cs, 0, n-1);
        reverse(cs, n, cs.length-1);
        reverse(cs, 0, cs.length-1);

        return new String(cs);
    }

    private void reverse(char[] chars, int i, int j){
        while(i<j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }

    }

    public static void main(String[] args){



    }
}
