//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 311 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：存在重复元素
public class ContainsDuplicate{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int x : nums){
            if (map.containsKey(x)){
                return true;
            }
            map.put(x,1);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}