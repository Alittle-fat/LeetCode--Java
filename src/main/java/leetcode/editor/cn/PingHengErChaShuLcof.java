//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 162 👎 0

package leetcode.editor.cn;
//Java：平衡二叉树
public class PingHengErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
        // TO TEST
    }
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBalanced(TreeNode root) {
        /*if (null == root){
            return true;
        }
        //先判断当前节点的左右节点的深度差是否在1以内
        //然后在判断左右子节点
        return Math.abs(maxDepth(root.left) - maxDepth(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);*/


        //剪枝
        return recur(root) != -1;
    }

        /**
         * 计算树的深度
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if(null == root){
                return 0;
            }
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }

        //剪枝
        private int recur(TreeNode root) {
            if (root == null) {return 0;}
            int left = recur(root.left);
            if(left == -1) {return -1;}
            int right = recur(root.right);
            if(right == -1) {return -1;}
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}