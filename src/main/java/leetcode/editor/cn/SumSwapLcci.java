//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 排序 数组 
// 👍 11 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//Java：交换和
public class SumSwapLcci{
    public static void main(String[] args) {
        Solution solution = new SumSwapLcci().new Solution();
        // TO TEST
        int[] a = {4, 1, 2, 1, 1, 2};
        int[] b = {3, 6, 3, 3};
        solution.findSwapValues(a,b);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 找出量数组的和的差的一半,该差即为要找到的两数的差
     */
    class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum = Arrays.stream(array1).sum() - Arrays.stream(array2).sum();
        if (sum % 2 != 0){return new int[]{};}
        Set<Integer> bSet = new HashSet<>();
        bSet = Arrays.stream(array2).boxed().collect(Collectors.toSet());
        for (int x:array1){
            if (bSet.contains(x-sum/2)){
                return new int[]{x,x-sum/2};
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}