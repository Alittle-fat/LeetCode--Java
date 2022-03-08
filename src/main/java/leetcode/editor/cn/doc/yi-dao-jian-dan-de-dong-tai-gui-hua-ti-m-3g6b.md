### 解题思路
一道简单的动态规划题目。
dp[n]表示长度为n的绳子可以得到的子绳长度乘积的最大值。
### 代码

```cpp
class Solution {
public:
    int cuttingRope(int n) {
        //进行临界条件判断
        if(n<3){
            return 1;
        }
        //定义状态数组。
        vector<int>dp(n+1);
        //初始化状态数组
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=max(dp[i],dp[j]*dp[i-j]);
                dp[i]=max(dp[i],j*dp[i-j]);
                dp[i]=max(dp[i],j*(i-j));
            }
        }
        //返回答案
        return dp[n];
    }
};
```