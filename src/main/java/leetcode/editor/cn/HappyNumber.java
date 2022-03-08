//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 565 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：快乐数
public class HappyNumber{
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        //循环计算的结果有3种:最终变为1;无限循环;之渐渐变大,直至无穷(排除,4 位或 4 位以上的数字在每一步都会丢失一位，直到降到 3 位为止,
        // 而3 位数的数字，它不可能大于 243)
        //所以利用set来于记录每次的计算结果,当天有重复结果时,表明进入了循环,返回false
        Set<Integer> seen = new HashSet<>();
    public boolean isHappy(int n) {
        int add = 0;
        while(n !=0){
            add += Math.pow(n%10,2);
            n /= 10;
        }
        if (seen.contains(add)){
            return false;
        }else{
            seen.add(add);
            return add ==1?true:isHappy(add);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}