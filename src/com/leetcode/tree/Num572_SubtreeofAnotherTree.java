package com.leetcode.tree;
// Given two non-empty binary trees s and t,
// check whether tree t has exactly the same structure and node values with a subtree of s.
// A subtree of s is a tree consists of a node in s and all of this node's descendants.
// The tree s could also be considered as a subtree of itself.

// 给定两个非空二叉树s和t，判断t是否为s的子树
public class Num572_SubtreeofAnotherTree {
    // 思路和Num437差不多，对于某个节点可以分成以下情况：
        // 1.节点是子树的根；
        // 2.孩子节点才是子树的根；
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)
            return false;

        return isSubtreeRootStart(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);

    }
    // 节点s是子树的根
    private boolean isSubtreeRootStart(TreeNode s, TreeNode t){
        if(s==null && t==null)
            return true;
        if(t==null || s==null)
            return false;
        if(s.val!=t.val)
            return false;

        return isSubtreeRootStart(s.right, t.right) && isSubtreeRootStart(s.left, t.left);
    }

    public static void main(String[] args) {

    }

}
