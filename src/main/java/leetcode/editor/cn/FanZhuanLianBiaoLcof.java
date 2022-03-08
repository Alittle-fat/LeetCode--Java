//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 245 👎 0

package leetcode.editor.cn;
//Java：反转链表
public class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        // TO TEST
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head,now = head.next,next = now;
        pre.next = null;
        while(next != null){
            next = next.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}