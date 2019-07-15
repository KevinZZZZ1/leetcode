package com.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 给定一个非空的整形数组，找出其中出现频率最多的 k 个元素
public class Num347_TopKFrequentElements {
    // 思路是，首先使用一个Map记录键值对<元素值，出现次数>，然后使用一个List类型数组list[i]来存储出现次数为i的所有元素
    // 最后从尾到首遍历这个数组，将出现频率最多的k个元素找到
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> nForCount = new HashMap<>();

        for(int n: nums){
            nForCount.put(n, nForCount.getOrDefault(n, 0)+1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int n: nForCount.keySet()){
            int count = nForCount.get(n);
            if(buckets[count]==null)
                buckets[count] = new ArrayList<>();
            buckets[count].add(n);
        }

        List<Integer> ret = new ArrayList<>();
        for(int i=buckets.length-1; i>=0 && ret.size()<k ; i--){
            if(buckets[i]==null)
                continue;
            // k-topK.size()表示剩余容量
            if(buckets[i].size()<(k-ret.size()))
                ret.addAll(buckets[i]);
            else
                ret.addAll(buckets[i].subList(0, (k-ret.size())));

        }

        return ret;
    }


}
