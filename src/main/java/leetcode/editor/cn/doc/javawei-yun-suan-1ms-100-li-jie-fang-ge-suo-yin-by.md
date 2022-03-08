### 要点
**行、列、方格不能重复**

#### 如何确定第几个方格？
9 * 9 划分成 3 * 3个方格 = 9行划分成3份行格，9列也划分成3份列格。

- 9行划分成3份行格
i / 3 ，确定是第几份行格。
如，第8行，8/3 = 2，第8行属于第2份行格（起始行为第0行）

- 9列也划分成3份列格
j / 3, 确定是第几份列格。
如，第5行，5/3 = 1，第8行属于第1份行格（起始行为第0行）

- 方格索引
9 * 9 划分成 3 * 3个方格，行格下标为i / 3，列格下标为j / 3，也就是【x，y】=【i/3 , j/3】
那么处于第几个方格就可以算出来了：x * 列格数 + y = i / 3 * 3 + j / 3

### 方法一 哈希数组
> 用时：3ms，55.1%
```
class Solution {
    private final int N = 9; 
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> [] rows = new HashSet[N];
        HashSet<Integer> [] cols = new HashSet[N];
        HashSet<Integer> [] boxes = new HashSet[N];
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j  = 0; j < N; j++) {
                if (board[i][j] == '.')
                    continue;
                int tmp = board[i][j] - '0';
                if (rows[i].contains(tmp) //本行中已有数字
                    || cols[j].contains(tmp) //本列中已有数字
                    || boxes[(i / 3) * 3 + j / 3].contains(tmp)) //本方格中已有数字
                    return false;
                rows[i].add(tmp); //添加到本行
                cols[j].add(tmp); //添加到本列
                boxes[(i / 3) * 3 + j / 3].add(tmp); //添加到本方格
            }
        }
        return true;
    }
}
```



### 方法二 位运算数组

如何判断row[i] 是否已填tmp数字？
**rows[i] >> tmp & 1**

比如，i = 0， tmp = 5，判断第0行是否填了数字5？

rows[0] >> 5 & 1，将row[0] 向右移5位，那么row[0]的二进制形式的第5位处于最低位，此时再跟1进行与操作，就可以获得最低位的数字，也就是原来处于row[0]的二进制形式的第5位的数字。

如果等于1，代表已填过5。此时可以直接return false
> 用时：1ms，100%
```
class Solution {
    private final int N = 9;
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[N]; //行的位运算数组
        int[] cols = new int[N]; //列的位运算数组
        int[] boxes = new int[N]; //方格的位运算数组
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.')
                    continue;
                int tmp = board[i][j] - '0';
                int boxIndex = i / 3 * 3 + j / 3;
                if ((rows[i] >> tmp & 1) == 1 //rows[i] >> tmp & 1取出第i行的tmp数字，看是否已填，如果等于1，代表已填
                   || (cols[j] >> tmp & 1) == 1 //cols[j] >> tmp & 1取出第j列的tmp数字，看是否已填，如果等于1，代表已填
                   || (boxes[boxIndex] >> tmp & 1) == 1) //boxes[boxIndex] >> tmp & 1取出第boxIndex个方格的tmp数字，看是否已填，如果等于1，代表已填
                    return false;
                rows[i] = rows[i] | (1 << tmp); //将tmp数字加入到第i行的位运算数组
                cols[j] = cols[j] | (1 << tmp); //将tmp数字加入到第j列的位运算数组
                boxes[boxIndex] = boxes[boxIndex] | (1 << tmp); //将tmp数字加入到第boxIndex个方格的位运算数组
            }
        }
        return true;
    }
}
```
渣渣题解首献。