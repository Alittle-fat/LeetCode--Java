//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 923 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：子集
public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        // TO TEST
        List<List<Integer>> res = solution.subsets(new int[]{1,2,3});
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 迭代,没加一个数,实在原来的基础上在增加上新的元素
     */
    class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (null == nums || nums.length == 0){
            res.add(new LinkedList<>());
            return res;
        }
        int length = nums.length;
        int x = nums[length-1];
        List<List<Integer>> preRes = subsets(Arrays.copyOf(nums,length-1));
        //保存原来结果
        res.addAll(preRes);
        for (List<Integer> list : preRes){
            if (list.size() == 0){
                continue;
            }
            //在原来的每个元素上增加当前值形成新的元素
            List<Integer> temp = new LinkedList<>(list);
            temp.add(x);
            res.add(temp);
        }
        res.add(Arrays.asList(x));
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}