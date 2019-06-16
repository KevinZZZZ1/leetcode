package com.leetcode.linkedlist;

// Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
//
//The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
//
//The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

// 把链表分隔成 k 部分，每部分的长度都应该尽可能相同，排在前面的长度应该大于等于后面的。
public class Num725_SplitLinkedListinParts {
    // 解题思路很简单：先计算出链表中有多少个元素，再根据给定的k值确定链表可以分成多少部分，然后再遍历链表，形成最后答案
    public ListNode[] splitListToParts(ListNode root, int k) {

        int count=0;
        ListNode cur = root;
        // 计算链表中有多少个元素
        while(cur!=null){
            count++;
            cur = cur.next;
        }

        int num = count/k; // 链表每部分应该有多少元素
        int mod = count%k; // 前mod个部分链表会多一个元素
        ListNode[] ret = new ListNode[k];
        cur = root;
        for(int i=0; cur!=null&&i<ret.length; i++){
            int len = num + (mod-->0? 1: 0);
            ret[i] = cur;
            for(int j=0; j<len-1; j++){
                cur = cur.next;
            }
            ListNode tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }

        return ret;
    }

    public static void main(String[] args) {

    }

}
