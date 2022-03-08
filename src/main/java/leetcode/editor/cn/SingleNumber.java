//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1574 👎 0

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

//Java：只出现一次的数字
public class SingleNumber{
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        // TO TEST
        int x = solution.singleNumber(new int[]{4,1,2,1,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int singleNumber(int[] nums) {
        //普通方法
        /*Map<Integer,Integer> map = new HashMap(nums.length);
        for (Integer num:nums){
            map.merge(num,1,(old,n)->(old
            +1));
        }
        List<Integer> re =  new ArrayList<>();
        map.forEach((k,v)->{
            if(map.get(k) == 1){
                re.add(k);
            }
        });
        return re.get(0);*/

        //异或方法
        int single = 0;
        for(int n:nums){
            single ^= n;
        }
        return single;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}