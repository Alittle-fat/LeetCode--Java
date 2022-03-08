//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
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
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 169 👎 0

package leetcode.editor.cn;
//Java：二叉搜索树的第k大节点
public class ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
        int time = 0;
        int res = 0;
    public int kthLargest(TreeNode root, int k) {
       findNums(root,k);
       return res;
    }
    //后序遍历
    public void findNums(TreeNode root,int k){
        if (null == root){
            return;
        }
        findNums(root.right,k);
        ++time;
        if(time == k){
            res = root.val;
        }else{
            findNums(root.left,k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}