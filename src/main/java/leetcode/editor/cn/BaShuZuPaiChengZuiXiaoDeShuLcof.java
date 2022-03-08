//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 
// 👍 237 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：把数组排成最小的数
public class BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        // TO TEST
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        /*Integer[] newNums = new Integer[nums.length];
        for (int i =0;i<nums.length;++i){
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums,new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                StringBuilder s1 = new StringBuilder();
                String res1 = s1.append(a).append(b).toString();
                StringBuilder s2 = new StringBuilder();
                String res2 = s2.append(b).append(a).toString();
                return Integer.valueOf(res1) - Integer.valueOf(res2);
            }
        });
        StringBuilder res = new StringBuilder();
        for (Integer num:newNums){
            res.append(num);
        }
        return res.toString();*/

        //思路一样,更简单
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}