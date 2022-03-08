### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
     List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        if (nums.length==0)
            return res;
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        backtrack(new ArrayList<>());
        return res;
    }

    private void backtrack(List<Integer> list){

        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));
        for (int i=0;i<nums.length;i++){
            if (visited[i])
                continue;
            if (i-1>=0 && nums[i]==nums[i-1] && !visited[i-1])
                continue;
            else{
                list.add(nums[i]);
                visited[i] = true;
                backtrack(list);
                list.remove(list.size()-1);
                visited[i] = false;
            }

        }
    }
}
```