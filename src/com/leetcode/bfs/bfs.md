# bfs解题模板
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
                bfs(matrix, i, j, visited);
            }
        }
        
        
    }
    
    private void bfs(int[][] matrix, int i, int j, boolean[][] visited){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(matrix[i][j]);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-->0) {
                int cur = queue.poll();
                for (int tmp: graphic[cur]) {
                    queue.add(tmp);
                    // 省略具体处理代码
                }
            }
            
        }
    }
}
```