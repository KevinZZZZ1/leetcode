package com.leetcode.tree;

// Given a binary search tree (BST) with duplicates,
// find all the mode(s) (the most frequently occurred element) in the given BST.


import java.util.ArrayList;
import java.util.List;

// 给定一个BST，找出BST中节点值出现最多次数的值
public class Num501_FindModeinBinarySearchTree {
    // 思路是，根据中序遍历BST会得到有序序列这个性质来进行处理，只要每次递归的时候记录下上一个节点的值，已经出现次数即可
    private int curCnt=1;
    private int maxCnt=1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);

        int[] ret = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            ret[i] = ans.get(i);
        }

        return ret;
    }

    private void inOrder(TreeNode root, List<Integer> ans){
        if(root==null)
            return;

        inOrder(root.left, ans);

        if(preNode!=null){
            if(preNode.val==root.val)
                curCnt++;
            else
                curCnt=1;
        }

        if(curCnt>maxCnt){
            ans.clear();
            ans.add(root.val);
            maxCnt = curCnt;
        }else if(curCnt==maxCnt){
            ans.add(root.val);
        }
        preNode = root;

        inOrder(root.right, ans);

    }


    public static void main(String[] args) {

    }

}
