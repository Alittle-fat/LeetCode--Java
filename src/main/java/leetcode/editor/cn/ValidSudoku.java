//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 445 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：有效的数独
public class ValidSudoku{
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *定义3个二位数组,行,列,和包,数组的i表示第几个,j表示数字,值表示第i行/列/包中是否遍历过j
     */
    class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        boolean[][] row = new boolean[size][size];
        boolean[][] col = new boolean[size][size];
        boolean[][] box = new boolean[size][size];
        for (int i = 0;i<size;++i){
            for (int j = 0;j<size;++j){
                if (board[i][j] != '.'){
                    int value = board[i][j] - '1';
                    int boxIndex = (i/3)*3 + j/3;//从左往右,从上往下,总共9个包
                    if (row[i][value] || col[j][value] || box[boxIndex][value]){
                        //该数字在所在行,所在列以及所在包中已经查询过了
                        return false;
                    }
                    //存在过了,置为true
                    row[i][value] = true;
                    col[j][value] = true;
                    box[boxIndex][value] = true;
                }
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}