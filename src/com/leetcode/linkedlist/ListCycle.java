package com.leetcode.linkedlist;

import java.util.List;

// 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class ListCycle {

    public ListNode EntryNodeOfLoop(ListNode pHead){

        if(pHead==null || pHead.next==null)
            return null;

        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode meet = slow;
        slow = pHead;
        while(meet!=slow){
            slow = slow.next;
            meet = meet.next;
        }
        return meet;

    }

}
