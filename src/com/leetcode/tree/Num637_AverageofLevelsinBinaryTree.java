package com.leetcode.tree;

// Given a non-empty binary tree,
// return the average value of the nodes on each level in the form of an array.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 给定一个二叉树，求出二叉树每一层值的平均数，并且以链表的形式返回
public class Num637_AverageofLevelsinBinaryTree {
    // 思路是：使用bfs（宽度优先搜索）可以遍历每一层的元素，然后计算平均数；
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            double sum = 0.0;
            for(int i=0; i<count; i++){
                TreeNode tmp = queue.poll();
                sum+=tmp.val;
                if(tmp.left!=null)
                    queue.add(tmp.left);
                if(tmp.right!=null)
                    queue.add(tmp.right);
            }
            ans.add(sum/count);
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
