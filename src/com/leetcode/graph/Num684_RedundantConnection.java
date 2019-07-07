package com.leetcode.graph;

// 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
// 返回一条可以删去的边，使得结果图是一个有着N个节点的树
// 有一系列的边连成的图，找出一条边，移除它之后该图能够成为一棵树
public class Num684_RedundantConnection {
    // 思路是：
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length; // 点的个数
        UF uf = new UF(N);
        // 遍历图中所有边，如果边的两个点不在同一个组件内，进行union操作，否则返回这条边；
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (uf.connect(u, v)) {
                return e;
            }
            uf.union(u, v);
        }
        return new int[]{-1, -1};
    }

    private class UF {

        private int[] id; // 用来记录每个点所属的组件

        UF(int N) {
            id = new int[N + 1];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }
        // 先找出点所在组件的id，如果id相同说明在同一个组件，直接返回；
        // 然后遍历组件数组，将两个组件的id变成同一，表示链接在一起；
        void union(int u, int v) {
            int uID = find(u);
            int vID = find(v);
            if (uID == vID) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == uID) {
                    id[i] = vID;
                }
            }
        }
        // find函数用于判断p在那个连通组件中
        int find(int p) {
            return id[p];
        }
        // 判断u，v是否在同一组件上
        boolean connect(int u, int v) {
            return find(u) == find(v);
        }
    }


    public static void main(String[] args) {
        int[][] e = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};

        Num684_RedundantConnection n = new Num684_RedundantConnection();
        n.findRedundantConnection(e);

    }

}
