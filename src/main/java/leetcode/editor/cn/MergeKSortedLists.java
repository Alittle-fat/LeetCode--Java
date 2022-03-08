//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 934 👎 0

package leetcode.editor.cn;
//Java：合并K个升序链表
public class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // TO TEST
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *总体思路是先写出两个链表的合并方法,然后对多个进行分治合并
     */
    class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    //这个方法是借鉴的,有点精妙
    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    //合并两个连表并返回合并后的链表
    private ListNode mergeTwo(ListNode nodeA,ListNode nodeB){
        if (nodeA == null || nodeB == null){
            return nodeA == null ? nodeB:nodeA;
        }

        ListNode headNode = new ListNode(0);
        ListNode preNode = headNode;
        while (nodeA != null && nodeB != null){
            if (nodeA.val <= nodeB.val){
                preNode.next = new ListNode(nodeA.val);
                preNode = preNode.next;
                nodeA = nodeA.next;
            }else{
                preNode.next = new ListNode(nodeB.val);
                preNode = preNode.next;
                nodeB = nodeB.next;
            }
        }
        preNode.next = nodeA == null ? nodeB:nodeA;
        return headNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}