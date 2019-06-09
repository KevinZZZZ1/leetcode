package com.leetcode.string;

import java.util.*;

public class Num49GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        // anagrams分组：若两个字符串出现的字符个数相同，则他们是一组

        List<List<String>> ans = new ArrayList<>();
        if(strs.length==0)
            return ans;

        Map<String, List<String>> map = new HashMap<>(); // key是按字母序排好的字符串，value是该字符串对应的List；
        for(int i=0; i<strs.length; i++){
            String sorted = sortAlf(strs[i]);
            List<String> list = map.get(sorted);
            if(list==null){
                list = new LinkedList<>();
                list.add(strs[i]);
                ans.add(list);
                map.put(sorted, list);
            }else{
                list.add(strs[i]);
            }
        }

        return ans;
    }

    private static String sortAlf(String s){
        StringBuffer sb = new StringBuffer();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        sb.append(cs);

        return sb.toString();
    }


    public static void main(String[] args){
        String s = "tea";
        sortAlf(s);
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);

    }

}
