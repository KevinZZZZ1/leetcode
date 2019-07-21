package com.leetcode.greedy;

// 给定一个表示人身高的数组，一个人用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个人的身高比他高或者和他一样高，
// 重新构建一个数组，使得数组中某个(h, k)满足该元素之前只有k个元素的h大于等于该元素的h

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
// Output:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 上面的输出的意思，比如[5,2]的意思是，在高度为5的元素位置之前，有两个元素高度大于等于5；
// 所以题目的意思就是，把输入中各个元素重新安排位置，使得任意一个元素都满足上面所述的条件；
public class Num406_QueueReconstructionbyHeight {
    // 思路是，先对数组进行排序，排序规则是，先按照升高递减序排序，如果身高相同的话，按照k的大小递增排序
    // 然后遍历数组，按照k的大小将p插入到ArrayList中，然后转化为数组返回；
    public int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length==0 || people[0].length==0)
            return new int[0][0];

        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        List<int[]> ret = new ArrayList<>();
        for(int[] p: people){
            ret.add(p[1], p);
        }

        return ret.toArray(new int[ret.size()][]);
    }

    public static void main(String[] args) {
        int[][] test = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Num406_QueueReconstructionbyHeight n = new Num406_QueueReconstructionbyHeight();
        n.reconstructQueue(test);
    }

}
