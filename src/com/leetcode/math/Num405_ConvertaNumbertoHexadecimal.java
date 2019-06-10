package com.leetcode.math;



// Given an integer, write an algorithm to convert it to hexadecimal.
// For negative integer, two’s complement method is used.

// 这道题和第504题不同之处在于，该题的负数要使用补码表示(two's complement)
public class Num405_ConvertaNumbertoHexadecimal {
    // Note:
    //All letters in hexadecimal (a-f) must be in lowercase.
    //The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
    //The given number is guaranteed to fit within the range of a 32-bit signed integer.
    //You must not use any method provided by the library which converts/formats the number to hex directly.


    public static String toHex(int num) {

        if(num==0)
            return "0";
        char[] maps = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuffer sb = new StringBuffer();
        while (num != 0) {

            // 下面代码的思想和2进制、7进制等转换的思想是一致的，都是先求余数，再除法，即：
            // num%base;
            // num /= base;

            sb.append(maps[num & 0b1111]); // 16的二进制表示为10000，num%16可以写成num&15，15按照二进制的写法为ob1111
            num =num>>> 4; // >>1相当于除2，所以>>4相当于除16，又因为考虑的是补码形式，因此符号位就不能有特殊的意义，需要使用无符号右移，左边填 0
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        int test = -1;
        System.out.println(toHex(test));

    }
}
