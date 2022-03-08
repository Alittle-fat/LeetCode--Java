> **点击上方，关注「代码随想录」，算法路上不迷路！**

## 思路 

题目中说每种硬币的数量是无限的，可以看出是典型的完全背包问题。

动规五部曲分析如下：

1. 确定dp数组以及下标的含义

**dp[j]：凑足总额为j所需钱币的最少个数为dp[j]** 

2. 确定递推公式

得到dp[j]（考虑coins[i]），只有一个来源，dp[j - coins[i]]（没有考虑coins[i]）。

凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）

所以dp[j] 要去所有 dp[j - coins[i]] + 1 中最小的。

递推公式：dp[j] =  min(dp[j - coins[i]] + 1, dp[j]);

3. dp数组如何初始化

首先凑足总金额为0所需钱币的个数一定是0，那么dp[0] = 0;

其他下标对应的数值呢？

考虑到递推公式的特性，dp[j]必须初始化为一个最大的数，否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中比初始值覆盖。

所以下标非0的元素都是应该是最大值。

代码如下：

```
vector<int> dp(amount + 1, INT_MAX);
dp[0] = 0;
```

4. 确定遍历顺序

求钱币最小个数，那么钱币有顺序和没有顺序都可以，都不影响钱币的最小个数。可以用背包组合方式或者排列方式来求。

如果本题要是求组成amount的有几种方式，那么钱币循序就有影响了。

**所以两个for循环的关系是：coins放在外循环，target在内循环、或者target放在外循环，coins在内循环都是可以的！**

那么我采用coins放在外循环，target在内循环的方式。

本题钱币数量可以无限使用，那么是完全背包。所以遍历的内循环是正序

综上所述，遍历顺序为：coins放在外循环，target在内循环。且内循环正序。 


PS：**相信很多小伙伴刷题的时候面对力扣上近两千道题目，感觉无从下手**，我花费半年时间整理了Github项目：[leetcode刷题攻略](https://github.com/youngyangyang04/leetcode-master)。 里面有**100多道经典算法题目刷题顺序、配有40w字的详细图解，常用算法模板总结，以及难点视频讲解**，按照list一道一道刷就可以了！star支持一波吧！


5. 举例推导dp数组

以输入：coins = [1, 2, 5], amount = 5为例

![322.零钱兑换](https://pic.leetcode-cn.com/1612149700-EwjAXS-file_1612149700664)

dp[amount]为最终结果。

以上分析完毕，C++ 代码如下：

```
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < coins.size(); i++) { // 遍历钱币
            for (int j = coins[i]; j <= amount; j++) { // 遍历target
                if (dp[j - coins[i]] != INT_MAX) { // 如果dp[j - coins[i]]是初始值则跳过
                    dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        if (dp[amount] == INT_MAX) return -1;
        return dp[amount];
    }
};
```

## 拓展 

对于遍历方式target放在外循环，coins在内循环也是可以的，我就直接给出代码了

```C++
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, INT_MAX);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != INT_MAX ) {
                    dp[i] = min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == INT_MAX) return -1;
        return dp[amount];
    }
};
```

# 总结 

相信大家看网上的题解，一篇是遍历amount的for循环放外面，一篇是遍历amount的for循环放里面，看多了都看晕了，能把 遍历顺序讲明白的文章非常少。

这也是大多数同学学习动态规划的苦恼所在，有的时候递推公式其实很简单，但遍历顺序很难把握！

那么Carl就把遍历顺序分析的清清楚楚，相信大家看完之后，对背包问题又了更深的理解了。

> 我是程序员Carl，可以找我[组队刷题](https://img-blog.csdnimg.cn/20201115103410182.png)，「代码随想录」目前正在循序渐进讲解算法，目前已经讲到了动态规划，[点击这里](https://img-blog.csdnimg.cn/20210102121706654.png)和上万录友一起打卡学习，来看看，你一定会发现相见恨晚！

**如果感觉题解对你有帮助，不要吝啬给一个👍吧！**
