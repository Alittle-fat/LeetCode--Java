//给定两个用链表表示的整数，每个节点包含一个数位。 
// 这些数位是反向存放的，也就是个位排在链表首部。 
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 
//输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：假设这些数位是正向存放的，请再做一遍。 
//
// 示例： 
//
// 
//输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 30 👎 0

package leetcode.editor.cn;

import java.util.List;

//Java：链表求和
public class SumListsLcci{
    public static void main(String[] args) {
        Solution solution = new SumListsLcci().new Solution();
        // TO TEST
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        solution.addTwoNumbers(l1,l2);
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    //逆序较简单的方法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int car = 0;
        int sum = 0;
        while(l1 != null || l2 != null || car > 0){
            sum += car;
            sum += null == l1 ? 0 : l1.val;
            sum += null == l2 ? 0 : l2.val;
            result.next =  new ListNode(sum % 10);
            car = sum/10;

            //下一个循环
            if (l1 != null){l1 = l1.next;}
            if (l2 != null){l2 = l2.next;}
            sum = 0;
            result = result.next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //链表的逆序方法
    private ListNode reverse(ListNode l1){
        if(null == l1 || null == l1.next){
            return l1;
        }
        ListNode p = new ListNode(l1.val),q = l1.next,temp;
        while(q != null){
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    //自己所写,有一点繁琐
    /*class Solution {
        ListNode head = new ListNode(0);
        ListNode result = new ListNode(0);
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            add(l1,l2,head);
            cal(head.next,result,0);
            return result.next;
        }

        private void add(ListNode l1, ListNode l2,ListNode head){
            if (null == l1 && null == l2){
                return;
            }
            if (null == l1 && null != l2){
                head.next = l2;
            }
            if(null != l1 && null == l2){
                head.next = l1;
            }
            if(null != l1 && null != l2){
                head.next = new ListNode(l1.val + l2.val);
                add(l1.next,l2.next,head.next);
            }
        }

        private void cal(ListNode l1,ListNode result,int index){
            if (null == l1) {
                if(index == 0){
                    return;
                }else{
                    result.next = new ListNode(1);
                    return;
                }
            }
            int flag = l1.val + index;
            result.next = new ListNode(flag >= 10? flag -10 : flag);
            cal(l1.next,result.next,flag >=10 ?1 : 0);
        }
    }*/
}