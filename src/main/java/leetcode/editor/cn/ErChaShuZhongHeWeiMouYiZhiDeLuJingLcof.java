//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 197 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树中和为某一值的路径
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
        // TO TEST
    }
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

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            def(root,target);
            return res;
        }

        public void def(TreeNode root, int target){
            if (null == root){
                return;
            }
            path.add(root.val);
            target -= root.val;
            if(target == 0 && root.left == null && root.right == null){
                res.add(new LinkedList(path));
            }
            def(root.left,target);
            def(root.right,target);
            //移除当前节点
            path.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}