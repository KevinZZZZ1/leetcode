package com.leetcode.tree;
// Given a binary tree, return the postorder traversal of its nodes' values.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// 给定一个二叉树，不使用递归的方式求出其后序遍历
public class Num145_BinaryTreePostorderTraversal {
    // 思路是：由于后序遍历是左右根，如果把前序遍历由根左右变成根右左，再反转就变成了左右根
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            ans.add(tmp.val);
            if(tmp.left!=null)
                stack.push(tmp.left);
            if(tmp.right!=null)
                stack.push(tmp.right);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {

    }

}
