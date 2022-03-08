### 解题思路
二维数组的经典查找问题，每次消去1行或一列，算法复杂度O(M+N)

### 代码

```python3
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0:
            return False
        if len(matrix[0]) == 0:
            return  False
        rows = len(matrix)
        cols = len(matrix[0])
        i , j = 0 , cols-1
        while i < rows and j >= 0:
            if matrix[i][j] == target:
                return True
            elif matrix[i][j] < target:
                i += 1
            else:
                j -= 1
        return False

```