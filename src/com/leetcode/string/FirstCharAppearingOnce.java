package com.leetcode.string;
import java.util.*;
//请实现一个函数用来找出字符流中第一个只出现一次的字符。
// 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
// 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

public class FirstCharAppearingOnce {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();
    public void Insert(char c){
        cnts[c]++; // 记录当前字符的出现次数
        queue.add(c); // 将当前字符加入队列中
        while(!queue.isEmpty() && (cnts[queue.peek()]>1)) // 在队列不为空的条件下，如果队列头的字符出现次数大于1，则出队，直到队首的字符出现次数为1
            queue.poll();

    }
    public char FirstAppearingOnce(){
        return queue.isEmpty()?'#':queue.peek();
    }

}
