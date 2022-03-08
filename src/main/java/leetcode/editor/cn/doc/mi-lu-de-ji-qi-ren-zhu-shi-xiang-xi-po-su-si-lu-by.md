### 目标：
找到一条从左上角走到右下角路径，如果没有这样的路径返回空数组。
### 规则：
从左上角走到右下角，每次只能向下走或者向右走。

### 明确回溯法四要素：

1. 结束条件：走到右下角就结束；右下角本身有障碍物，不可能走得到；
2. 路径：走到当前位置之前已经走过的路径。
3. 选择：每次只能向下走或者向右走。当下方有障碍物时，只能考虑向右走；当右方有障碍物时，只能考虑向下走；当下方和右方都有障碍物时，只能往回走，你从哪个地方进入这个死胡同的就回到哪个地方去。
4. 约束条件：除了在“选择中的”约束之外，我们还不能走已经走过的地方。



### 代码：
以*x,y*表示当前位置，一个与网格同大小的数组*visit*记录走过的地方。
```java
class Solution {

    List<List<Integer>> path = new LinkedList<>();  // 记录路径
    int r = 0;  // 行数
    int c = 0;  // 列数
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        if (r == 0) {       // 空网格
            return path;
        }
        c = obstacleGrid[0].length;
        if (obstacleGrid[r - 1][c - 1] == 1) {  // 终点有障碍
            return path;
        }
        boolean[][] visit = new boolean[r][c];  // 记录数组
        backtrack(obstacleGrid, 0, 0, visit);
        return path;
    }

    public boolean backtrack(int[][] obstacleGrid, int x, int y, boolean[][] visit) {
        // 越界，有障碍，已访问
        if (x >= r || y >= c || obstacleGrid[x][y] == 1 || visit[x][y]) {
            return false;
        }
        // 如果不是以上情况，说明这个格子值得探索，做出选择
        path.add(Arrays.asList(x, y));
        visit[x][y] = true;
        // 选择后是否到达终点
        if (x == r - 1 && y == c - 1) {
            return true;
        }
        // 选择后没到终点，先尝试向下，再尝试向右，神奇的或运算
        if (backtrack(obstacleGrid, x + 1, y, visit) || backtrack(obstacleGrid, x, y + 1, visit)) {
            return true;
        }
        // 既不能向下也不能向右，是个死胡同，撤销选择
        path.remove(path.size() - 1);
        return false;
    }
}
```
### 算法分析：

以*r,c*分别表示网格的行和列。

1. 遍历一次网格的所有格子，每个格子仅访问一次，时间复杂度为![O(r\timesc) ](./p__O_r_times_c__.png) .
2. 不考虑递归使用栈辅助空间，辅助记录数组![O(r\timesc) ](./p__O_r_times_c__.png) ，几个变量*O(1)*，*path*链表记录路径*O(r+c-2)=O(r+c)*，因此总的空间复杂度为![O(r\timesc) ](./p__O_r_times_c__.png) .

### *path*的大小怎么算？

答：对于*r*行*c*列的网格，从左上角出发，每次只能向下或者向右走，要到达右下角，任何路径都要包括*r-1*次向下走，*c-1*次向右走。

### 如果本文对你有帮助，可以给一个大拇指呀！
![waterProblem.png](https://pic.leetcode-cn.com/37219968acfc37e0190ac2877c555b0f26041ba31707b1b150458e35ce73064a-waterProblem.png)
