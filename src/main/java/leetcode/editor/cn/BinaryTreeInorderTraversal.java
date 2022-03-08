//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 798 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：二叉树的中序遍历
public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        // TO TEST
    }

      //Definition for a binary tree node.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root){
            return res;
        }
        if (null != root.left){
            res.addAll(inorderTraversal(root.left));
        }
        res.add(root.val);
        if (null != root.right){
            res.addAll(inorderTraversal(root.right));
        }
        return  res;

        //morris算法
        /**
         List<Integer> res = new ArrayList<Integer>();
         TreeNode predecessor = null;

         while (root != null) {
         if (root.left != null) {
         // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
         predecessor = root.left;
         while (predecessor.right != null && predecessor.right != root) {
         predecessor = predecessor.right;
         }

         // 让 predecessor 的右指针指向 root，继续遍历左子树
         if (predecessor.right == null) {
         predecessor.right = root;
         root = root.left;
         }
         // 说明左子树已经访问完了，我们需要断开链接
         else {
         res.add(root.val);
         predecessor.right = null;
         root = root.right;
         }
         }
         // 如果没有左孩子，则直接访问右孩子
         else {
         res.add(root.val);
         root = root.right;
         }
         }
         return res;
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}