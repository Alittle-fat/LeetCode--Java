### 解题思路
要求行,列,方块种不能有重复的数字, 所以采用boolean二维数组保存
拿`boolean[][] rows`来举例
1. `row`标识对应的 `行`
2. `col`标识出现的 `数字`
3. `value`标识是否出现
![95.png](https://pic.leetcode-cn.com/b0aa9a4abbcdbdebbbd02d597cb0812f2018db82fde897aec795192a9d1bcd90-95.png)


### 代码

```java
class Solution {
    private final int L = 9;
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[L][L];
        boolean[][] cols = new boolean[L][L];
        boolean[][] boxes = new boolean[L][L];

        for (int r = 0; r < L; ++r) {
            for (int c = 0; c < L; ++c) {
                if (board[r][c] != '.') {
                    int value = board[r][c] - '1';
                    int boxIndex = r / 3 * 3 + c / 3;
                    if (rows[r][value] || cols[c][value] || boxes[boxIndex][value]) {
                        return false;
                    } 
                    rows[r][value] = true;
                    cols[c][value] = true;
                    boxes[boxIndex][value] = true;
                }
            }
        }
        return true;
    }
}
```