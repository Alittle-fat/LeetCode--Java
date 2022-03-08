//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
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
// 👍 100 👎 0

package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Java：从上到下打印二叉树
public class CongShangDaoXiaDaYinErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        // TO TEST
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

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        List<Integer> res;
        Queue<TreeNode> queue = new LinkedList<>();
        public int[] levelOrder(TreeNode root) {
            if(null == root){
                return new int[]{};
            }
            res = new ArrayList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                res.add(node.val);
                if (null != node.left){
                    queue.add(node.left);
                }
                if (null != node.right){
                    queue.add(node.right);
                }
            }
            int[] result = new int[res.size()];
            for (int i=0;i<res.size();++i){
                result[i] = res.get(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}