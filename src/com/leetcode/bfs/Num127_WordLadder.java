package com.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 给定两个字符串beginWord、endWord以及字符串列表，找出一条将 字符串beginWord 修改成 字符串endWord 的最短路径，每次修改规定为改变一个字符，并且改变之后的字符串必须在 wordList 中。
// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]

// Output: 5

// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// 例如："hit"->"hot"只将"i"修改成"o"并且"hot"在wordList中
// return its length 5.
public class Num127_WordLadder {
    // 思路是，把wordList中的字符串构成一个图，如果两个字符串长度相等，而且只差一个字符，那么这两个字符串相连
    // 然后再把beginWord加入图中，而且从beginWord开始进行BFS并记录下搜索的步数，第一次找到endWord的步数就是所求值
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null || wordList.size()==0)
            return 0;

        wordList.add(beginWord);
        int N = wordList.size();
        int start = N-1;// 表示beginWord在wordList的位置
        int end = 0; // 表示endWord在wordList中的位置
        // 判断wordList中是否存在endWord，如果有就定位endWord的位置
        while(end<N && !wordList.get(end).equals(endWord)){
            end++;
        }
        // 不存在endWord，直接返回0
        if(end==N)
            return 0;

        List<Integer>[] graphic = buildGraphic(wordList);

        return getShortestPath(graphic, start, end);
    }
    // bfs遍历图
    private int getShortestPath(List<Integer>[] graphic, int start, int end) {

        int path=1; // 从start开始，所以从1开始累加
        boolean[] visited = new boolean[graphic.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            path++;
            while(size-->0){
                int cur = queue.poll();
                // cur表示的节点能访问的所有节点
                for(int tmp: graphic[cur]){
                    if(visited[tmp])
                        continue;
                    if (tmp==end)
                        return path;
                    visited[tmp] = true;
                    queue.add(tmp);
                }
            }
        }
        return 0;

    }
    // 构建一个图数据结构，使用邻接表
    private List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0; i < N; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if(isConnected(wordList.get(i), wordList.get(j))){
                    graphic[i].add(j);
                }
            }
        }

        return graphic;
    }

    // 判断字符串s和字符串s1是否只有一个字符不同
    private boolean isConnected(String s, String s1) {

        if(s==null || s1==null || s.length()!=s1.length())
            return false;

        int cnt=0;
        for (int i = 0; i < s.length() && cnt<=1; i++) {
            if(s.charAt(i)!=s1.charAt(i))
                cnt++;
        }

        return cnt==1;
    }

    public static void main(String[] args) {

    }

}
