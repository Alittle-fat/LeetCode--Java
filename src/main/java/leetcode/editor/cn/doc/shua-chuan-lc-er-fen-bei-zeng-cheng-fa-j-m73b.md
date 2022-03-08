
# 二分 + 倍增乘法解法

由于题目限定了我们不能使用乘法、除法和 mod 运算符。

我们可以先实现一个「倍增乘法」，然后利用对于 `x` 除以 `y`，结果 `x / y` 必然落在范围 `[0, x]` 的规律进行二分：

```java
class Solution {
    public int divide(int a, int b) {
        long x = a, y = b;
        boolean isNeg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) isNeg = true;
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long l = 0, r = x;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mul(mid, y) <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        long ans = isNeg ? -l : l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)ans;
    }
    long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) ans += a;
            k >>= 1;
            a += a;
        }
        return ans;
    }
}
```
* 时间复杂度：对 `x` 采用的是二分策略。复杂度为 *O({log n})*

* 空间复杂度：*O(1)*

***

# 总结

这道题的解法，主要涉及的模板有两个。

一个是「二分」模板，一个是「快速乘法」模板。都是高频使用的模板。

其中「二分」模板其实有两套，主要是根据 `check(mid)` 函数为 `true` 时，需要调整的是 `l` 指针还是 `r` 指针来判断。

* 当 `check(mid) == true` 调整的是 `l` 时：计算 `mid` 的方式应该为 `mid = l + r + 1 >> 1`：

```java
long l = 0, r = 1000009;
while (l < r) {
    long mid = l + r + 1 >> 1;
    if (check(mid)) {
        l = mid;
    } else {
        r = mid - 1;
    }
}
```

* 当 `check(mid) == true` 调整的是 `r` 时：计算 `mid` 的方式应该为 `mid = l + r >> 1`：

```java
long l = 0, r = 1000009;
while (l < r) {
    long mid = l + r >> 1;
    if (check(mid)) {
        r = mid;
    } else {
        l = mid + 1;
    }
}
```

另外一个是「快速乘法」模板，采用了倍增的思想：
```java
long mul(long a, long k) {
    long ans = 0;
    while (k > 0) {
        if ((k & 1) == 1) ans += a;
        k >>= 1;
        a += a;
    }
    return ans;
}
```

***

## 使用 long 的说明

评论区有小伙伴提醒三叶：**假设我们的环境只能存储 32 位有符号整数，其数值范围是 [*−2^{31}*, *2^{31} − 1*]**

我认为这个提示有两层理解含义：

1. 实现过程中完全不能使用 long
2. 实现过程不限制使用 long，只是解释为什么某些情况下需要我们返回 *2^{31}* − 1

在本题，我是按照第二种解释方式进行理解。

当然也可以按照第一种解释方式进行理解，在 [7. 整数反转(简单)](https://leetcode-cn.com/problems/reverse-integer/solution/shua-chuan-lc-bu-wan-mei-jie-fa-wan-mei-919rd/) 中，我就提供了实现过程中不使用 long 的「完美解决」方案。可以看看 ~ 

不使用 long 其实十分简单，只需要将越界判断放到循环里即可，建议你动手试试 ~ 

***

## 最后

如果有帮助到你，请给个点赞关注，让更多的人看到 ~ ("▔□▔)/

也欢迎你 [关注我](http://wechat.peterxx.com/qr_code_promote.html) ，和三叶一起刷穿 LeetCode ~ 