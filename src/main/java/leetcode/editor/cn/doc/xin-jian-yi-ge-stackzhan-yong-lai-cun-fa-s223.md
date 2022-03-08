### 解题思路
1. 创建Stack用作存放容器
2. 读取链表，将链表的值一次存入Stack中
3. 链表读取完毕，将链表中的值再转移到数组中
4. 返回数组
5. 提交代码

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   public int[] reversePrint(ListNode head) {
        if (head == null){
            int[] a = {};
            return a;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null){
            stack.add(p.val);
            p = p.next;
        }
        int n = 0;
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()){
            res[n++] = stack.pop();
        }
        return res;
    }
}
```