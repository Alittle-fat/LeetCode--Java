根据官方解题思路4: 具体根据个人喜好可选择从左下角或右上角开始
时间复杂度: O(m + n) 

## 代码:
```
    /**
    * @param {number[][]} matrix
    * @param {number} target
    * @return {boolean}
    */
    var searchMatrix = function(matrix, target) {
        let maxRow = matrix.length - 1;
        let maxCol = matrix[0].length - 1;
        let row = maxRow, col = 0;
        while(true) {
            if (row < 0 || col > maxCol) { return false; }
            if (target === matrix[row][col]) { return true; }
            target > matrix[row][col] ? col++ : row--;
        }
    };
```
