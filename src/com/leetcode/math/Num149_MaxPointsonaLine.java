package com.leetcode.math;

import java.util.*;

/**
 * 一条直线由斜率和直线上一个点确定
 * 使用了配对函数（Pairing Function）
 * 配对函数能将两个自然数编码成一个自然数
 * 常见的有康托尔（Cantor）配对函数：
 * pi(k1, k2) = 1/2*(k1+k2)*(k1+k2+1)+k2
 *
 * 斜率可以由分数来表示，<分子，分母>可以使用配对函数唯一表示，这样就避免了计算斜率时浮点数精度问题
 */


public class Num149_MaxPointsonaLine {


    public static int maxPoints(int[][] points) {
        int len = points.length;
        if(len<3)
            return len;

        List<Point> ps = new ArrayList<>();
        for(int i=0; i<len; i++){
            Point p = new Point(points[i][0], points[i][1]);
            ps.add(p);
        }

        int max = 2; // 最后的返回结果，表示一条直线上最多的点数
        for (Point p1 : ps) {
            Map<Integer, Integer> slopes = new HashMap<>(ps.size()); //
            int localMax = 0;
            for (Point p2 : ps) {
                int num = p2.y - p1.y; // 分子
                int den = p2.x - p1.x; // 分母

                // 配对函数只能针对于非负数，所以要存储斜率符号
                int sign = 1;
                if ((num > 0 && den < 0) || (num < 0 && den > 0)) sign = -1;
                num = Math.abs(num);
                den = Math.abs(den);


                // 配对函数能唯一的表示一对整数，所以可以将它们视作一组整数的Hash函数
                // 所以1/2和3/6的配对函数值是不同的，所以我们需要把每个分数化简到最简
                // 用最大公约数进行分数化简
                int gcd = GCD(num, den);
                num = gcd == 0 ? num : num / gcd;
                den = gcd == 0 ? den : den / gcd;

                // 使用康托尔配对函数 pi(k1, k2) = 1/2(k1 + k2)(k1 + k2 + 1) + k2
                int m = sign * (num + den) * (num + den + 1) / 2 + den;
                if (slopes.containsKey(m))
                    slopes.put(m, slopes.get(m)+1);
                else
                    slopes.put(m, 1);

                if (m == 0) // m == 0表示k1, k2都为0，即p1,p2坐标相同
                    continue;

                localMax = Math.max(slopes.get(m),localMax); //
            }
            max = Math.max(max, localMax + slopes.get(0)); // 对以p1为起点的直线上点的最多数量进行更新，slopes.get(0)表示坐标相同的点数；
        }
        return max;
    }


    public static int GCD(int a, int b){
        if(b==0)
            return a;
        return GCD(b, a%b);
    }




    public static void main(String[] args) {
        // [[2,3],[3,3],[-5,3]] 3
        // [[1,1],[1,1],[2,3]] 3
        // [[1,1],[2,2],[3,3]] 3
        // [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] 4
        // [[1,1],[1,1],[1,1],[2,3],[4,6],[2,2],[2,2]] 7
        // [[4,0],[4,-1],[4,5]] 3
        // [[1,1],[1,1],[1,1]] 3
        // [[0,-12],[5,2],[2,5],[0,-5],[1,5],[2,-2],[5,-4],[3,4],[-2,4],[-1,4],[0,-5],[0,-8],[-2,-1],[0,-11],[0,-9]] 6

        int[][] test = {{1,1},{1,1},{1,1},{2,3},{4,6},{2,2},{2,2}};
//        int[][] test = {{2,3},{3,3},{-5,3}};
//        int[][] test = {{4,0},{4,-1},{4,5}};
//        int[][] test = {{1,1},{1,1},{1,1}};
//        int[][] test = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
//        int[][] test = {{1,1},{1,1},{2,3}};
//        int[][] test = {{0,-12},{5,2},{2,5},{0,-5},{1,5},{2,-2},{5,-4},{3,4},{-2,4},{-1,4},{0,-5},{0,-8},{-2,-1},{0,-11},{0,-9}};
        int ans = maxPoints(test);
        System.out.println(ans);

    }

}

class Point{
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


}


