//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 490 👎 0

package leetcode.editor.cn;

import java.util.List;

//Java：移除链表元素
public class RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        // TO TEST
    }

     //Definition for singly-linked list.
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = head,now = head;
        while (null != now){
            while(null != now && now.val != val){
                pre = now;
                now = now.next;
            }
            if (now == head){
                head = head.next;
                pre = head;
                now = head;
            }else if(null != now){
                pre.next = now.next;
                now = now.next;
            }
        }
        return head;

        //法2:创建一个虚拟头结点
        /*
        //创建一个虚拟头结点
        ListNode dummyNode=new ListNode(val-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyNode.next;
         */

        //法3:递归
        /*
        if(head==null)
           return null;
        head.next=removeElements(head.next,val);
        if(head.val==val){
            return head.next;
        }else{
            return head;
        }
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}