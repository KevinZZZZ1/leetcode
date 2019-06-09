package com.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 循环小数==》从某位开始商循环，也就是出现之前已出现的过余数！！！
 */


public class Num166_Fraction2RecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0)
            throw new RuntimeException("division by zero");

        if(numerator == 0)
            return String.valueOf(0);

        if(denominator ==1)
            return String.valueOf(numerator);

        boolean isNegative = (numerator>0 && denominator<0) || (numerator<0 && denominator>0)?true:false;
        StringBuffer sb = new StringBuffer();
        Map<Long, Integer> remain = new HashMap<>(); // 用来保存小数部分<余数，位置>键值对，记录下该余数对应的商出现的位置
        if(isNegative)
            sb.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long quotient = num/den;
        sb.append(quotient); // 整数部分
        long remainder = num%den;// 余数

        int quotientIndex = 0;
        if(remainder!=0) { // 不能整除。小数部分
            sb.append(".");

            while (remainder!=0){
                remainder *=10;
                quotient = remainder/den;
                if(!remain.containsKey(remainder)){ // 该余数为出现，换句话说就是商重复
                    sb.append(quotient);
                    remain.put(remainder, quotientIndex++);
                }else{// 开始循环
                    int firstIndex =1 + remain.get(remainder) + sb.indexOf(".");
                    sb.insert(firstIndex, "(");
                    sb.append(")");
                    break;
                }

                remainder = remainder%den;
            }

        }
        return sb.toString();

    }




    public static void main(String[] args) {
        int num = 3;
        int den = 9;
        String ans = fractionToDecimal(num, den);
        System.out.println(ans);
    }
}
