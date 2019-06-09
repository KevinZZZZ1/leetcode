package com.leetcode.string;

/**
 * It has at least 6 characters and at most 20 characters.
 * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
 *
 * StrongPassword的定义：
 * 1.密码长度在6-20个字节间
 * 2.密码的字符至少保证一个小写字母，一个大写字母，一个数字
 * 3.不能连续出现3个同样的字符
 */
public class Num420_StrongPasswordChecker {
    /**
     * 将先检查输入密码s是否为强类型密码（StrongPassword）：
     *  如果是的话，返回0；
     *  如果不是，使用插入、删除、替换其他字符的方式将s变成强类型密码，返回改变最少使用的操作次数；
     * @param s
     * @return
     */
    private int flag=0; // 表示s不满足强类型密码哪个条件；1表示不满足条件1；2表示不满足条件2；3表示不满足条件3

    public int strongPasswordChecker(String s) {
        if(passwordCheck(s))
            return 0;

        return 0;
    }

    private boolean passwordCheck(String s){
        if(s.length()<6 || s.length()>20) {
            this.flag=1;
            return false;
        }
        int lowerCase=0, upperCase=0, digit=0, duplicate=0;
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++){
            char tmp = cs[i];

            if(tmp>='a' && tmp<='z')
                lowerCase++;
            if(tmp>='A' && tmp<='Z')
                upperCase++;
            if(tmp>='0' && tmp<='9')
                digit++;

            if(tmp == cs[i-duplicate])
                duplicate++;
            else
                duplicate=0;
            if(duplicate>=3) {
                this.flag=3;
                return false;
            }
        }

        if(lowerCase<1 || upperCase<1 || digit<1){
            this.flag=2;
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String test = "aaa2a34Zff";
        Num420_StrongPasswordChecker n = new Num420_StrongPasswordChecker();
        n.passwordCheck(test);
    }
}
