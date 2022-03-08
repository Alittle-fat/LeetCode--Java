//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 301 👎 0

package leetcode.editor.cn;
//Java：机器人的运动范围
public class JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        // TO TEST
        int res  = solution.movingCount(1,2,1);
        res += 1;
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int row,column,limit;
    public int movingCount(int m, int n, int k) {
        row = m;
        column = n;
        limit = k;
        boolean[][] mark = new boolean[m][n];
        return movingCountStar(0,0,mark);
    }

        /**
         * 从i,j位置计算的值
         * @param i
         * @param j
         * @return
         */
    public int movingCountStar(int i,int j,boolean[][] mark){
        if(i<0 || i>row -1 || j<0 || j>column-1 || mark[i][j] || countNums(i)+countNums(j)>limit){
            return 0;
        }
        mark[i][j] = true;
        //只需向右和向下搜索就行
        return movingCountStar(i+1,j,mark) + movingCountStar(i,j+1,mark) +1;
    }

    //计算数字各位之和
    public int countNums(int x){
        int res = 0;
        while(x != 0){
            res += x%10;
            x /=10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}