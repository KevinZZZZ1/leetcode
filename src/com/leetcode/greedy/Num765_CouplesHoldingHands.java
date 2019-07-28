package com.leetcode.greedy;
//给定一个数组row长度为N，其中包含所有[0,N-1]的数字，设（n,n+1）为一对，其中n为偶数
// 那么最少需要移动数组row中的元素多少次才能使得row中所有元素成对

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Input: row = [0, 2, 1, 3]
// Output: 1
// Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
public class Num765_CouplesHoldingHands {
    // 这个暂时还没理解（能力有限=_=）
//    public int minSwapsCouples(int[] row) {
//        int res = 0, N = row.length;
//
//        int[] ptn = new int[N];
//        int[] pos = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            ptn[i] = (i % 2 == 0 ? i + 1 : i - 1);
//            pos[row[i]] = i;
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
//                swap(row, i, j);
//                swap(pos, row[i], row[j]);
//                res++;
//            }
//        }
//
//        return res;
//    }

    // Union-Find方法：思路是，由于数组的长度为N又被两两分组，所以一共有N/2个组，而且如果两个元素row[i](i是偶数)和row[i+1]是一组的话那么有row[i]==row[i+1]
    // 对于row[i]和row[i+1]不是同一组的情况，将它们合并成一个组，假设把row[j]合并到row[i]组中，此时计数器cnt++;
    // 至于这种解法为什么会有效，我是这么理解的，如果row[i]和row[i+1]不是一对的话，row[i+1]肯定和别的元素是一对，可以先把row[i+1]拉入row[i]所在的组中，在之后的遍历中一定会找到的
    public int minSwapsCouples(int[] row) {
        if(row==null || row.length==0)
            return 0;

        int res=0;// 记录要交换的次数
        Map<Integer, List<Integer>> groupId2EleIndex = new HashMap<>();// <组编号,在此组中元素的索引>
        int[] groupId = new int[row.length];// 组编号
        for(int i=0; i<row.length; i++){
            int r = row[i];
            List<Integer> list = groupId2EleIndex.getOrDefault(r/2, new ArrayList<>());
            list.add(i);
            groupId2EleIndex.put(r/2, list);
            groupId[i] = r/2;
        }

        for(int i=0; i<row.length; i+=2){
            int groupIId = groupId[i];
            int groupIId1 = groupId[i+1];
            // 相邻两个元素的组编号不相同
            if(groupIId!=groupIId1){
                List<Integer> indexes = groupId2EleIndex.get(groupIId1);
                List<Integer> targetIndexes = groupId2EleIndex.get(groupIId);
                for(int index: indexes){
                    groupId[index] = groupIId;
                    targetIndexes.add(index);
                }
                res++;
            }

        }
        return res;
    }





// 遍历数组：这个解法的思路很简单，就是遍历数组，判断处于偶数位置的元素和其下一个元素是否为一对，如果是的话继续遍历，否则从后面的元素中找到与该元素配对的元素并交换位置
//    public int minSwapsCouples(int[] row) {
//        if(row==null || row.length==0)
//            return 0;
//
//        int res=0;
//        for(int i=0; i<row.length; i+=2){
//            // row[i + 1] == (row[i] ^ 1) 判断row[i]和row[i+1]是否为一对
//            if(row[i + 1] == (row[i] ^ 1))
//                continue;
//            for(int j=i+1; j<row.length; j++){
//                if(row[j] == (row[i] ^ 1)){
//                    swap(row, i+1, j);
//                    res++;
//                    break;
//                }
//            }
//
//        }
//
//        return res;
//    }



    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] test = {0,2,4,6,7,1,3,5};
        Num765_CouplesHoldingHands n = new Num765_CouplesHoldingHands();
        int ans = n.minSwapsCouples(test);
        System.out.println(ans);
    }

}
