package com.leetcode.twopointer;


// 给定一个链表head和一个整数n，移除链表中从尾部数第n个元素
public class Num19_RemoveNthNodeFromEndofList {
    // 思路是：使用两个指针first,second，首先让first指针先遍历n个节点，然后first和second指针同时遍历节点，直到first为null，此时second指向的就是从尾数第n个节点
    // 所以先设置一个伪头节点，进行n次扫描后到达尾数第n个节点的前一个
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head==null)
            return null;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode first=fakeHead, second=fakeHead;

        while (n>=0){
            first = first.next;
            n--;
        }
        while (first!=null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;

        return fakeHead.next;
    }

    public static void main(String[] args) {

    }

}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
