package com.leetcode.string;

import java.util.*;
public class Num290WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        int length = s.length;
        if(length!=pattern.length())
            return false;
        char[] patterns = pattern.toCharArray();
        HashMap<String, Character> map = new HashMap<>(); // str->patterns
        HashMap<Character, String> map1 = new HashMap<>(); // patterns->str
        for(int i=0; i<length; i++){
            Character tmp = map.get(s[i]);
            String tmp1 = map1.get(patterns[i]);
            if(tmp==null && tmp1==null){
                map.put(s[i], patterns[i]);
                map1.put(patterns[i], s[i]);
            }else{
                if(tmp1==null || tmp==null)
                    return false;
                else if(!tmp1.equals(s[i]) || patterns[i] != tmp)
                    return false;

            }

        }

        return true;

    }
    public static void main(String[] args){

        String str = "dog dog dog dog";
        String p = "abba";
        boolean is = wordPattern(p, str);
        if(is)
            System.out.print("True");
        else
            System.out.println("False");
    }
}
