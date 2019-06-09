package com.leetcode.tree;

import java.util.HashSet;
import java.util.Set;

public class BalancedTree {
    private boolean isBalanced = true;
    public boolean isBalancedTree(TreeNode root){
        height(root);
        return isBalanced;
    }
    private int height(TreeNode root){
        if(root==null || !isBalanced)
            return 0;

        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>=2)
            isBalanced = false;

        return Math.max(left, right)+1;
    }

    public static void main(String[] args){



    }

}
