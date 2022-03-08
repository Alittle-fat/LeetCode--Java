//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 904 👎 0

package leetcode.editor.cn;
//Java：岛屿数量
public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'}, {'1','1','1'}};
        int res = solution.numIslands(grid);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int maxI = grid.length;
        int maxJ = grid[0].length;
        boolean[][] pass = new boolean[maxI][maxJ];
        for (int i=0;i<maxI;++i){
            for (int j=0;j<maxJ;++j){
                int x = depFind(i,j,grid,pass);
                if (x>0){
                    ++res;
                }
            }
        }
        return res;
    }
    //计算从[i][j]位置开始相连的1的数量
    private int depFind(int i,int j,char[][] grid, boolean[][] pass){
        int maxI = grid.length;
        int maxJ = grid[0].length;
        int count = 0;
        while(i>=0 && i< maxI && j>=0 && j< maxJ && !pass[i][j] && grid[i][j] == '1'){
            //此处可以不用额外空间,而是直接在原数字上进行操作,修改它的值,标记为已经遍历过的
            pass[i][j] = true;
            ++count;
            count += depFind(i+1,j,grid,pass);
            count += depFind(i,j+1,grid,pass);
            count += depFind(i-1,j,grid,pass);
            count += depFind(i,j-1,grid,pass);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}