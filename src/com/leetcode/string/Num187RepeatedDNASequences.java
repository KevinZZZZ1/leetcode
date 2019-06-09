package com.leetcode.string;
import java.util.*;
public class Num187RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if(s==null || s.length()<10)
            return list;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<String>();
        for(int i=0; i<s.length(); i++){
            int j = i+10;
            String tmp = null;
            if(j<s.length()+1){
                tmp = s.substring(i, j);
            }else{
                break;
            }

            Integer cnt = map.get(tmp);
            if(cnt==null){
                map.put(tmp, 1);
            }else{
                map.put(tmp, ++cnt);
            }
            if(cnt!=null && cnt>=2){
                set.add(tmp);
            }
        }
        for(String k: set)
            list.add(k);
        return list;
    }


    public static void main(String[] args){

//        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s = "AAAAAAAAAAAA";
        findRepeatedDnaSequences(s);

    }


}
