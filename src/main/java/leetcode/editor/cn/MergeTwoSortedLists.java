//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1359 👎 0

package leetcode.editor.cn;
//Java：合并两个有序链表
public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // TO TEST
    }
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1 || null == l2){
            return null == l1 ? l2 : l1;
        }

        ListNode head = new ListNode(0);
        ListNode preNode = head;
        while(null != l1 && null != l2){
            if (l1.val < l2.val){
                preNode.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                preNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ?l2 : l1;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}