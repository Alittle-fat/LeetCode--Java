//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 338 👎 0

package leetcode.editor.cn;
//Java：矩阵中的路径
public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0;i < board.length;i++){
                for(int j = 0; j < board[0].length;j++){
                    if(dfs(board,words,i,j,0)){
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][]board,char[] word,int i,int j,int k){
            if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || word[k] != board[i][j]){
                return false;
            }
            if(k == word.length - 1){
                return true;
            }
            //本次不可重复的标记点
            board[i][j] = '\0';
            boolean res = dfs(board,word,i + 1,j,k + 1) || dfs(board,word,i,j + 1,k + 1)
                || dfs(board,word,i - 1,j,k + 1) || dfs(board,word,i,j - 1,k + 1);
            //判断结束还得回溯,进行下一次判断
            board[i][j] = word[k];
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}