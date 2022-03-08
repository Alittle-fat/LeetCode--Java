**各位题友大家牛年好！** 今天是 **[@负雪明烛](/u/fuxuemingzhu/)** 坚持日更的第 **19** 天。今天力扣上的每日一题是「[119. 杨辉三角 II](https://leetcode-cn.com/problems/pascals-triangle-ii/)」。

# 解题思路


如果按照从上向下逐行求解，本题可以有两种空间复杂度的解法： *O(k * (k + 1) / 2)*  和 *O(k)*。下面分别介绍。


## 方法一： 空间复杂度  *O(k * (k + 1) / 2)*

该方法是常见的方法，即按照新建一个二维数组 `res[i][j]` ，数组的每一行 `res[i]` 代表了杨辉三角的第 *i* 行的所有元素， `res[i][j]` 表示杨辉三角的第 *i* 行第 *j* 列的元素。。


由下面的图我们可以看出： *res[i][j] = res[i - 1][j - 1] + res[i - 1][j]*。


![119.001.jpeg](https://pic.leetcode-cn.com/1613104353-ADGsib-119.001.jpeg)


该方法对应的 Python2 代码是：


```python
class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        res = [[1 for j in range(i + 1)] for i in range(rowIndex + 1)]
        for i in range(2, rowIndex + 1):
            for j in range(1, i):
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j]
        return res[-1]
```


## 方法二：空间复杂度 *O(k)*


题目中给了一个进阶问题，能不能用 *O(k)* 的空间复杂度呢？


其实是可以的，我们只用一个长度为 *k* 的一维数组。类似于动态规划中滚动数组的思路。


使用一维数组，然后从右向左遍历每个位置，每个位置的元素*res[j]* += 其左边的元素 *res[j - 1]*。


为啥不从左向右遍历呢？因为如果从左向右遍历，那么左边的元素已经更新为第 i 行的元素了，而右边的元素需要的是第 *i - 1* 行的元素。故从左向右遍历会破坏元素的状态。


 [119_2.gif](https://pic.leetcode-cn.com/1613104362-xmiBfu-119_2.gif)

上面动图对应的 PPT 在下面。

 ![119_2.001.jpeg](https://pic.leetcode-cn.com/1613104411-ALCNVC-119_2.001.jpeg) ![119_2.002.jpeg](https://pic.leetcode-cn.com/1613104411-GUmcIj-119_2.002.jpeg) ![119_2.003.jpeg](https://pic.leetcode-cn.com/1613104411-vvSJPj-119_2.003.jpeg) ![119_2.004.jpeg](https://pic.leetcode-cn.com/1613104411-FYDZtd-119_2.004.jpeg) ![119_2.005.jpeg](https://pic.leetcode-cn.com/1613104411-zhDvup-119_2.005.jpeg) ![119_2.006.jpeg](https://pic.leetcode-cn.com/1613104411-ftWkJL-119_2.006.jpeg) ![119_2.007.jpeg](https://pic.leetcode-cn.com/1613104411-hGgNgb-119_2.007.jpeg) ![119_2.008.jpeg](https://pic.leetcode-cn.com/1613104411-fKGNeh-119_2.008.jpeg) 



该方法对应的 Python2 代码是：

```python
class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        res = [1] * (rowIndex + 1)
        for i in range(2, rowIndex + 1):
            for j in range(i - 1, 0, -1):
                res[j] += res[j - 1]
        return res
```

上面两种方法的时间复杂度都是 *O(k ^ 2)*。


# 刷题心得



1. 本题的空间优化方式，类似于滚动数组，看来刷题的方法是通用的。
1. 本题也可以用公式求解。



OK，以上就是 [@负雪明烛](https://leetcode-cn.com/u/fuxuemingzhu/) 写的今天题解的全部内容了，如果你觉得有帮助的话，**求赞、求关注、求收藏**。如果有疑问的话，请在下面评论，我会及时解答。


**关注我**，你将不会错过我的精彩动画题解、面试题分享、组队刷题活动，进入主页 [@负雪明烛](https://leetcode-cn.com/u/fuxuemingzhu/) 右侧有刷题组织，从此刷题不再孤单。


祝大家牛年大吉！AC 多多，Offer 多多！我们明天再见！