# [剑指 Offer 14- II. 剪绳子 II](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/)
***
### 思路
这题再用动态规划的话惨不忍睹，还是要看贪心
核心思路是：**尽可能把绳子分成长度为3的小段，这样乘积最大**
>证明可参考[这个题解](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/)

步骤如下：
1. 如果 n == 2，返回1，如果 n == 3，返回2，两个可以合并成n小于4的时候返回n - 1
2. 如果 n == 4，返回4
3. 如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段；每次乘法操作后记得取余就行
4. 以上2和3可以合并
### 代码
```Python3 []
class Solution:
    def cuttingRope(self, n: int) -> int:
        if n < 4:
            return n - 1
        res = 1
        while n > 4:
            res = res * 3 % 1000000007
            n -= 3
        return res * n % 1000000007
```

```Java []
class Solution {
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
```

**复杂度分析**
- 时间复杂度：*O(n)*
- 空间复杂度：*O(1)*