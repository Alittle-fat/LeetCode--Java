//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 116 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：从上到下打印二叉树 II
public class CongShangDaoXiaDaYinErChaShuIiLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
        // TO TEST
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(4);
        c.left = a;
        c.right = b;
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(2);
        g.left = c;
        g.right = d;
        TreeNode h = new TreeNode(3);
        h.left = e;
        h.right = f;
        TreeNode i = new TreeNode(4);
        i.left = g;
        i.right = h;
        solution.levelOrder(i);
    }
      public static class TreeNode {
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
    List<TreeNode>cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root){
            return new ArrayList<List<Integer>>();
        }
        cur.add(root);
        bef(cur);
        return res;
    }
    public void bef(List<TreeNode> root){
        if (null != root && root.size() != 0){
            List<TreeNode>next = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (TreeNode node:root){
                temp.add(node.val);
                if (null != node.left){
                    next.add(node.left);
                }
                if (null != node.right){
                    next.add(node.right);
                }
            }
            res.add(temp);
            bef(next);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}