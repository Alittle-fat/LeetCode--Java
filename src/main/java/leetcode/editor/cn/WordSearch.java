//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 722 👎 0

package leetcode.editor.cn;

import javax.security.auth.callback.TextInputCallback;

//Java：单词搜索
public class WordSearch{
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        // TO TEST
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        Boolean res = solution.exist(board,"ABCESEEEFS");
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0;i< board.length;++i){
            for (int j=0;j<=board[0].length;++j){
                if(find(i,j,new boolean[board.length][board[0].length] ,board,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean find(int i,int j,boolean[][] pass,char[][] board,String word, int index){
        int maxI = board.length -1;
        int maxJ = board[0].length -1;
        if (i<0 || i>maxI || j<0 || j>maxJ || pass[i][j]){
            return false;
        }
        if(board[i][j] != word.charAt(index)){
            return false;
        }
        if(index == word.length() -1){
            return true;
        }

        pass[i][j] = true;
        boolean next = find(i-1,j,pass,board,word,index+1) ||
            find(i+1,j,pass,board,word,index+1) ||
            find(i,j-1,pass,board,word,index+1) ||
            find(i,j+1,pass,board,word,index+1);
        if(!next){
            //回溯
            pass[i][j] = false;
        }
        return next;
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}