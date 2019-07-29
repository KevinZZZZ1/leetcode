package com.leetcode.binarysearch;
// 给定一个已排序的字符数组letters，给定一个字符target，从letters中找到所有大于target的字符中最小的那个字符，如果找不到就返回第 1 个字符
// Input:
// letters = ["c", "f", "j"]
// target = "a"
// Output: "c"
public class Num744_FindSmallestLetterGreaterThanTarget {
    // 使用二分查找，对于中间值mid对应数组中的midChar来说：
        // 如果midChar小于等于target：l=mid+1;
        // 如果midChar大于target：h=mid-1;
    // 当最后while循环结束以后，如果l大于等于letters.length的话，说明没有找到，返回letters中第一个字符
    // 否则返回letters[l]
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0, h=letters.length-1;
        while (l<=h){
            int mid = l+(h-l)/2;
            int midChar = letters[mid];
            if(midChar<=target)
                l = mid+1;
            else
                h = mid-1;
        }

        // 出现找不到的情况一定是letters中所有字符都小于target，此时l>letters.length
        return l<letters.length ? letters[l]: letters[0];

    }

    public static void main(String[] args) {

    }

}
