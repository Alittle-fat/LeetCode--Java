## 搜索二维矩阵（74）

<br/>

> 问：程序员最讨厌康熙的哪个儿子。
>
> 答：胤禩。

<br/>

今天依旧给大家分享一个面试的高频题目。话不多，来看题吧。

<br/>

## 01、题目示例

> 这道题目非常的高频！看起来是在考察矩阵搜索，其实和矩阵一点关系都没有....

<br/>

| 第74题：搜索二维矩阵                                        |
| ----------------------------------------------------------- |
| 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。 |

<br/>

该矩阵具有如下特性：

- 每行中的整数从左到右按升序排列。
- 每行的第一个整数大于前一行的最后一个整数。

<br/>

**示例 1:**

```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3

输出: true
```

**示例 2:**

```
输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13

输出: false
```

<br/>

题目本身还是比较容易理解的，没有太多额外补充。

<br/>

## 02、题解分析

>说白了，这就是一道考察二分的题目。

<br/>

最重要的是题中给出的两个条件：

<br/>

- 每行的第一个整数大于前一行的最后一个整数。

- 每行中的整数从左到右按升序排列。

  <br/>

第一个条件意味着可以通过二分搜索确定哪行；

第二个条件意味着可以在行里进行二分搜索确定哪个元素；

![图片.png](https://pic.leetcode-cn.com/15dfb1a07a7107e0b3b64eae4a5066eccb44111a6fda623666616ab0d6a332e5-%E5%9B%BE%E7%89%87.png)

如何使用二分查找找到哪行呢？只需要一个上下边界，再每次拿着中间行最大的值和目标值比一比。

```java
//java
  public int getRow(int[][] matrix, int target) {
      //二分法找到target所在的行  
      int top = 0, bottom = matrix.length - 1;
      int col = matrix[0].length - 1;
      while (top < bottom) {
          int mid = (top + bottom) / 2;
          if (matrix[mid][col] < target)
              top = mid + 1;
          else
              bottom = mid;
      }
      return top;
  }
```

找到是哪行之后，就和正常的二分查找没有什么区别了：

```java
//java
public boolean find(int[] data, int target) {
      //二分查找
      int l = 0, r = data.length - 1;
      while (l <= r) {
          int mid = (l + r) / 2;
          if (data[mid] == target)
              return true;
          else if (data[mid] < target)
              l = mid + 1;
          else
              r = mid - 1;
      }
      return false;
  }
```

然后再把代码拼凑到一起：

```java
//java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        int row = getRow(matrix, target);
        return find(matrix[row], target);
    }

    public int getRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        int col = matrix[0].length - 1;
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][col] < target)
                top = mid + 1;
            else
                bottom = mid;
        }
        return top;
    }

    public boolean find(int[] data, int target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (data[mid] == target)
                return true;
            else if (data[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}
```

## 03、小知识

> 斐波那契数列是以兔子繁殖为例子而引入的，所以又称为“兔子数列”。指的是这样一个数列：从第3项开始，每一项都等于前两项之和。

<br/>

**1，1，2，3，5，8，13，21，34，55，89，144........**

![图片.png](https://pic.leetcode-cn.com/36df35962ee67cc0e48ea929dcceed6136e0aef6f33cc06327a0d44497b9edb8-%E5%9B%BE%E7%89%87.png)

(1+1=2,2+1=3,2+3=5.....21+5+8=21+13=34)

![图片.png](https://pic.leetcode-cn.com/6e1ae1640294e1293006d6080ffb0ce97bf57d2864db339fca8c863ded1912dd-%E5%9B%BE%E7%89%87.png)

<br/>

今天的题目到这里就结束了，你学会了吗？快来评论区留下你的想法吧！
<br/>
我把我写的所有题解都整理成了一本电子书，每道题都配有完整图解。[点击即可下载](https://www.geekxh.com/0.0.%E5%AD%A6%E4%B9%A0%E9%A1%BB%E7%9F%A5/03.html?6OLy)

![image.png](https://pic.leetcode-cn.com/5d44f35119a1f7eb79bf7546a731ac9a9b945b02531c086f26d4a8c7fc7bd5a8-image.png)
