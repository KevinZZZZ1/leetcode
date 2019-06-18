package com.leetcode.tree;

// You are given a binary tree in which each node contains an integer value.
//
//Find the number of paths that sum to a given value.
//
//The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
//
//The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//Return 3. The paths that sum to 8 are:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3. -3 -> 11

// 给定一个二叉树root和整数sum，在二叉树中寻找有多少条满足一条路径使得该路径上元素值之和等于sum
public class Num437_PathSumIII {

    private int paths = 0;
    // 思路是：对于某个节点来说，可以有两种情况：
        // 1.该节点在某个路径中，
        // 2.该节点不在路径中，
    // 只要求出以上两种情况下，各有多少条路径，再求和即可；
    // 再递归的求解
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        int ret = pathSumRootStart(root, sum)+pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }
    // root在路径中：
    private int pathSumRootStart(TreeNode root, int sum){
        if(root==null)
            return 0;

        int ret=0;
        if(sum==root.val)
            ret++;
        ret+=(pathSumRootStart(root.left, sum-root.val)+pathSumRootStart(root.right, sum-root.val));
        return ret;
    }

    public static void main(String[] args) {

    }

}
