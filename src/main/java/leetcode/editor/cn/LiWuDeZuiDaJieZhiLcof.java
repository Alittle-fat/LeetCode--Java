//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 151 👎 0

package leetcode.editor.cn;
//Java：礼物的最大价值
public class LiWuDeZuiDaJieZhiLcof{
    public static void main(String[] args) {
        Solution solution = new LiWuDeZuiDaJieZhiLcof().new Solution();
        // TO TEST
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int max = 0;
    int pre = 0;
    int row = 0;
    int column =0;
    public int maxValue(int[][] grid) {
        /*row = grid.length-1;
        column = grid[0].length-1;
        def(grid,0,0);
        return max;*/

        //超时了,可以用动态数组
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(i == 0) {
                    grid[i][j] += grid[i][j - 1] ;
                }
                else if(j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m - 1][n - 1];

    }

    public void def(int[][] grid,int i,int j){
        pre += grid[i][j];
        if (i== row && j == column){
            max = Math.max(max,pre);
        }
        if(i != row){
            def(grid, i + 1, j);
        }
        if (j != column){
            def(grid,i,j+1);
        }
        pre -= grid[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}