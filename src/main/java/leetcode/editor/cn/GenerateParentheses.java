//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1399 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        // TO TEST
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *只要'('的数目少于n,就迭代,注意左括号在右括号之前运行
     * 只要')'的数目少于'('的数目,就迭代
     */
    class Solution {
        int n;
        //存储结果
        List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        def(0,0,"");
        return result;
    }
        public void def(int leftNum, int rightNum, String s){
            if(leftNum ==n && rightNum == n){
                //找到符合条件的string
                result.add(s);
                return;
            }
            //只要'('的数目少于n,就迭代,注意左括号在右括号之前运行
            if(leftNum < n) {def(leftNum + 1,rightNum,s+'(');};
            //只要')'的数目少于'('的数目,就迭代
            if(rightNum < leftNum) {def(leftNum,rightNum + 1,s+')');};
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}