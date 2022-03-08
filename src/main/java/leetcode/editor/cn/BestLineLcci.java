//给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。 
// 设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，则选择S[0]值较小
//的直线返回，S[0]相同则选择S[1]值较小的直线返回。 
// 示例： 
// 输入： [[0,0],[1,1],[1,0],[2,0]]
//输出： [0,2]
//解释： 所求直线穿过的3个点的编号为[0,2,3]
// 
// 提示： 
// 
// 2 <= len(Points) <= 300 
// len(Points[i]) = 2 
// 
// Related Topics 几何 哈希表 
// 👍 7 👎 0

package leetcode.editor.cn;
//Java：最佳直线
public class BestLineLcci{
    public static void main(String[] args) {
        Solution solution = new BestLineLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] bestLine(int[][] points) {
        return new int[6];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}