package com.leetcode.arrays;


import java.util.HashMap;
import java.util.Map;

// 给定一个非空非负的整形数组，定义数组的度为数组中元素出现的最高频率，要求找到一个最小的子数组，这个子数组的度和原数组一样。
public class Num697_DegreeofanArray {
    // 思路是：先创建三个Map用来记录数据，第一个Map记录<元素值，元素的出现次数>，第二个Map记录<元素值，元素第一次出现的索引>，第三个Map记录<元素值，元素最后一次出现的索引>
    // 遍历数组，并利用第一个Map得到数组的度，然后再次遍历数组，根据第一个Map判断该元素出现此时是否为数组的度
    // 如果不是，直接跳过；如果是，则根据第三个Map得到元素最后一次出现的索引和第二个Map得到元素第一次出现的索引求出子数组长度
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numCnt = new HashMap<>(); // <元素值，元素的出现次数>
        Map<Integer, Integer> numFirstIndex = new HashMap<>(); // <元素值，元素第一次出现的索引>
        Map<Integer, Integer> numLastIndex = new HashMap<>(); // <元素值，元素最后一次出现的索引>

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            numCnt.put(num, numCnt.getOrDefault(num, 0)+1);
            numLastIndex.put(num, i);
            if(!numFirstIndex.keySet().contains(num))
                numFirstIndex.put(num, i);
        }

        int maxCnt = 0;
        for (int num : nums) {
            maxCnt = Math.max(maxCnt, numCnt.get(num));
        }

        int ret = nums.length;
        for (int i = 0; i <nums.length ; i++) {
            int cnt = numCnt.get(nums[i]);
            if (cnt<maxCnt)
                continue;

            ret = Math.min(ret, numLastIndex.get(nums[i])-numFirstIndex.get(nums[i])+1);
        }

        return ret;

    }

    public static void main(String[] args) {

    }

}
