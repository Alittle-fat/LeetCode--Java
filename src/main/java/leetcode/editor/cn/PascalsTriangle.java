//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 460 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：杨辉三角
public class PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        // TO TEST
        List<List<Integer>> res = solution.generate(3);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*List<List<Integer>> res = new ArrayList<>();
        if (numRows == 1){
            List<Integer> preRes = new ArrayList<>();
            preRes.add(1);
            res.add(preRes);
            return res;
        }
        res.addAll(generate(--numRows));
        List<Integer>  pre = res.get(numRows-1);
        List<Integer> preRes = new ArrayList<>();
        preRes.add(1);
        for (int i=0;i<pre.size()-1;++i){
            preRes.add(pre.get(i)+pre.get(i+1));
        }
        preRes.add(1);
        res.add(preRes);
        return res;*/

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}