package com.leetcode.math;

// 给定一个字符串数组words，找出length(words[i])*length(words[j])的最大值，而且这两个字符串不能含有相同字符
public class Num318_MaximumProductofWordLengths {
    // 本题主要问题是判断两个字符串是否含相同字符，
    // 思路是：由于字符串只含有小写字符，总共 26 位，因此可以用一个 32 位的整数来存储每个字符是否出现过。
    // 然后再遍历字符串数组，在两个字符串没有含相同字符的情况下，得到其积的最大值

    public int maxProduct(String[] words) {
        int[] cnts = new int[words.length];

        for (int i=0; i<words.length; i++){
            for(char c: words[i].toCharArray()){
                cnts[i] |= 1<<(c-'a'); // 记录每个字符串中出现哪些字符
            }
        }

        int ret = 0;
        for (int i=0; i<words.length; i++){
            for (int j=i+1; j<words.length; j++){
                if((cnts[i]&cnts[j]) == 0){ // 两个字符串中没有字符相等
                    ret = Math.max(ret, words[i].length()*words[j].length());
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
