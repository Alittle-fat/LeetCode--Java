//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 126 👎 0

package leetcode.editor.cn;
//Java：合并两个排序的链表
public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        // TO TEST
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1),res =head;
            while(l1 != null && l2 != null){
                if(l1.val<=l2.val){
                    res.next = l1;
                    l1 = l1.next;
                }else{
                    res.next = l2;
                    l2 = l2.next;
                }
                res = res.next;
            }
            res.next = l1 == null ? l2 : l1;
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}