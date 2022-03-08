//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 270 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：杨辉三角 II
public class PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex == 0){
            res.add(1);
            return res;
        }
        List<Integer> pre = getRow(rowIndex-1);
        res.add(1);
        for (int i=0;i<pre.size()-1;++i){
            res.add(pre.get(i)+pre.get(i+1));
        }
        res.add(1);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}