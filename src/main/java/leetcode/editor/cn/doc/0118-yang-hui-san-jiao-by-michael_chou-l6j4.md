# 0118-杨辉三角

## 说明
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

## 示例
```
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

## 解1 数学

### 复杂度
1. 时间复杂度*O(numRows ^ 2)*, ![(1+(numRows-2))\times(numRows-2)/2 ](./p___1_+__numRows_-_2___times__numRows_-_2____2_.png) 
2. 空间复杂度O(1), 不考虑返回值的空间占用

```python
class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(numRows):
            tmp = [1] * (i + 1)
            for j in range(i + 1):
                if 0 < j < i:
                    tmp[j] = res[i - 1][j - 1] + res[i - 1][j]
            res.append(tmp)
        return res
```