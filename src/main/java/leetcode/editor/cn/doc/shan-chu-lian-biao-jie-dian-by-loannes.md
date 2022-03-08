### 解题思路
因为这里不知道`node`的上一个节点，所以无法通过`node.prev.next = node.prev.next.next`来更改指针。
拿例题来说：
`[4,5,1,9]`中我们要删除`5`，我们需要找到一个能知道目标节点的上一个节点是哪个节点的方式来解决这个问题。
* 我们知道`5`的下一个节点`1`的上一个节点是`5`。
* 将`1`赋值到`5`,变成了`[4,1,1,9]`
* 也就是说我们把本来要删除的`5`改成要删除第二个`1`。
* `node.next = node.next.next`

### 代码
```java []
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```
```python []
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next
```
