//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 784 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：回文链表
public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // TO TEST
    }

     //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isPalindrome(ListNode head) {
        //常规方法,耗时耗空间
        /*List<Integer> list = new LinkedList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int l = 0,r =size-1;
        while (l<r){
            if (!list.get(l++).equals(list.get(r--))){
                return false;
            }
        }
        return true;*/

        //链表为空或者一个的时候,是回文
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = generateMid(head);
        ListNode subHead = reverse(mid);
        //遍历
        while (subHead != null) {
            if (subHead.val != head.val) {
                return false;
            }
            subHead = subHead.next;
            head = head.next;
        }
        return true;

    }
    //反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode next = cur;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //寻找中间节点,或者右中位数节点
    private ListNode generateMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}