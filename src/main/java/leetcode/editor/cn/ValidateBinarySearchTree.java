//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 846 👎 0

package leetcode.editor.cn;
//Java：验证二叉搜索树
public class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
        TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        //中序遍历法
        /*if (null == root){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        //比较当前节点与前一个节点
        if (prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        //访问右子树
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;*/

        //递归法
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null)
            {return true;}
            if(root.val >= maxVal || root.val <= minVal){
                return false;
            }
            return isValidBST(root.left,minVal,root.val) && isValidBST(root.right,root.val,maxVal);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}