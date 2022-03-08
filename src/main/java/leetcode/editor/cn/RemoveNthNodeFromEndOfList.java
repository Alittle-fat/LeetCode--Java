//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1134 👎 0

package leetcode.editor.cn;

import java.util.List;

//Java：删除链表的倒数第N个节点
public class RemoveNthNodeFromEndOfList{
    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        ListNode d = new ListNode(4);
        ListNode c = new ListNode(3);
        c.next = d;
        ListNode b = new ListNode(2);
        b.next = c;
        ListNode a = new ListNode(1);
        a.next = b;
        solution.removeNthFromEnd(a,2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 快慢指针法在链表定位中非常有用
     */
    class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针法
        if(head == null || head.next == null){
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        //先让fast指针移动n+1次
        for(int i=0;i<n+1;i++){
            fast = fast.next;
        }

        //移动fast指向结尾的null节点,此时slow节点正好指向倒数第n+1个数

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        //移除倒数第n个数
        slow.next = slow.next.next;
        return dummyHead.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    /*
    //先反序,然后从前向后找到后删除,然后在反序输出
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head){
            return null;
        }
        head = reverse(head);
        if (n == 1){
            return reverse(head.next);
        }
        ListNode pre = head;
        int i=1;
        while(++i<n){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return reverse(head);
    }

     */


    /**
     * 链表反序
     * @return
     */
    /*
    public ListNode reverse(ListNode head){
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
     */
}