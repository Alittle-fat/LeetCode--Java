### 解题思路
1. 定义dp[i][j]的含义为 走到[i,j]位置有dp[i][j]种走法 数组从0开始，所以dp[m-1][n-1]即为所求
2. 状态转移方程 走到dp[i][j]上可以从左dp[i-1][j]或上dp[i][j-1]进入,得dp[i][j] = dp[i-1][j] + dp[i][j-1]
3. 初始值 第一行dp[i][0]第一列dp[0][j]都是只有 一种走法，得 dp[i][0] = dp[0][j] = 1

### 代码

```java
class Solution {
    public int uniquePaths(int m, int n) {
        // 定义dp[i][j]的含义为 走到[i,j]位置有dp[i][j]种走法 数组从0开始，所以dp[m-1][n-1]即为所求
        // 状态转移方程 走到dp[i][j]上可以从左dp[i-1][j]或上dp[i][j-1]进入,得dp[i][j] = dp[i-1][j] + dp[i][j-1]
        // 初始值 第一行dp[i][0]第一列dp[0][j]都是只有 一种走法，得 dp[i][0] = dp[0][j] = 1
        int[][] dp = new int[m][n];
        // 初始化行 dp[i][0]
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 初始化列 dp[0][j]
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
```