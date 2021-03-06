### 解题思路
思路描述：凑成总金额n，假设需要a个25，b个10，c个5，d个1

那么n = 25a + 10b + 5c + d

要求的就是a、b、c、d的不同取值有多少种

那么我们可以从a开始，a的可能取值是[0，n/25]

那么剩下的金额 n-25a = 10b + 5c + d = rest，

我们现在要求的是b、c、d的不同取值有多少种

我们可以知道b的取值范围是[0,rest/10]，对于每一个b的取值，我们可以算出来

c、d的不同取值有多少种，c、d的不同取值有多少种就完全取决于c的取值有多少种了，因为c的值定了之后d的值也定了

那么n-25a-10b=rest-10b=5c+d，c的取值范围为[0,rest/5 -2b]

也就是b、c、d的不同取值有![\sum_{b=0}^{rest/10}(rest/5-2b+1) ](./p__sum_{b=0}^{rest_10}_rest_5-2b_+_1__.png) 

令p=rest/5，q=rest/10，则和为(p+1)(q+1)-q(q+1)

然后将a每种取值情况下[b,c,d]不同取值的数目相加就是总的方案数
### 代码

```cpp
class Solution {
public:
    int waysToChange(int n) {
        int ans = 0;
        for (int i = 0; i <= n / 25; i ++) {
            int rest = n - i * 25;
            int p = rest / 5;
            int q = rest / 10;
            ans += (long long)(p + 1)*(q + 1) % 1000000007 - (long long)q*(q + 1)% 1000000007;
            ans %= 1000000007;
        }
        return ans;
    }
};

```
![image.png](https://pic.leetcode-cn.com/1f811a56bd304593d5653fe01f677533e80f5f0ed9e928b30ba8cbeb07435a21-image.png)

> 这道题用纯数学可能不是特别好，其实这道题是一个多重背包问题，因为每个硬币都有一个使用上限。而背包问题其实也就是利用的动态规划的思想，想熟悉背包问题的可以去看一下背包九讲

[背包九讲-崔添翼](https://anivian.github.io/pack-master/V2.pdf)

> 用f(i,v)代表前i种物品构成面值为v的方案数量，对于第i种物品，有*M_i+1*种策略：取0件，取1件....取*M_i*件，*M_i*代表该种硬币的最多数量，那么有状态转移方程
>
> ![f(i,v)=\sum_{k=0}^{M_i+1}f(i-1,v-k*C_i) ](./p__f_i,v_=_sum_{k=0}^{M_i+1}_f_i-1,_v-k*C_i__.png) ，*C_i* 是硬币面值
>
> 我们要注意一下规律
>
> *f(i,v)=f(i-1,v)+f(i,v-C_i)*，这个代入上式就可以得出了，这个不是重点，重点是这个式子什么含义，f(i-1,v)表示前i-1种物品构成面值为v的方案数量也就是不取第i种硬币；*f(i,v-C_i)* 表示前i种物品构成面值为*v-C_i*的方案数量也就是至少取了一个第i种硬币，这时候面值就变成了 *v-C_i* ，然后再分配。也是浓浓的数学思想，感觉像做排列组合题时的思想hhh。
>
> 我们现在得到状态转移方程了，然后就可以写了，但是我们注意到我们需要二维数组，我们都知道，背包问题二维数组是可以优化成一维数组的，因为除了当前行的值我们只需要f(i-1，v)也就是上一行当前位置的值，我们完全可以写成
>
> *f(v) = f(v) + f(v-C_i)*，用新的f(v)去更新旧的f(v)就好了
>
> 硬币的顺序没什么关系，倒序正序都没有影响的

```C++
class Solution {
private:
    static constexpr int mod = 1000000007;
    static constexpr int coins[4] = {25, 10, 5, 1};

public:
    int waysToChange(int n) {
        vector<int> f(n + 1);
        f[0] = 1;
        for (int c = 0; c < 4; ++c) {
            int coin = coins[c];
            for (int i = coin; i <= n; ++i) {
                f[i] = (f[i] + f[i - coin]) % mod;
            }
        }
        return f[n];
    }
};
```



