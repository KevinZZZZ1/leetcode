package com.leetcode.linkedlist;

// Given a singly linked list, determine if it is a palindrome.

import java.util.List;

// 给定一个链表，判断其是否为一个回文序列
public class Num234_PalindromeLinkedList {
    // 使用快慢指针，将链表从中间分成两个链表，再把后一个链表进行逆转，再比较两个链表是否相同；
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null)
            return true;
        // 如果链表元素个数为偶数：[head, slow],[slow.next, fast]
        // 如果链表元素个数为奇数:[head, slow),[slow.next, fast)
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast!=null){// 链表个数为偶数的情况
            slow = slow.next; // 将slow统一和奇数情况一样，都指向第二个链表的开始
        }

        cut(head, slow);

        return isEqual(head, reverse(slow));
    }

    private void cut(ListNode l1, ListNode l2){
        while (l1.next!=l2){
            l1 = l1.next;
        }
        l1.next = null;
    }


    private ListNode reverse(ListNode node){
        ListNode newHead = new ListNode(0);
        while(node!=null){
            // 头插法
            ListNode tmp = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = tmp;
        }

        return newHead.next;
    }

    private boolean isEqual(ListNode l1, ListNode l2){
        if(l1==null && l2==null)
            return true;

        while(l1!=null && l2!=null){
            if(l1.val!=l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return true;
    }



    public static void main(String[] args) {

    }
}


