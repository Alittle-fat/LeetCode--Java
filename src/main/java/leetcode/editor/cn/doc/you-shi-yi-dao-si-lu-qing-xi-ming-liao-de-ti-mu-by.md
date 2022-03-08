**思路：**
1. 特判：过滤掉空链表或者单节点链表的情况，这两情况都属于回文链表;
2. 寻找中间节点，如果为偶数个节点就取右中位数位置节点为`midNode`；
3. 对`midNode`进行反转，[怎么反转还记得么？](https://leetcode-cn.com/problems/reverse-linked-list/solution/ha-ha-you-shi-shuang-zhi-zhen-fan-zhuan-lian-biao-/)，结果为`subHead`;
4. 对`head`和`subHead`进行遍历比较：
    - 如果值不相等的节点，就返回`false`;
    - 遍历结束后，说明为回文链表；

```java []
class Solution {
    public boolean isPalindrome(ListNode head) {
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
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
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
```


![微信图片_20200920111058.jpg](https://pic.leetcode-cn.com/1600676515-WOALTx-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200920111058.jpg)
