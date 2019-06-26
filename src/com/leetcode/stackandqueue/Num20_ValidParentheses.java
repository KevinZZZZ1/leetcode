package com.leetcode.stackandqueue;

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.

import java.util.Stack;

// 给定一个字符串包含字符，'(', ')', '{', '}', '[' 和 ']' ，判断输入字符串的括号是否匹配
public class Num20_ValidParentheses {
    // 思路是：用栈来进行匹配，'(', '{', '['直接入栈，如果是')', '}', ']'，则与栈顶元素比较：
    //      如果匹配则出栈，否则返回false;
    //      最后判断栈是否为空，如果为空放回true，否则false;
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if(c=='(' || c=='[' || c=='{')
                stack.push(c);
            else{
                if (stack.isEmpty()) {
                    return false;
                }

                char tmp = stack.pop();
                boolean b1 = (c==')' && tmp!='(');
                boolean b2 = (c==']' && tmp!='[');
                boolean b3 = (c=='}' && tmp!='{');

                if(b1 || b2 || b3)
                    return false;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }

}
