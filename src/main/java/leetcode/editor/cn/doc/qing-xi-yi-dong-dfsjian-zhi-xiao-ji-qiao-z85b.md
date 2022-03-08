思路可直接查看代码，注释已经比较清晰了
这里重点讲一下这一类题(网格，迷宫)的一个技巧，使用方向数组扩展

**方向数组**
在搜索的过程中，假设我们当前到达了b[i][j],那么此时我们需要去判断四周的四个方格是否满足条件
这时就可以使用方向数组
定义两个数组    dx代表方向的第一维，dy代表方向的第二维
```java
int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
```
使用 
```java
int x = i + dx[d], y = j + dy[d];
```
当d = 0时，(x,y)就相当于(i,j)坐标往右走了一格的坐标
同样的,当d = 1,2,3时，分别代表向下,向左,向上走一格

> 如果没有看懂，可直接看代码体会
> 如果觉得不错，可以给我一个赞，谢谢^_^

```java
class Solution {

    boolean res = false;
    int n, m, len;
    boolean[][] f;
    char[] s;
    char[][] b;

    public boolean exist(char[][] board, String word) {
        b = board;
        s = word.toCharArray();
        // 目标串的长度
        len = s.length;
        n = board.length;
        m = board[0].length;
        // 标记搜索的过程中格子是否被使用过
        f = new boolean[n][m];

        // 找到与目标串第一个字符相同的格子，开始搜索
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j < m; j ++){
                if(s[0] == board[i][j]){
                    f[i][j] = true;
                    dfs(1, i, j);
                    f[i][j] = false;
                }
                // 每次搜索后判断是否已经找到
                if(res){
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(int u, int i, int j){

        // u == len 终止条件
        // res  如果已经找到，则直接return (剪枝)
        if(u == len || res){
            res = true;
            return;
        }

        // 方向数组
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

        for(int d = 0; d < 4; d ++){
            int x = i + dx[d], y = j + dy[d];

            // 坐标越界 或者 当前格子已经被使用了  就直接结束此次循环
            if(x < 0 || y < 0 || x >= n || y >= m || f[x][y]){
                continue;
            }

            if(b[x][y] == s[u]){
                // 标记被使用
                f[x][y] = true;
                dfs(u + 1, x, y);
                // 恢复现场
                f[x][y] = false;
            }
        }

    }
}
```