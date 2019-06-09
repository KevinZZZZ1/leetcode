package com.leetcode.tree;
import java.util.*;

// 请实现一个函数按照之字形打印二叉树，
// 即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，
// 第三行按照从左到右的顺序打印，其他行以此类推。
public class PrintZigZag {

    public static ArrayList<ArrayList<Integer>> ZigZagPrintTree(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size(); // 记录某一层所有的子节点数
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val); // 将该结点加入
                queue.add(node.left); // 左孩子入队列
                queue.add(node.right); // 右孩子入队列
            }
            if (reverse)
                Collections.reverse(list);// 如果需要reverse的话，进行reverse
            reverse = !reverse;
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }



    public static void main(String[] args){



    }
}
