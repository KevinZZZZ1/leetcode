package com.leetcode.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 给定一个字符串s，将字符串中的元音字符反转
// 例如：Input: "leetcode"
// Output: "leotcede"
public class Num345_ReverseVowelsofaString {
    // 思路是：使用双指针指向待反转的字符串，一个指针从头向尾遍历，一个指针从尾到头遍历，
    // 当i，j都不是元音字母时，i++，j--；
    // 当i不是元音字母j是元音字母时，i++，j不变（同理可知i是元音字母j不是元音字母的情况）；
    // 当i，j都是元音字母时，交换位置
    private Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        char[] ret = new char[s.length()];
        while (i<=j){
            if(!set.contains(s.charAt(i))){
                ret[i] = s.charAt(i);
                i++;
            }else if(!set.contains(s.charAt(j))){
                ret[j] = s.charAt(j);
                j--;
            }else {
                ret[i] = s.charAt(j);
                ret[j] = s.charAt(i);
                i++;
                j--;
            }

        }
        return  new String(ret);
    }

    public static void main(String[] args) {
        Num345_ReverseVowelsofaString n = new Num345_ReverseVowelsofaString();
        String test = "cehidoab";
        n.reverseVowels(test);
    }


}
