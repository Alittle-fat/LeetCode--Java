//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1372 👎 0

package leetcode.editor.cn;
//Java：反转链表
public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // TO TEST
        ListNode d = new ListNode(4);
        ListNode c = new ListNode(3);
        c.next = d;
        ListNode b = new ListNode(2);
        b.next = c;
        ListNode a = new ListNode(1);
        a.next = b;
        solution.reverseList(a);
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head){
            return null;
        }
        ListNode pre = head,now = pre.next,next = now;
        head.next = null;
        while(null != now){
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}