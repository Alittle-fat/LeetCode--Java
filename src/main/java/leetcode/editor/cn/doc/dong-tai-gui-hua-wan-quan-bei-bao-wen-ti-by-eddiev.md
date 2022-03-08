#### 动态规划解法：完全背包问题
*完全背包问题即不限定硬币的个数地去组合硬币达到指定的值。*

这道题为求组合成指定数额有几种情况，我们设置 `dp` 数组：
`dp[k]` 为组成k面额的硬币情况数。
```java []
int[] dp = new int[n + 1];
```
设置基本情况：
```java []
dp[0] = 1;
```
这里的 `dp[0]` 的含义是：组成0的硬币种类数为 1，（没有硬币也是一种情况）
可以用于边界判断，作为完美能被一个硬币表示的情况为 1。即：

```java []
while k - coin == 0 :
	dp[k] += dp[k - coin];
	=>
	dp[k] += dp[0];
```

我们可以简单地得出对应的 `dp` 方程：
```java []
for(int coin: coins) {
	dp[k] += dp[k - coin];
}
由于题意中要求对 1000000007求余。
则：
for(int coin: coins) {
	dp[k] = (dp[k] + dp[k - coin]) % 1000000007;
}
```

#### 错误答案：(👀看清楚了铁子们，是错的)
接下来好像已经得出了答案，可以轻松写出代码了，但是这个答案是**错的**！
```java []
class Solution {
    public int waysToChange(int n) {
        
        int[] dp = new int[n + 1];
        
        int[] coins = new int[]{1,5,10,25};
        
        
        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;
        
        /**
        * dp方程：dp[i] += dp[i - coin];
        */
        
        for(int i = 1; i <= n; i++) {
            for(int coin: coins) {
                if(i - coin < 0) break;
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        
        return dp[n];
    }
}
```
代码好像没问题，但是我们求6的硬币情况数时，我们观察一下流程：

```java []
前面5种情况数：dp[1,5] = [1,1,1,1,2];

coin = 1:
dp[6] += (dp[6 - coin] => dp[5] => 2);
即拿到coin(1)的情况有两种 :
	coin(1,1,1,1,1) + coin(1);
	coin(5) + coin(1);
	
coin = 5:
dp[6] += (dp[6 - coin] => dp[1] => 1);
即拿到coin（5）的情况有一种:
	coin(1) + coin(5);
```
但是事实却是 6 的情况只有两种，（1，1，1，1，1，1）和（1，5）。这里是把（1，5）和（5，1）前后顺序不同的情况重复算了 1 次。因此我们应该去考虑硬币顺序带来的影响。

##### 改进后：
#### 正确答案：
于是我们先遍历硬币，保证在考虑一枚硬币的情况时，没有较大的硬币影响，这样，我们最终每种组合情况，都是以硬币的面额大小非递减组合。保证了同样的情况，调换顺序后重复计算的情况。

这时候，我们求6的硬币情况数时，我们观察一下流程：

```java
coin = 1:
前面5种情况数：dp[1,5] = [1,1,1,1,1];

dp[6] += (dp[6 - coin] => dp[5] => 1);
即拿到coin(1)的情况有一种 :
	coin(1,1,1,1,1) + coin(1);
	
coin = 5:
前面5种情况数：dp[1,5] = [1,1,1,1,2];

dp[6] += (dp[6 - coin] => dp[1] => 1);
即拿到coin（5）的情况有一种:
	coin(1) + coin(5);
```
此时，硬币组合情况，的确为正确的情况。

```java []
class Solution {
    public int waysToChange(int n) {
        
        int[] dp = new int[n + 1];
        
        int[] coins = new int[]{1,5,10,25};
        
        
        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;
        
        /**
        * dp方程：dp[i] += dp[i - coin];
        */
        
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        
        return dp[n];
    }
}
```
```python3 []
class Solution:
    def waysToChange(self, n: int) -> int:
        coins = [1, 5, 10, 25]
        dp = [0] * (n + 1) 
        dp[0] = 1
        for coin in coins :
            for i in range(coin, n + 1) :
                dp[i] = (dp[i] + dp[i - coin])

        return dp[n] % 1000000007
```
