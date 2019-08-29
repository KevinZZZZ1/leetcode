package com.leetcode.dp;

import java.util.List;

// 给定一个非空字符串s，一个包含非空字符串字典wordDict，判断s是否能被wordDict中的字符串分割
// Input: s = "leetcode", wordDict = ["leet", "code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

public class Num139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i][j]表示wordDict中前i个字符串能否表示出字符串s的前j个字符
        // 那么dp[i][j] = dp[i-1][j] || dp[i-1][j-len(wordDict[i])]
        // 可以写成dp[j] = dp[j] || dp[j-len(wordDict[i])]
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {   // 对物品的迭代应该放在最里层
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {

    }


}
