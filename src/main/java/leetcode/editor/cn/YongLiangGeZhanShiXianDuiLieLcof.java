//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 244 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：用两个栈实现队列
public class YongLiangGeZhanShiXianDuiLieLcof{
    public static void main(String[] args) {
        //Solution solution = new YongLiangGeZhanShiXianDuiLieLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class CQueue {
        Stack<Integer> stackA;
        Stack<Integer> stackB;

    public CQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    public void appendTail(int value) {
        stackA.add(value);
    }
    
    public int deleteHead() {
        //将A中元素转移到B
        if (stackA.isEmpty()){
            return -1;
        }
        while(!stackA.isEmpty()){
            stackB.add(stackA.pop());
        }
        int res = stackB.pop();
        while(!stackB.isEmpty()){
            stackA.add(stackB.pop());
        }
        return res;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}