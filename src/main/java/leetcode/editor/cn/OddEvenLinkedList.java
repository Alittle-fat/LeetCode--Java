//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。 
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
// Related Topics 链表 
// 👍 352 👎 0

package leetcode.editor.cn;
//Java：奇偶链表
public class OddEvenLinkedList{
    public static void main(String[] args) {
        Solution solution = new OddEvenLinkedList().new Solution();
        // TO TEST
        ListNode d2 = new ListNode(4);
        ListNode c2 = new ListNode(3,d2);
        ListNode b2 = new ListNode(2,c2);
        ListNode a2 = new ListNode(1,b2);
        solution.oddEvenList(a2);
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
     *
     */
    class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode cutPoint = head,pre = head;
        int times = 1;
        while(pre != null){
            //在循环条件中的times++,就算不符合条件,times也会自增1,一定要注意
            if ( times % 2 == 0 && pre.next != null){
                ListNode temp = pre.next;
                pre.next = temp.next;
                temp.next = cutPoint.next;
                cutPoint.next = temp;

                cutPoint = cutPoint.next;
                ++times;
            }
            //注意这两个要放在if条件的外面
            ++times;
            pre = pre.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}