//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 20 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：水域大小
public class PondSizesLcci{
    public static void main(String[] args) {
        Solution solution = new PondSizesLcci().new Solution();
        // TO TEST
        int[][] land = {{0,2,1,0},{0,0,0,1},{1,1,0,1},{0,0,0,1}};
        int[] res = solution.pondSizes(land);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int[] pondSizes(int[][] land) {
        if (null == land || land.length == 0){
            return new int[0];
        }
        int raw = land.length;
        int column = land[0].length;
        //记录已经找过的i,j的值,找过了,则land[i][j] == 1,也可以不用copy,直接在遍历过0值后,将该位置的值记为-1,下次再找,因为!=0,同样不会再记
        int[][] copy = new int[raw][column];
        //遍历数组,找到0就执行find方法,res记录每个结果的值
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<raw;i++){
            for(int j=0;j<column;j++){
                if (copy[i][j] != 1 && land[i][j] == 0){
                    res.add(find(i,j,land,copy));
                }
            }
        }
        //返回值
        int[] result = res.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }

    //搜寻当前节点附近的所有0节点(横,纵,斜)的个数
    private int find(int i,int j,int[][] land,int[][] copy){
        int count = 0;
        if (i>land.length-1 || i<0 || j>land[0].length-1 || j<0 || land[i][j] != 0 || copy[i][j] == 1){
            return count;
        }
        count++;
        copy[i][j] = 1;

        count += find(i + 1, j, land, copy);
        count += find(i + 1, j - 1, land, copy);
        count += find(i + 1, j + 1, land, copy);
        count += find(i, j + 1, land, copy);
        count += find(i, j - 1, land, copy);
        count += find(i - 1, j, land, copy);
        count += find(i - 1, j - 1, land, copy);
        count += find(i - 1, j + 1, land, copy);

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}