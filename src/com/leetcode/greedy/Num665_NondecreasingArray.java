package com.leetcode.greedy;

// 给定一个数组nums大小为n，判断最多修改数组中元素一次，使得该数组变成非递减数组，即对于每个i，有array[i] <= array[i + 1]
// Input: [4,2,1]
// Output: False
// Explanation: You can't get a non-decreasing array by modify at most one element.
public class Num665_NondecreasingArray {
    // 思路是，遍历数组nums，如果数组中出现了nums[i-1]>nums[i]的情况,
    // 那么一般都会将nums[i]赋值给nums[i-1]，因为这样能保证之后赋值的情况尽量少（比如出现：nums[i-1]>nums[i+1]>nums[i]的情况时，将nums[i-1]赋值给nums[i]，还是有nums[i]>nums[i+1]）
    // 还有一种情况，nums[i-2]>nums[i]时（即，nums[i-1]>nums[i-2]>nums[i]）此时只能将nums[i-1]赋值给nums[i]
    public boolean checkPossibility(int[] nums) {
        if(nums.length==0)
            return false;
        int cnt=0; // 记录修改数组的次数
        // 从第二个元素开始比较，如果符合非递减的定义的话，直接开始下一次循环
        // 否则有nums[i-1]>nums[i]，然后再判断上面所说的两种情况
        for (int i=1; i<nums.length; i++){
            if(nums[i-1] <= nums[i])
                continue;

            if(i-2>=0 && nums[i-2]>nums[i]){
                nums[i] = nums[i-1];
            }else {
                nums[i-1] = nums[i];
            }
            cnt++;
        }
        return cnt<=1;

    }

    public static void main(String[] args) {

    }
}
