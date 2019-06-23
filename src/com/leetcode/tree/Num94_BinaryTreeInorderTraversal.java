package com.leetcode.tree;
// Given a binary tree, return the inorder traversal of its nodes' values


import java.util.List;
import java.util.*;

// 给定一个二叉树，不使用递归的方式求出其中序遍历
public class Num94_BinaryTreeInorderTraversal {
    // 思路是：利用栈进行递归模拟
    // 中序遍历：左根右
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new LinkedList<Integer>();
        if(root==null)
            return ans;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        while(!stack.empty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
