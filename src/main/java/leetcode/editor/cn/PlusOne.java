//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 579 👎 0

package leetcode.editor.cn;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;

//Java：加一
public class PlusOne{
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1;i>-1;i--){
            if (digits[i]<9){
                digits[i] = digits[i]+1;
                return digits;
            }else{
                digits[i] = 0;
                continue;
            }
        }
        //此时表示数组是9999....
        //注意此处合并两个数组的方法
        int[] res = Arrays.copyOf(new int[]{1},1+digits.length);
        System.arraycopy(digits,0,res,1,digits.length);

        //也可以更简单的,新建一个数组,默认所有位置的值都是0
        int[] result = new int[digits.length+1];
        result[0] = 1;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}