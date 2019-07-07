package com.leetcode.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

// 给定课程总数和有向边的数组，返回完成所有课程所需的课程顺序
public class Num210_CourseScheduleII {
    // 思路是：使用 DFS 来实现拓扑排序，使用一个栈存储后序遍历结果，这个栈的逆序结果就是拓扑排序结果。
    // 要修课程0，你必须先修课程1，表示为一对：[0,1]，其实用边表示就是边1->0
    //证明：对于任何先序关系：v->w，后序遍历结果可以保证 w 先进入栈中，因此栈的逆序结果中 v 会在 w 之前。
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 使用邻接矩阵作为图的存储结构
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graphic[pre[0]].add(pre[1]);
        }
        // 用栈记录下访问图中点的顺序
        Stack<Integer> postOrder = new Stack<>();
        boolean[] globalMarked = new boolean[numCourses]; // 用来记录点是否在之前的dfs中被访问过
        boolean[] localMarked = new boolean[numCourses]; // 用来记录点是否在本次的dfs中被访问过
        // 深度优先搜索
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(globalMarked, localMarked, graphic, i, postOrder)) {
                return new int[0]; // 如果有环返回一个空数组
            }
        }
        // 根据后序遍历的顺序得到结果
        int[] orders = new int[numCourses];
        for (int i = numCourses - 1; i >= 0; i--) {
            orders[i] = postOrder.pop();
        }
        return orders;
    }

    private boolean hasCycle(boolean[] globalMarked, boolean[] localMarked, List<Integer>[] graphic,
                             int curNode, Stack<Integer> postOrder) {
        // 如果在本次的dfs中访问过，说明有环
        if (localMarked[curNode]) {
            return true;
        }
        //
        if (globalMarked[curNode]) {
            return false;
        }
        // 设置已访问
        globalMarked[curNode] = true;
        localMarked[curNode] = true;
        for (int nextNode : graphic[curNode]) {
            if (hasCycle(globalMarked, localMarked, graphic, nextNode, postOrder)) {
                return true;
            }
        }
        // 恢复局部访问变量
        localMarked[curNode] = false;
        postOrder.push(curNode);
        return false;
    }


    public static void main(String[] args) {
        int[][] e = {{1,0},{2,0},{3,1},{3,2}};
        Num210_CourseScheduleII n = new Num210_CourseScheduleII();
        n.findOrder(4, e);
    }

}
