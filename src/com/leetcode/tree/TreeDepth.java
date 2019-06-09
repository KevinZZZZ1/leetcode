package com.leetcode.tree;
import java.util.*;
public class TreeDepth {

    public static int TreeDepth(TreeNode root) {
        // DFS
        if(root==null)
            return 0;

        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        int max_depth=0;
        Map<TreeNode,Integer> map = new HashMap<>();
        int depth=1;
        s.push(cur);
        map.put(root,depth);
        while(!s.empty()){
            cur = s.pop();
            depth = map.getOrDefault(cur,0);
            if(cur.right!=null){
                s.push(cur.right);
                map.put(cur.right, depth+1);
            }
            if(cur.left!=null){
                s.push(cur.left);
                map.put(cur.left, depth+1);
            }

            if(cur.left==null && cur.right==null){
                max_depth = depth>max_depth?depth:max_depth;
            }
        }

        return max_depth;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;

        int depth = TreeDepth(root);
        System.out.println(depth);
    }
}
