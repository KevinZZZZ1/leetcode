package com.leetcode.graph;

import java.util.*;


// 一个课程可能会先修课程，判断给定的先修课程规定是否合法。
public class Num207CourseSchedule {

    // 思路是：本题不需要使用拓扑排序，只需要检测有向图是否存在环即可。
    // numCourses表示点的数量；prerequisites数组表示有向边
    // 比如：2, [[1,0],[0,1]]===》有2个点，边为[1,0]、[0,1]
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 判断该图是否有环，有环则是不能
        //构造图的数据结构，使用邻接矩阵
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
        // 记录下之前是否访问过
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        // 在使用深度优先搜索遍历图
        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;


    }


    private static boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        // 判断是否访问过该节点，如果访问过就说明有环，return false
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        // 深度优先搜索
        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        //
        visited[course] = false;
        return true;
    }

    public static void main(String[] args){
        int v = 3;
        int[][] e= {{0,1},{0,2}};
        canFinish(v, e);
    }
}
