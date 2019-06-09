package com.leetcode.graph;

import java.util.*;

public class Num207CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 判断该图是否有环，有环则是不能
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;


    }


    private static boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    public static void main(String[] args){
        int v = 2;
        int[][] e= new int[][]{{1,0},{0,1}};
        canFinish(v, e);
    }
}
