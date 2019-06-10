package com.leetcode.math;

// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
// For example:
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB

// 这题本质上还是进行进制转换，将十进制转换为26进制
public class Num168_ExcelSheetColumnTitle {

    // 有一点和之前的题不同的是，该题是从1开始的。
    public static String convertToTitle(int n) {
        if(n==0)
            return "";
        StringBuffer sb = new StringBuffer();
        // 由于是从1开始的，所以在求模和除法都要减1
        while (n>0){
            sb.append((char) ('A'+(n-1)%26));
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int test = 28;
        String ans = convertToTitle(test);
        System.out.println(ans);
    }

}
