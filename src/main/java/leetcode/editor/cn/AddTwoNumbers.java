//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5367 👎 0

package leetcode.editor.cn;

import java.util.List;
import java.util.Scanner;

//Java：两数相加
public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // TO TEST
        ListNode d2 = new ListNode(9);
        ListNode c2 = new ListNode(9,d2);
        ListNode b2 = new ListNode(9,c2);
        ListNode a2 = new ListNode(9,b2);

        ListNode c1 = new ListNode(9);
        ListNode b1 = new ListNode(9,c1);
        ListNode a1 = new ListNode(9,b1);
        solution.addTwoNumbers(a1,a2);
    }
    // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 逐个想加,赋值给一个新的链表
     */
    class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        int attach = 0;
        while(null != l1 || null != l2){
            //高位不存在时,用0补齐
            int v1 = l1 == null ? 0:l1.val;
            int v2 = l2 == null ? 0:l2.val;
            int temp = v1 + v2 +attach;
            head.next = new ListNode(temp % 10);

            attach = temp >9 ? 1 : 0;
            head = head.next;
            l1 = l1 == null?null:l1.next;
            l2 = l2 == null?null:l2.next;
        }
        if (attach == 1){
            head.next = new ListNode(1);
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}