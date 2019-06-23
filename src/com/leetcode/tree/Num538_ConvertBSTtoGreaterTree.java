package com.leetcode.tree;
// Given a Binary Search Tree (BST),
// convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

// Input: The root of a Binary Search Tree like this:
//              5
//            /   \
//           2     13
//
//Output: The root of a Greater Tree like this:
//             18
//            /   \
//          20     13
// 20 = 2+5+13; 18 = 5+13; 13 =13


// 给定一个二叉查找树，将其转换为Greater Tree 也就是说，将原来BST的节点值替换为原值+节点值大于该节点值之和
public class Num538_ConvertBSTtoGreaterTree {
    // 思路是：以右根左的顺序遍历二叉查找树，每次都记录下当前节点的值，传递给下一个节点
    private int val=0;
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    private void reverseInorder(TreeNode root){
        if (root==null)
            return;
        reverseInorder(root.right);
        val += root.val;
        root.val = val;

        reverseInorder(root.left);

    }

    public static void main(String[] args) {

    }

}
