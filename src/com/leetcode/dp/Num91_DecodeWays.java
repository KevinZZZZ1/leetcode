package com.leetcode.dp;

// 26个字母对应整数1到26，
//  'A' -> 1
//  'B' -> 2
//  ...
//  'Z' -> 26
// 给定一个只包含数字的字符串，判断该字符串最多有多少种字母表示方法


//Input: "226"
//        Output: 3
//        Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

public class Num91_DecodeWays {
    // dp[i]表示在字符串i位置对应的最多字母表示方法
    public static int numDecodings(String s) {
        if (s==null || s.length()==0)
            return 0;

        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=(s.charAt(0)=='0'? 0:1);

        for (int i = 2; i <= s.length(); i++) {
            // one表示每次取一个字符，two表示每次取两个字符
            int one = Integer.valueOf(s.substring(i-1, i));
            int two = Integer.valueOf(s.substring(i-2, i));
            // 如果one和two都满足条件的话，dp[i] = dp[i-1]+dp[i-2]
            dp[i] = (one==0? 0:dp[i-1]);
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            dp[i] += ((two>26&&two>=10)? 0:dp[i-2]);
        }
        return dp[s.length()];
    }

//    public static int numDecodings(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int n = s.length();
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = s.charAt(0) == '0' ? 0 : 1;
//        for (int i = 2; i <= n; i++) {
//            int one = Integer.valueOf(s.substring(i - 1, i));
//            if (one != 0) {
//                dp[i] += dp[i - 1];
//            }
//            if (s.charAt(i - 2) == '0') {
//                continue;
//            }
//            int two = Integer.valueOf(s.substring(i - 2, i));
//            if (two <= 26) {
//                dp[i] += dp[i - 2];
//            }
//        }
//        return dp[n];
//    }


    public static void main(String[] args) {
        String test = "00";
        numDecodings(test);

    }

}
