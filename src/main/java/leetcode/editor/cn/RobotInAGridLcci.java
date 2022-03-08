//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释: 
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角） 
//
// 说明：r 和 c 的值均不超过 100。 
// Related Topics 动态规划 
// 👍 30 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：迷路的机器人
public class RobotInAGridLcci{
    public static void main(String[] args) {
        Solution solution = new RobotInAGridLcci().new Solution();
        // TO TEST
        int[][] obstacleGrid = {{0,1,0,1,1},{0,0,1,0,1},{1,0,0,0,1},{0,1,1,1,0}};
        List<List<Integer>> ans = solution.pathWithObstacles(obstacleGrid);
        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        int[][] array;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || 0 == obstacleGrid.length){
            return res;
        }
        array = obstacleGrid;
        //行和列最大值
        int targetI = obstacleGrid.length-1;
        int targetJ = obstacleGrid[0].length-1;
        //visit记录已经访问过的节点,该方法可以极大地缩短运行时间
        boolean[][] visit = new boolean[targetI+1][targetJ+1];
        help(0,0,targetI,targetJ,visit);
        return res;
    }
    //判断当前节点能否通到末节点
    private boolean help(int i,int j,int targetI,int targetJ,boolean[][] visit){
        if (i>targetI || j>targetJ || array[i][j] != 0 || visit[i][j]){
            return false;
        }
        res.add(Arrays.asList(i,j));
        visit[i][j] = true;
        //找到了
        if (i == targetI && j == targetJ){
            return true;
        }

        //优先向下
        if(help(i+1,j,targetI,targetJ,visit) || help(i,j+1,targetI,targetJ,visit)){
            return true;
        }else{
            res.remove(res.size()-1);
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /*//优先向下
        if (i<targetI){
        if(help(i+1,j,targetI,targetJ)){
            return true;
        }else if(j<targetJ){
            if(help(i,j+1,targetI,targetJ)){
                return true;
            }else{
                res.remove(temp);
                return false;
            }
        }else {
            res.remove(temp);
            return false;
        }
    }else{
        if(help(i,j+1,targetI,targetJ)){
            return true;
        }else{
            res.remove(temp);
            return false;
        }
    }*/
}