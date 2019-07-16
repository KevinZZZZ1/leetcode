package com.leetcode.greedy;


import java.util.Arrays;

// 每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
// 第i个孩子的满足度为g[i]，第j个饼干的大小为s[j]
public class Num455_AssignCookies {

    // 给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。因为最小的孩子最容易得到满足，所以先满足最小的孩子。
    // 所以先对数组g和数组s进行排序，然后遍历数组s，以检查s中有多少能满足g
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0, j=0;
        while (i<g.length && j<s.length){
            if(g[i]<=s[j])
                i++;
            j++;
        }

        return i;
    }

    public static void main(String[] args) {

    }

}
