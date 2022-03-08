### 解题思路
哈希公式：`hash = hash * seed + val`,其中 `seed` 是一个质数 ，`val` 是节点的值
那么，顺序哈希的结果为：
![image.png](https://pic.leetcode-cn.com/1603384923-HFpSmx-image.png)
逆序哈希的结果为：
![image.png](https://pic.leetcode-cn.com/1603384939-OvUhdV-image.png)
我们发现，逆序哈希的结果也能正序计算得出
最后比较 `hash1 == hash2`
提示：哈希过程中肯定会超出long的范围，其实无所谓，变成负数照样可以
![image.png](https://pic.leetcode-cn.com/1603385043-eUgKak-image.png)

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
    public boolean isPalindrome(ListNode head) {
        long hash1 = 0, hash2 = 0, h = 1;
        long seed = (long) (1e9 + 7);
        ListNode p = head;
        while (p != null) {
            hash1 = hash1 * seed + p.val;
            hash2 = hash2 + h * p.val;
            h *= seed;
            p = p.next;
        }
        return hash1 == hash2;
    }
}
```