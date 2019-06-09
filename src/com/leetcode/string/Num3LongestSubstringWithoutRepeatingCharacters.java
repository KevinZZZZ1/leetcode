package com.leetcode.string;
import java.util.*;
public class Num3LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int begin=0;
        int max_length=1;
        for(int i=0; i<cs.length; i++){

            if(!map.containsKey(cs[i])){
                map.put(cs[i], i);
            }else{
                if((i-begin)>=max_length){
                    max_length = i-begin;
                    begin = map.get(cs[i])+1;
                    map.clear();
                    map.put(cs[begin], begin);
                    i=begin;
                }
            }
            max_length = (max_length>map.size())?max_length:map.size();
        }
        return max_length;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        int a = lengthOfLongestSubstring(s);
        System.out.println(a);
    }

}
