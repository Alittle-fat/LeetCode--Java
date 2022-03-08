### 解题思路
- 归并排序
    - 快慢指针找到链表重点，递归处理左右两部分
    - 双指针归并排序后的左右部分
    - 当链表为空 or 链表只包含一个节点时，直接返回当前链表
- 读取->排序->放回
    - 读取所有节点的值到数组中，排序
    - 再次遍历整个链表，依次对每个节点赋值

### 代码

```python3
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # 归并排序，找到链表的中间位置，递归对两边排序
        # 使用双指针进行归并
        if head is None or head.next is None:
            return head 

        # 查找中点
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        mid, slow.next = slow.next, None

        left, right = self.sortList(head), self.sortList(mid)

        res = ListNode(0)
        p = res
        # 归并
        while left and right:
            if left.val < right.val:
                p.next = left
                left = left.next
            else:
                p.next = right
                right = right.next
            p = p.next
        p.next = left if left else right

        return res.next
```
- 读取，排序，放回
```python3
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # 归并排序，找到链表的中间位置，递归对两边排序
        # 使用双指针进行归并
        if head is None or head.next is None:
            return head 

        nums = []
        p = head
        while p:
            nums.append(p.val)
            p = p.next

        nums.sort()
        p = head
        while p:
            p.val = nums.pop(0)
            p = p.next

        return head
```