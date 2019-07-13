package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定一个数组nums和一个整数target，数组中是否存在a,b,c,d四个数，使得a+b+c+d==target，找出所有的不同的[a,b,c,d]
public class Num18_4Sum {

    // 思路是：和15题思路差不多，可以用p1,p2先固定两个变量，在使用双指针法变量数组，得到相应结果，要注意的就是在处理相同元素的情况
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length<4 || (nums.length==4 && nums[0]+nums[1]+nums[2]+nums[3]!=target))
            return ans;

        if(nums.length==4 && nums[0]+nums[1]+nums[2]+nums[3]==target){
            ans.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return ans;
        }

        Arrays.sort(nums);

        for(int p1=0; p1<nums.length; p1++){
            if(p1>=1 && nums[p1]==nums[p1-1])
                continue;

            int a = nums[p1];
            for (int p2=p1+1; p2<nums.length; p2++){
                if(p2>p1+1 && nums[p2]==nums[p2-1])
                    continue;
                int b = nums[p2];
                int p3 = p2+1, p4 = nums.length-1;
                while (p3<p4){
                    int c = nums[p3], d = nums[p4];
                    if(a+b+c+d<target){
                        p3++;
                    }else if(a+b+c+d>target){
                        p4--;
                    }else{
                        ans.add(Arrays.asList(a,b,c,d));
                        while (p3<p4 && nums[p3]==nums[p3+1])
                            p3++;
                        while (p3<p4 && nums[p4]==nums[p4-1])
                            p4--;

                        p3++;
                        p4--;
                    }
                }

            }

        }

        return ans;
    }

    public static void main(String[] args) {

    }


}
