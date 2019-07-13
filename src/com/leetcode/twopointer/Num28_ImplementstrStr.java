package com.leetcode.twopointer;


// 给定两个字符串haystack,needle，返回haystack中第一次出现needle的索引，如果needle不是haystack的一部分，则返回-1
public class Num28_ImplementstrStr {
    // 思路是：使用双指针i，j，i遍历haystack字符串j遍历needle字符串，
    // 如果haystack.charAt(i) == needle.charAt(j)的话，i，j都向后移动一位
    // 否则j置为0，i要恢复到开始比较位置的下个位置
    public int strStr(String haystack, String needle) {
        int index=-1;

        if(needle.equals(""))
            return 0;

        if(haystack.length()<needle.length() || (haystack.length()==needle.length() && !haystack.equals(needle)))
            return index;

        int i=0, j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){

                i++;
                j++;

            }else{
                i=(i-j)+1;
                j=0;
            }

        }
        if(j==needle.length())
            index = i-j;

        return index;
    }

    public static void main(String[] args) {

    }


}
