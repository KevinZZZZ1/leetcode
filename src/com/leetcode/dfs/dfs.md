# dfs解题模板

一般来说，使用dfs来解决的问题都可以写成如下的样子，需要注意的是，这里只是一个模板，具体的问题会有一些不同

```java
public class Solution {
	private int[][] directions={{0,1}, {0,-1}, {1,0}, {-1,0}};
	private m,n;
    
    public void solution(int[][] matrix){
        if(matrix==null || matrix.length==0)
            return;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(matrix, i, j, visited);
            }
        }
        
        
    }
    
    private void dfs(int[][] matrix, int i, int j, boolean[][] visited){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j])
            return;
        // 省略具体处理代码
        
        for(int[] d: directions){
            dfs(matrix, i+d[0], j+d[1], visited);
        }
    }
}
```





