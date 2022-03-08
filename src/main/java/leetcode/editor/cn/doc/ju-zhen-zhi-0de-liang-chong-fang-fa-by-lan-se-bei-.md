## 方法一
思路：用两个set分别记录需要置0的行和需要置0的列。第一次遍历矩阵时，若发现一个元素为0，则将其行和列值分别加入到两个set中。第二次遍历矩阵时，将行set中的行全部置0，将列set中的列全部置0。

```java
public void setZeroes(int[][] matrix) {
    if(matrix == null || matrix.length == 0)
        return;
    int m = matrix.length, n = matrix[0].length;
    Set<Integer> row = new HashSet<Integer>();
    Set<Integer> col = new HashSet<Integer>();
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(matrix[i][j] == 0){
                row.add(i);
                col.add(j);
            }
        }
    }
    for(int i : row){
        for(int j = 0; j < n; j++)
            matrix[i][j] = 0;
    }
    for(int j : col){
        for(int i = 0; i < m; i++)
            matrix[i][j] = 0;
    }
}
```

* 时间复杂度：*O(m × n)*
* 空间复杂度：*O(m + n)*  最坏情况是矩阵中全部元素为0的情况，这时两个set的大小分别为m和n。

## 方法二
思路：不用额外空间，让首行和首列记录某列和某行是否有0

算法步骤：
1. 首先用两个布尔类型变量*firstRow*和*firstCol*分别记录矩阵的首行和首列中是否有0
2. 遍历除首行和首列外的所有元素，若元素matrix[i][j]为0，则将它对应的首行和首列中的元素*matrix[i][0]*和*matrix[0][j]*置为0，意为此行和列后续需要被置0（由于修改后首行和首列是否有0的信息会被破坏掉，因此需要有之前的步骤一）
3. 遍历首行和首列，若发现首行中有元素为0，则将此元素所处的列全部置0，若发现首列中有元素为0，则将此元素所处的行全部置0。
4. 根据步骤一的布尔类型变量*firstRow*和*firstCol*来判断首行和首列是否需要被置0。

```java
public void setZeroes(int[][] matrix) {
    if(matrix == null || matrix.length == 0)
        return;
    int m = matrix.length, n = matrix[0].length;
    boolean firstRow = false, firstCol = false;
    //步骤一
    for(int i = 0; i < m; i++){
        if(matrix[i][0] == 0)
            firstCol = true;
    }
    for(int j = 0; j < n; j++){
        if(matrix[0][j] == 0)
            firstRow = true;
    }
    //步骤二
    for(int i = 1; i < m; i++){
        for(int j = 1; j < n; j++){
            if(matrix[i][j] == 0){
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    //步骤三
    for(int i = 1; i < m; i++){
        if(matrix[i][0] == 0){
            for(int j = 0; j < n; j++)
                matrix[i][j] = 0;
        }
    }
    for(int j = 1; j < n; j++){
        if(matrix[0][j] == 0){
            for(int i = 0; i < m; i++)
                matrix[i][j] = 0;
        }
    }
    //步骤四
    if(firstRow){
        for(int j = 0; j < n; j++)
            matrix[0][j] = 0;
    }
    if(firstCol){
        for(int i = 0; i < m; i++)
            matrix[i][0] = 0;
    }
}
```

* 时间复杂度：*O(m × n)*
* 空间复杂度：*O(1)*

---
若您觉得本题解对您有所帮助，欢迎关注[我的github仓库](https://github.com/wyh317/Leetcode)访问更多leetcode题解，期待和小伙伴们一起交流讨论！