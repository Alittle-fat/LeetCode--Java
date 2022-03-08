//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 479 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：重建二叉树
public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        // TO TEST
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        int[] preorder;
        HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++){
            dic.put(inorder[i], i);}
        return recur(0, 0, inorder.length - 1);
    }

        /**
         *
         * @param root 根节点在前序列表中的id
         * @param left 中序列表中某子树所有节点的左边界
         * @param right 中序列表中某子树所有节点的右边界
         * @return
         */
        TreeNode recur(int root, int left, int right) {
            if(left > right){
                return null;                          // 递归终止
            }
            TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
            int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
            node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
            node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
            return node;                                           // 回溯返回根节点
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}