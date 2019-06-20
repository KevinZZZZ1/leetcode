package com.leetcode.tree;
// Given a binary tree, find the leftmost value in the last row of the tree.


import java.util.LinkedList;
import java.util.Queue;

// 给定一个二叉树，找到该二叉树中最后一层最左边的节点
public class Num513_FindBottomLeftTreeValue {

    // 思路是：利用bfs，先搜索某个节点的右孩子，再搜索左孩子，这样最后剩下的就是该二叉树中最后一层最左边的节点
    public int findBottomLeftValue(TreeNode root) {
        if (root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp = null;
        while(!queue.isEmpty()){
             tmp = queue.poll();
            if(tmp.right!=null)
                queue.add(tmp.right);
            if(tmp.left!=null)
                queue.add(tmp.left);
        }

        return tmp.val;
    }

    public static void main(String[] args) {

    }

}
