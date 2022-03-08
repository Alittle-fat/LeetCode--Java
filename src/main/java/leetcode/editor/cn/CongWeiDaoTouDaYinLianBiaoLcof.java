//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 157 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Java：从尾到头打印链表
public class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        // TO TEST
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {

    public int[] reversePrint(ListNode head) {
        if (head == null){
            int[] a = {};
            return a;
        }
        Stack<Integer> stack = new Stack<>();

        while (head != null){
            stack.add(head.val);
            head = head.next;
        }
        int n = 0;
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()){
            res[n++] = stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}