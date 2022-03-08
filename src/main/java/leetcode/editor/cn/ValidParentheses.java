//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1899 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Java：有效的括号
public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        // TO TEST
        solution.isValid("()");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean isValid(String s) {
            //1.特判
            if(s.isEmpty()) {return true;}
            //2.创建辅助栈
            Stack<Character> stack = new Stack<>();
            //3.遍历
            for(char c : s.toCharArray()){
                if(c == '('){
                    stack.push(')');
                }else if(c == '['){
                    stack.push(']');
                }else if(c == '{'){
                    stack.push('}');
                }else if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
            //4.返回
            return stack.isEmpty();
        }
    }


//leetcode submit region end(Prohibit modification and deletion)
    //自己写的,较为复杂
    public boolean isValid(String s)
    {
        if (null == s || s.length() == 0)
        {
            return true;
        }
        Map<Character, Integer> map = new HashMap();
        Map<Character, Character> fitMap = new HashMap<>();
        map.put('{', 0);
        map.put('[', 0);
        map.put('(', 0);
        map.put('}', 1);
        map.put(']', 1);
        map.put(')', 1);
        fitMap.put('}', '{');
        fitMap.put(']', '[');
        fitMap.put(')', '(');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.get(c) == 0) {
                stack.push(c);
                continue;
            }
            if (map.get(c) == 1) {
                if (!stack.isEmpty() && fitMap.get(c).equals(stack.pop())) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}