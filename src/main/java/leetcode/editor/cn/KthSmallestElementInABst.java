//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找 
// 👍 327 👎 0

package leetcode.editor.cn;

import java.util.Collections;
import java.util.PriorityQueue;

//Java：二叉搜索树中第K小的元素
public class KthSmallestElementInABst{
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
        // TO TEST
    }

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        //用优先队列(堆排序),记得是倒序
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    public int kthSmallest(TreeNode root, int k) {
        //用堆排序
        depFind(root,k);
        return queue.remove();

        //思考:其实是不是可以遍历k个元素就可以了?因为这是二叉搜索树,遵循左<中<右的原则

    }
    public void depFind(TreeNode root, int k){
        if (null == root){
            return;
        }
        depFind(root.left,k);
        if (queue.size() == k && root.val > queue.peek()){
            return;
        }
        queue.add(root.val);
        if (queue.size() > k){
            queue.remove();
        }
        depFind(root.right,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}