package com.leetcode.linkedlist;

// Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

// 给定一个链表，将链表按照位置的奇偶顺序分成两部分，奇数部分在前，偶数部分在后；
// 例如：Input: 2->1->3->5->6->4->7->NULL
//      Output: 2->3->6->7->1->5->4->NULL
public class Num328_OddEvenLinkedList {
    // 思路是：设置两个指针odd和even，遍历链表，按照规则进行移动即可；
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;

        ListNode odd = head, even = head.next;
        ListNode evenHead = even; // 用来记录偶数链表的头

        while (even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }


    public static void main(String[] args) {

    }

}
