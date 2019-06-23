package com.leetcode.tree;
// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST

//         _______6______
//      /                \
//  ___2__             ___8__
// /      \           /      \
//0        4         7        9
//        /  \
//       3   5
// For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
// 例如，节点2和节点8的最近公共祖先是节点6，节点2和节点4的最近公共祖先是2


// 给定一个BST，找出给定两个节点的最近公共祖先
public class Num235_LowestCommonAncestorofaBinarySearchTree {
    // 思路是：根据BST的性质，如果root.val>p.val && root.val>q.val 那么最近公共祖先在左子树中；
    //                        如果root.val<p.val && root.val<q,val 那么最近公共祖先在右子树中；
    //                        否则就是根节点；
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left, p, q);
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {

    }

}
