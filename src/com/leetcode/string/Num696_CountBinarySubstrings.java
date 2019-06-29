package com.leetcode.string;
// Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
// and all the 0's and all the 1's in these substrings are grouped consecutively.
//
//Substrings that occur multiple times are counted the number of times they occur.

// Input: "00110011"
//Output: 6
//Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
//
//Notice that some of these substrings repeat and are counted the number of times they occur.
//
//Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.


// 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
public class Num696_CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int preLen=0, curLen=1, count=0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                curLen++;
            }else{
                preLen = curLen;
                curLen = 1;
            }
            if(preLen>=curLen)
                count++;

        }
        return count;
    }

    public static void main(String[] args) {

    }

}
