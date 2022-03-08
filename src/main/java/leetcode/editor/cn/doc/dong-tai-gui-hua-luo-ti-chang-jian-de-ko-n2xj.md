### 朴素 DP 解法

```java
class Solution {
    public List<Integer> getRow(int idx) {
        int[][] f = new int[idx + 1][idx + 1];
        f[0][0] = 1;
        for (int i = 1; i < idx + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                f[i][j] = f[i - 1][j];
                if (j - 1 >= 0) f[i][j] += f[i - 1][j - 1];
                if (f[i][j] == 0) f[i][j] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < idx + 1; i++) ans.add(f[idx][i]);
        return ans;
    }
}
```
* 时间复杂度：*O(n^2)*
* 空间复杂度：*O(n^2)*

***
### 奇偶滚动 DP 解法 

滚动数组优化十分机械，直接将滚动的维度从 `i` 改造为 `i % 2` 或 `i & 1` 即可。

`i & 1` 相比于 `i % 2` 在不同架构的机器上，效率会更稳定些 ~ 

```java
class Solution {
    public List<Integer> getRow(int idx) {
        int[][] f = new int[2][idx + 1];
        f[0][0] = 1;
        for (int i = 1; i < idx + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                f[i & 1][j] = f[(i - 1) & 1][j];
                if (j - 1 >= 0) f[i & 1][j] += f[(i - 1) & 1][j - 1];
                if (f[i & 1][j] == 0) f[i & 1][j] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < idx + 1; i++) ans.add(f[idx & 1][i]);
        return ans;
    }
}
```
* 时间复杂度：*O(n^2)*
* 空间复杂度：*O(n)*

***

### 维度消除 DP 解法

只有第 `i` 行的更新只依赖于 `i - 1` 行，因此可以直接消除行的维度：

```java
class Solution {
    public List<Integer> getRow(int idx) {
        int[] f = new int[idx + 1];
        f[0] = 1;
        for (int i = 1; i < idx + 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (j - 1 >= 0) f[j] += f[j - 1];
                if (f[j] == 0) f[j] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < idx + 1; i++) ans.add(f[i]);
        return ans;
    }
}
```
* 时间复杂度：*O(n^2)*
* 空间复杂度：*O(n)*

***

# 其他

同样的技巧，我在 [978. 最长湍流子数组](https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/xiang-jie-dong-tai-gui-hua-ru-he-cai-dp-3spgj/) 给你介绍过，建议稍作回顾哦  ~ 

***

# 最后

如果有帮助到你，请给个点赞关注 ~ ("▔□▔)/

祝大家新年快乐 ~ 

我会在每完成一道题就写一篇题解，欢迎你来和我一起刷穿 LeetCode ~