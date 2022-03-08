//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 308 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Java：二叉树的锯齿形层次遍历
public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        // TO TEST
    }

      //Definition for a binary tree node.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root){
            return res;
        }
        help(res, Arrays.asList(root), 1 );
        return res;

    }

    //广度优先搜索
    public void help(List<List<Integer>> res,List<TreeNode> nodes, int times ){
        if(null == nodes || nodes.size() == 0){
            return;
        }
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        int n=nodes.size();

        //顺序
        for(int i=0;i<n;++i){
            ans.add(nodes.get(i).val);
            if (null != nodes.get(i).left){
                next.add(nodes.get(i).left);
            }
            if (null != nodes.get(i).right){
                next.add(nodes.get(i).right);
            }
        }
        if (times%2 == 0){
            Collections.reverse(ans);
        }
        res.add(ans);
        help(res,next, ++times );
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}