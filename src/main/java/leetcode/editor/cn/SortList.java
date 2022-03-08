//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1062 👎 0

package leetcode.editor.cn;
//Java：排序链表
public class SortList{
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        // TO TEST
        ListNode d = new ListNode(3);
        ListNode c = new ListNode(1,d);
        ListNode b = new ListNode(2,c);
        ListNode a = new ListNode(4,b);
        solution.sortList(a);

    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 归并排序
     */
    class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //快慢指针找到中点,奇数个节点找到中点，偶数个节点找到中心左边的节点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        //合并链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;

        //可以实现,但是时间复杂度太高
        /*ListNode first = new ListNode();
        first.next = head;
        ListNode index = first;
        while(index!=null && index.next!= null) {
            boolean flag = false;
            ListNode pre = index;
            head = index.next;
            ListNode next;
            while (head != null && head.next != null) {
                next = head.next;
                if (head.val > next.val) {
                    //交换
                    pre.next = head.next;
                    head.next = next.next;
                    next.next = head;
                    flag = true;
                }
                pre = head;
                head = next;
            }
            if (!flag){
                break;
            }
        }
        return first.next;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}