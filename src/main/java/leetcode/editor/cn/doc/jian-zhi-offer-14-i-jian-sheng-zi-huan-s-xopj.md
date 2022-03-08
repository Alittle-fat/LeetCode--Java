# [剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)
***
### 思路一：动态规划
这题用动态规划是比较好理解的
1. 我们想要求长度为`n`的绳子剪掉后的最大乘积，可以从前面比`n`小的绳子转移而来
2. 用一个`dp数组`记录`从0到n`长度的绳子剪掉后的最大乘积，也就是`dp[i]`表示长度为`i`的绳子剪成`m`段后的最大乘积，初始化`dp[2] = 1`
3. 我们先把绳子剪掉第一段`（长度为j）`，如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
4. 剪了第一段后，剩下`(i - j)`长度可以剪也可以不剪。如果不剪的话长度乘积即为`j * (i - j)`；如果剪的话长度乘积即为`j * dp[i - j]`。取两者最大值`max(j * (i - j), j * dp[i - j])`
5. 第一段长度`j`可以取的区间为`[2,i)`，对所有`j`不同的情况取最大值，因此最终`dp[i]`的转移方程为
`dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))`
6. 最后返回`dp[n]`即可
### 代码
```Python3 []
class Solution:
    def cuttingRope(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[2] = 1
        for i in range(3, n + 1):
            for j in range(2, i):
                dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
        return dp[n]
```

```Java []
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
```

**复杂度分析**
- 时间复杂度：*O(n ^ 2)*
- 空间复杂度：*O(n)*
***
### 思路二：贪心

核心思路是：**尽可能把绳子分成长度为3的小段，这样乘积最大**
>证明可参考[这个题解](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/)

步骤如下：
1. 如果 n == 2，返回1，如果 n == 3，返回2，两个可以合并成n小于4的时候返回n - 1
2. 如果 n == 4，返回4
3. 如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段
4. 以上2和3可以合并
### 代码
```Python3 []
class Solution:
    def cuttingRope(self, n: int) -> int:
        if n < 4:
            return n - 1
        res = 1
        while n > 4:
            res *=3
            n -= 3
        return res * n
```

```Java []
class Solution {
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
```
**复杂度分析**
- 时间复杂度：*O(n)*
- 空间复杂度：*O(1)*