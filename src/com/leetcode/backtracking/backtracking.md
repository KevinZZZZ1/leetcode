# backtracking解题模板

```java
public class Solution {
    
    public List<List<Integer>> solution(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            if (candidates==null || candidates.length==0)
                return ans;
    
            backtracking(ans, new ArrayList<>(), candidates, target, 0);
            return ans;
        }
    
        private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int start) {
            if (target==0){
                ans.add(new ArrayList<>(tmp));
                return;
            }
    
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i]<=target){
                    tmp.add(candidates[i]);
                    backtracking(ans, tmp, candidates, target-candidates[i], i);
                    tmp.remove(tmp.size()-1);
                }
            }
    
        }
    
    
}

```