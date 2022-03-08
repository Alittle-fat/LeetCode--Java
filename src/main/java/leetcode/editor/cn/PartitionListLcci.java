//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
//分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。 
//
// 示例: 
//
// 输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
// 
// Related Topics 链表 双指针 
// 👍 25 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：分割链表
public class PartitionListLcci{
    public static void main(String[] args) {
        Solution solution = new PartitionListLcci().new Solution();
        // TO TEST
        ListNode a= new ListNode(2);
        ListNode b= new ListNode(5);
        b.next = a;
        ListNode c= new ListNode(2);
        c.next = b;
        ListNode d= new ListNode(3);
        d.next = c;
        ListNode e= new ListNode(4);
        e.next = d;
        ListNode f= new ListNode(1);
        f.next = e;
        solution.partition(f,3);
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
        //插头法,较为简单
    public ListNode partition(ListNode head, int x){
        if(null == head){
            return null;
        }

        ListNode yam = new ListNode(-1);
        yam.next = head;
        ListNode pre = head;
        head = head.next;
        while(null != head){
            if(head.val < x){
                //把比x小的全都放在链表的最前面
                pre.next = head.next;
                head.next = yam.next;
                yam.next = head;
                head = pre.next;
            }else{
                pre = pre.next;
                head = head.next;
            }
        }
        return yam.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    // 该方法较为繁琐
    List<Integer> nodeVal = new ArrayList<>();
    public ListNode partition(ListNode head, int x) {
        //把链表的值赋给list
        ListNode cur = head;
        while (null != cur){
            nodeVal.add(cur.val);
            cur = cur.next;
        }
        //对list进行分割
        for (int i = 0,j=nodeVal.size()-1;;){
            if (i>=j){
                break;
            }
            while(nodeVal.get(i) < x && i<nodeVal.size()-1){
                i++;
            }
            while(nodeVal.get(j) >= x && j>0){
                j--;
            }
            if(i<j){
                swap(i++,j--);
            }
        }
        //把排好的值赋回链表
        head = new ListNode(0);
        cur = head;
        for(int k :nodeVal){
            cur.next = new ListNode(k);
            cur = cur.next;
        }
        return head.next;
    }
    private void swap(int i, int j){
        int temp = nodeVal.get(i);
        nodeVal.set(i,nodeVal.get(j));
        nodeVal.set(j,temp);
    }
}