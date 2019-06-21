package com.leetcode.tree;

// Given a binary tree, return the preorder traversal of its nodes' values.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 给定一个二叉树，在不使用递归的条件下求出二叉树的前序遍历
public class Num144_BinaryTreePreorderTraversal {
    // 思路是：使用栈来模拟递归调用，前序遍历为：根左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            ans.add(tmp.val);

            if(tmp.right!=null)
                stack.push(tmp.right);
            if(tmp.left!=null)
                stack.push(tmp.left);

        }

        return ans;
    }


    public static void main(String[] args) {

    }

}
