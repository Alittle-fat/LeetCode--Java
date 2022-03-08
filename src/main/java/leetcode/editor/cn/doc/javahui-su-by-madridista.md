总体思路是回溯，以每个节点为起点，向下遍历树，当走过的路径和为sum时，更新res。
```
class Solution {
    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return res;

        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void helper(TreeNode node, int sum){
        if(node == null) return;

        sum -= node.val;
        if(sum == 0)
            res ++;
        helper(node.left, sum);
        helper(node.right, sum);
        sum += node.val;
    }
}
```

