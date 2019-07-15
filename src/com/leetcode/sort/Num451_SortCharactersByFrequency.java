package com.leetcode.sort;

// 给定一个字符串，按照字符出现次数对字符串排序
// Input:
// "tree"

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Output:
// "eert" or "eetr"
public class Num451_SortCharactersByFrequency {
    // 这题的思路和347题差不多，先使用Map统计字符串中字符出现的次数<字符, 字符出现次数>，
    // 再使用一个List类型的数组存储各个出现次数对应的字符值，
    // 最后从尾到头遍历该数组，使用一个StringBuilder来存储每个字符最后返回结果
    public String frequencySort(String s) {
        Map<Character, Integer> cForCount = new HashMap<>();

        for(char c: s.toCharArray()){
            cForCount.put(c, cForCount.getOrDefault(c, 0)+1);
        }

        List<Character>[] buckets = new ArrayList[s.length()+1];
        for(char c: cForCount.keySet()){
            int count = cForCount.get(c);
            if(buckets[count]==null)
                buckets[count] = new ArrayList<>();
            buckets[count].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=buckets.length-1; i>=0; i--){
            if(buckets[i]==null)
                continue;
            for(char c: buckets[i]){
                int count = cForCount.get(c);
                while(count>0){
                    sb.append(c);
                    count--;
                }
            }
        }

        return sb.toString();
    }

}
