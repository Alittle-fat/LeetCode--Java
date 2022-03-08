//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 289 👎 0

package leetcode.editor.cn;
//Java：树的子结构
public class ShuDeZiJieGouLcof{
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        // TO TEST
        TreeNode a = new TreeNode(8);
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
        boolean res = solution.isSubStructure(i,b);
        System.out.println(res);

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == B || null ==A){
            return false;
        }
        return same(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

        /**
         * 比较B是否是A的子树(同根节点)
         * @param A
         * @param B
         * @return
         */
    public boolean same(TreeNode A, TreeNode B){
        if (null == B){
            //因为b是被查找的项
            return true;
        }
        if(null == A){
            return false;
        }
        //return A.val != B.val ? false : same(A.left,B.left) && same(A.right,B.right);
        if(A.val != B.val){
            return false;
        }else{
            return same(A.left,B.left) && same(A.right,B.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}