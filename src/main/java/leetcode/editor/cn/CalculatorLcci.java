//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串 
// 👍 11 👎 0

package leetcode.editor.cn;

import java.util.Queue;
import java.util.Stack;

//Java：计算器
public class CalculatorLcci{
    public static void main(String[] args) {
        Solution solution = new CalculatorLcci().new Solution();
        // TO TEST
        solution.calculate("3+2*2*6/4 -3");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int calculate(String s) {
        return 0;
    }

    //将中缀表达式转成后缀表达式
    public String trans(String midString){
        midString = midString.replace(" ","");
        StringBuffer result =  new StringBuffer();
        Stack<Character> s = new Stack<>();
        int i = 0;
        while(i<midString.length()){

            int num = 0;
            while (Character.isDigit(midString.charAt(i))){
                num = num*10 + midString.charAt(i) -'0';
                i++;
            }
            result.append(num);

            char temp = midString.charAt(i);
            //将操作符放入栈
            switch(temp){
                case '(':
                    s.push(temp);
                    break;
                case ')':
                    while('(' != s.pop()){
                        //没写完呢
                    }
                default:
                    break;
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //简单的四则运算
    public int calculate(String s) {
        //把空字符替换掉
        if(null == s || s.length() == 0){
            return 0;
        }
        s = s.replace(" ","");
        Stack<Integer> result = new Stack<>();
        int i = 0,cal =0;
        while(i<s.length()){

            char temp = s.charAt(i);
            if(!Character.isDigit(temp)){
                i++;
            }
            int num = 0;
            while(i<s.length() && Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i) - '0';
                i++;
            }
            //            思路：
            //            1. 如果碰到数字， 则把数字入栈
            //            2. 如果碰到空格， 则继续下一步
            //            3. 如果碰到 '+' '-' '*' '/', 则查找下一个数字num
            //                &nbsp;&nbsp;&nbsp;&nbsp;A.如果是'+', 下一个数字num直接入栈
            //                &nbsp;&nbsp;&nbsp;&nbsp;B.如果是'-'，-num入栈
            //                &nbsp;&nbsp;&nbsp;&nbsp;C.如果是'\*', num = stack.pop() * num, 入栈
            //                &nbsp;&nbsp;&nbsp;&nbsp;D.如果是'/', num = stack.pop() / num, 入栈
            //            4. 最后，把栈里的数相加就是结果
            switch (temp){
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = result.pop()*num;
                    break;
                case '/':
                    num = result.pop()/num;
                    break;
                default:
                    break;
            }
            result.push(num);
        }
        while(!result.isEmpty()){
            cal += result.pop();
        }
        return  cal;
    }
}