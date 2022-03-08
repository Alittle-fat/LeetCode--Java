这是一道较为简单的题目，但是有一个小陷阱。除此之外，这道题的算法是比较显然的。

#### 方法一：线性扫描 [超出时间限制]

最直接的方法是进行一次线性扫描，即对 *[1..n]* 都调用一次 `isBadVersion`。

```Java []
public int firstBadVersion(int n) {
    for (int i = 1; i < n; i++) {
        if (isBadVersion(i)) {
            return i;
        }
    }
    return n;
}
```

**复杂度分析**

* 时间复杂度：*O(n)*。在最坏的情况下，最多可能会调用 `isBadVersion` *n-1* 次，因此总的时间复杂度为 *O(n)*。
* 空间复杂度：*O(1)*。

#### 方法二：二分查找 [通过]

不难看出，这道题可以用经典的二分查找算法求解。我们通过一个例子，来说明二分查找如何在每次操作中减少一半的搜索空间，以此减少时间复杂度。

    场景一：isBadVersion(mid) => false

     1 2 3 4 5 6 7 8 9
     G G G G G G B B B       G = 正确版本，B = 错误版本
     |       |       |
    left    mid    right

场景一中，`isBadVersion(mid)` 返回 false，因此我们知道 ![\mathrm{mid} ](./p__mathrm{mid}_.png)  左侧（包括自身）的所有版本都是正确的。所以我们令 ![\mathrm{left}=\mathrm{mid}+1 ](./p__mathrm{left}=mathrm{mid}+1_.png) ，把下一次的搜索空间变为 ![\[\mathrm{mid}+1,\mathrm{right}\] ](./p___mathrm{mid}+1,mathrm{right}__.png) 。

    场景二：isBadVersion(mid) => true

     1 2 3 4 5 6 7 8 9
     G G G B B B B B B       G = 正确版本，B = 错误版本
     |       |       |
    left    mid    right

场景二中，`isBadVersion(mid)` 返回 true，因此我们知道 ![\mathrm{mid} ](./p__mathrm{mid}_.png)  右侧（不包括自身）的所有版本的不可能是第一个错误的版本。所以我们令 ![\mathrm{right}=\mathrm{mid} ](./p__mathrm{right}=mathrm{mid}_.png) ，把下一次的搜索空间变为 ![\[\mathrm{left},\mathrm{mid}\] ](./p___mathrm{left},mathrm{mid}__.png) 。

在二分查找的每次操作中，我们都用 ![\mathrm{left} ](./p__mathrm{left}_.png)  和 ![\mathrm{right} ](./p__mathrm{right}_.png)  表示搜索空间的左右边界，因此在初始化时，需要将 ![\mathrm{left} ](./p__mathrm{left}_.png)  的值设置为 1，并将 ![\mathrm{right} ](./p__mathrm{right}_.png)  的值设置为 *n*。当某一次操作后，![\mathrm{left} ](./p__mathrm{left}_.png)  和 ![\mathrm{right} ](./p__mathrm{right}_.png)  的值相等，此时它们就表示了第一个错误版本的位置。可以用数学归纳法 [证明](http://www.cs.cornell.edu/courses/cs211/2006sp/Lectures/L06-Induction/binary_search.html) 二分查找算法的正确性。

在二分查找中，选取 ![\mathrm{mid} ](./p__mathrm{mid}_.png)  的方法一般为 ![\mathrm{mid}=\lfloor\frac{1}{2}(\mathrm{left}+\mathrm{right})\rfloor ](./p__mathrm{mid}=lfloorfrac{1}{2}_mathrm{left}+mathrm{right}_rfloor_.png) 。如果使用的编程语言会有整数溢出的情况（例如 C++，Java），那么可以用 ![\mathrm{mid}=\mathrm{left}+\lfloor\frac{1}{2}(\mathrm{right}-\mathrm{left})\rfloor ](./p__mathrm{mid}=mathrm{left}+lfloorfrac{1}{2}_mathrm{right}-mathrm{left}_rfloor_.png) 代替前者。

```Java []
public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}
```

**复杂度分析**

* 时间复杂度：![O(\logn) ](./p__O_log_n__.png) 。搜索空间每次减少一半，因此时间复杂度为 ![O(\logn) ](./p__O_log_n__.png) 。
* 空间复杂度：*O(1)*。