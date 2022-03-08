//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 922 👎 0

package leetcode.editor.cn;
//Java：反转链表 II
public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // TO TEST
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4);
        d.next = e;
        ListNode c = new ListNode(3);
        c.next = d;
        ListNode b = new ListNode(2);
        b.next = c;
        ListNode a = new ListNode(1);
        a.next = b;
        solution.reverseBetween(e,1,1);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode();
        res.next = head;
        head = res;
        int times = right - left;
        while(left>1){
            head = head.next;
            --left;
        }
        //head 表示开始倒叙节点之前的一个节点,newEnd为开始节点,需要记录下来
        //pre表示前一个节点,now表示当前节点,next表示下一个节点

        //也可以使用插头法.简单一点
        ListNode newEnd = head.next, pre = newEnd,now = pre.next,next = now;
        while(times>0 && next != null){
            next = next.next;
            now.next = pre;
            pre = now;
            now = next;
            --times;
        }
        head.next = pre;
        newEnd.next=now;
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}