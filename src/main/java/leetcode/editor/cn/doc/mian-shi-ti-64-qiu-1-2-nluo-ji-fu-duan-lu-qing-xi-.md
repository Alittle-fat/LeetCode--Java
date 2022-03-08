#### 解题思路：

本题在简单问题上做了许多限制，需要使用排除法一步步导向答案。
*1+2+...+(n-1)+n* 的计算方法主要有三种：平均计算、迭代、递归。

**方法一：** 平均计算
**问题：** 此计算必须使用 **乘除法** ，因此本方法不可取，直接排除。

```java []
public int sumNums(int n) {
    return (1 + n) * n / 2;
}
```

```python []
def sumNums(n):
    return (1 + n) * n // 2
```

**方法二：** 迭代
**问题：** 循环必须使用 *while* 或 *for* ，因此本方法不可取，直接排除。

```java []
public int sumNums(int n) {
    int res = 0;
    for(int i = 1; i <= n; i++)
        res += i;
    return res;
}
```

```python []
def sumNums(n):
    res = 0
    for i in range(1, n + 1):
        res += i
    return res
```

**方法三：** 递归
**问题：** 终止条件需要使用 *if* ，因此本方法不可取。
**思考：** 除了 *if* 和 *switch* 等判断语句外，是否有其他方法可用来终止递归？

```java []
public int sumNums(int n) {
    if(n == 1) return 1;
    n += sumNums(n - 1);
    return n;
}
```

```python []
def sumNums(n):
    if n == 1: return 1
    n += sumNums(n - 1)
    return n
```

![Picture1.png](https://pic.leetcode-cn.com/2d25bb3aec987712b717f7954d93494beb0a3e352acee486b3ce58bce60ee07c-Picture1.png)

##### 逻辑运算符的短路效应：

常见的逻辑运算符有三种，即 “与 ![\&\& ](./p__&&_.png)  ”，“或 *||* ”，“非 *!* ” ；而其有重要的短路效应，如下所示：

```java
if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false

if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
```

本题需要实现 “当 *n = 1* 时终止递归” 的需求，可通过短路效应实现。

```java
n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
```

##### 复杂度分析：

- **时间复杂度 *O(n)* ：** 计算 *n + (n-1) + ... + 2 + 1* 需要开启 *n* 个递归函数。
- **空间复杂度 *O(n)* ：** 递归深度达到 *n* ，系统使用 *O(n)* 大小的额外空间。

 ![Picture3.png](https://pic.leetcode-cn.com/fd3852f5edce37cfb51769e9218c23d9c26713f64d6fa6dae238c5056a80f0b7-Picture3.png) ![Picture4.png](https://pic.leetcode-cn.com/4370fd929b82be703265b1774c042f1786eb45fcbaeea26a93dd9f1ff39d45cd-Picture4.png) ![Picture5.png](https://pic.leetcode-cn.com/94b2c9fef8e24081e79f1392d4b28b678bb298295baf873034303cd7504cb880-Picture5.png) ![Picture6.png](https://pic.leetcode-cn.com/1b5b265b36c767797e3f28235c15df3f34266b858a81ff7738cbc1c8c7cc1685-Picture6.png) ![Picture7.png](https://pic.leetcode-cn.com/4bde4c6fa429d1678628c0043fb3dde636f08730bc7f81007411ea42cd67462e-Picture7.png) ![Picture8.png](https://pic.leetcode-cn.com/0b1afff52769f3014431e5f358cf04c356a368bb4d25ccb6c27f22f34683976e-Picture8.png) ![Picture9.png](https://pic.leetcode-cn.com/2703a0a035a2bda121d229153b7446e6d8e252a008b07d6a1072c18db70a7f4e-Picture9.png) ![Picture10.png](https://pic.leetcode-cn.com/bc008a136e3ac5c4c1ce099c28eebd2bf2c26d417c2e890ace431287812c0655-Picture10.png) ![Picture11.png](https://pic.leetcode-cn.com/475d5928ae35e4c1390fe58261bc583fe655dceece1fa69e65a44e8f4fd1f93e-Picture11.png) 

#### 代码：

1. Java 中，为构成语句，需加一个辅助布尔量 *x* ，否则会报错；
2. Java 中，开启递归函数需改写为 `sumNums(n - 1) > 0` ，此整体作为一个布尔量输出，否则会报错；
3. 初始化变量 *res* 记录结果。（ Java 可使用第二栏的简洁写法，不用借助变量 *res* ）。

```java []
class Solution {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
```

```java []
class Solution {
    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
```

```python []
class Solution:
    def __init__(self):
        self.res = 0
    def sumNums(self, n: int) -> int:
        n > 1 and self.sumNums(n - 1)
        self.res += n
        return self.res
```