题目说明：判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

    - 数字 1-9 在每一行只能出现一次。
    - 数字 1-9 在每一列只能出现一次。
    - 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次


思路：在遍历到每一个位置的时候board[i][j]，我们要判断其是否满足三个条件：

    1. board[i][j]在第 i 个行中是否出现过
    2. board[i][j]在第 j 个列中是否出现过
    3. 在第 j/3 + (i/3)/*3个box中是否出现过

我们不用哈希表也是可以做的，**只要记录board[i][j]这个位置的数在变量row或col或box相应的位置是否出现过就可以了**具体参考下图，下图只是说明了一行的row[0][j]的变化过程。当然列和包都是一样的，行看明白了就都解决了
![36.png](https://pic.leetcode-cn.com/b4d04d2391e06ca2e053ef4444041dfc10e4fc0e7dcb751c940eb5383a77358d-36.png)

时间复杂度O(1)
空间复杂度O(1)

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size=board.length;
        boolean [][] row=new boolean[size][size];
        boolean [][] col=new boolean[size][size];
        boolean [][] box=new boolean[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!='.'){
                    int tem=board[i][j]-'1';          //取出当前位置的数并转化成 row、col和box的相应位置
                    int boxes=(i / 3 ) * 3 + j / 3;   //判断当前位置所在的包,是当前的位置，不是那个tem值所在的包
                    if(row[i][tem] || col[j][tem] || box[boxes][tem])
                        return false;
                    row[i][tem]=true;                 //标记row、col和box的相应位置已经访问过了
                    col[j][tem]=true;
                    box[boxes][tem]=true;

                }
            }
        }
        return true;
    }
}
```


本题是leetcode初级算法 ![\cdot ](./p__cdot_.png)  数组章的题目，在这里你可以看到其他章节的内容[传送门](https://github.com/hgsw/leetcode-PrimaryAlgorithm)，和我一起打卡leetcode提供其他优秀的思路吧，本人只是记录了该题最常见的解法并提供了解题提示。
- **初级算法 ![\cdot ](./p__cdot_.png)  数组章题目**
- [26 删除排序数组的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/26-shan-chu-pai-xu-shu-zu-de-zhong-fu-yuan-su-by-w/)(双指针)
- [122 买卖股票的最佳时机2](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/122mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-wulin-v/)(遍历)
- [189 旋转数组](https://leetcode-cn.com/problems/rotate-array/solution/189-xuan-zhuan-shu-zu-by-wulin-v/)(暴力法)
- [217 存在重复的元素](https://leetcode-cn.com/problems/contains-duplicate/solution/217-cun-zai-zhong-fu-yuan-su-1-by-wulin-v/)(set去重)
- [136 只出现一次的数](https://leetcode-cn.com/problems/single-number/solution/136-zhi-chu-xian-yi-ci-de-shu-by-wulin-v/)(set去重)
- [350 两个数组的交集2](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/350-liang-ge-shu-zu-de-jiao-ji-2-by-wulin-v/)(map查找表)
- [66 加一](https://leetcode-cn.com/problems/plus-one/solution/66jia-yi-by-wulin-v/)(遍历)
- [283 移动零](https://leetcode-cn.com/problems/move-zeroes/solution/283-yi-dong-ling-by-wulin-v/)(双指针)
- [1 两数之和](https://leetcode-cn.com/problems/two-sum/solution/1-liang-shu-zhi-he-by-wulin-v/)(map查找表)
- [35 有效的数独](https://leetcode-cn.com/problems/valid-sudoku/solution/36-you-xiao-de-shu-du-by-wulin-v/)(查找表)
- [48 旋转图像](https://leetcode-cn.com/problems/rotate-image/solution/48xuan-zhuan-tu-xiang-by-wulin-v/)(由外向内)

