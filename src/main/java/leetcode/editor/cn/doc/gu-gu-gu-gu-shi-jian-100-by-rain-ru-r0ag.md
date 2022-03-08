### 解题思路
假如青蛙跳到了第n(n >= 2)节台阶上，那么他**只可能是从n - 1节台阶 和 n - 2节台阶**上跳上去了，所以也就有了跟斐波那契数列差不多公式：

- F(0) = F(1) = 1;
- F(N) = F(N - 1) + (N - 2)，N >= 2

![image.png](https://pic.leetcode-cn.com/1620558098-lsOcPW-image.png)

### 代码

```java
class Solution {
    public int numWays(int n) {
        if(n < 2) return 1;
        long[] result = new long[n + 1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <= n; i++){
            result[i] = result[i - 1] + result[i - 2];
            result[i] %= (Math.pow(10,9) +7);
        }
        return (int)result[n];
    }
}
```