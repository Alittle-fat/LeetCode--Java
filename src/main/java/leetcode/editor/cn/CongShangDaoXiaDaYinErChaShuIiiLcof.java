//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 
// 👍 107 👎 0

package leetcode.editor.cn;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：从上到下打印二叉树 III
public class CongShangDaoXiaDaYinErChaShuIiiLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
        List<TreeNode>cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (null == root){
                return new ArrayList<List<Integer>>();
            }
            cur.add(root);
            bef(cur,1);
            return res;
        }
        public void bef(List<TreeNode> root,int flag){
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
                //偶数层倒叙
                if (flag%2 == 0){
                    Collections.reverse(temp);
                }
                res.add(temp);
                bef(next,flag+1);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}