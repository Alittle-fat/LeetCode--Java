## 题目分析
本题和14 - 1主体完全一样，不过扩大了n的范围，导致了**大数越界**情况的出现。

## 解法1——动态规划
### 解法说明
尝试在动态规划的基础上取余，就算把数据类型都换成long也是无解的，对每次的dp[i]取余确实可以避免溢出的问题，但是由于过程中修改了值，会导致最终结果和预期不同。比如
这一步：
dp[i] = Math.max(dp[i] ，x * y );
x * y = 1000000005 ，若dp[i] 本该等于 1000000008 ，但是经过上次取余后变成了1，本来的结果应该是1000000008 ，现在却变成了1000000005，所以在动态规划过程中是不能取余的，**那么就只能使用BigInter存储中间结果了**

### 代码
此处代码学习自[大佬YuanbaoQiang的题解](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/jian-dan-li-jie-dong-tai-gui-hua-xun-hua-4g3o/)
``` java
import java.math.BigInteger;
class Solution {
    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
         Arrays.fill(dp, BigInteger.valueOf(1));
        // dp[1] = BigInteger.valueOf(1);
        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
```

### 结果
经典超过5%
![1.png](https://pic.leetcode-cn.com/1621999832-LwMgtT-1.png)


## 解法2——贪心 + 循环取余
### 解法说明
本题的特点是将绳子全部按照长度为3进行切割乘积结果是最大的（证明过程略过，其实贪心本来也可以不需要证明，找不出反例即可）
不过有几种情况需要注意：
(1) 在剩余长度等于4的时候，要取2 * 2，而不是3
(2) 在至少分出1段3的情况下，
剩余n = 2的时候要取2；剩余n = 1的时候要取1

### 循环取余
所谓循环取余就是每乘一次3就取次余数，为什么这种方法不会像动态规划那样影响最终结果呢，因为本题的动态规划涉及到数的比较，会出现取余后的数和取余前的数相比较的情况，自然会影响后面的结果，而贪心算法的求解过程就是简单的乘法，(100000009 % 1000000007) * 3 和 (100000009 * 3）% 1000000007的结果是一样的

### 代码
``` java
class Solution {
    public int cuttingRope(int n) {
        if(n < 3) {return 1;}
        if(n == 3) {return 2;}
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int)(n * res % 1000000007);
    }
}
```

### 复杂度分析
![2.png](https://pic.leetcode-cn.com/1621999844-GWDVuF-2.png)


时间复杂度：O(n)
空间复杂度：O(1)

## 有关int和long型数据范围的分析
(1) int型一共32位，有一位作为符号位，其数据范围是-2^31 ~ 2^31,
即-2147483648 ~ 2147483647；
近似范围可以记为-2000000000 ~ 2000000000 即 - 2 × 10^9 ~ 2 × 10^9
本题中给的模数为1  × 10^9 + 7（1000000007），若再乘以3，就超过了int型的范围，所以要使用long存储结果才不会溢出

(2) long型一共64位，对应int型的方式，long型数据范围可以简单记为：
-8 × 10^18 ~ 8 × 10^18
本题的1000000007平方小于2 × 10^18，所以用long存储模数的平方也是没有问题的