//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 778 👎 0

package leetcode.editor.cn;


//Java：二叉树的最近公共祖先
public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q){
                return root;
            }
            TreeNode leftResult = lowestCommonAncestor(root.left,p,q);
            TreeNode rightResult = lowestCommonAncestor(root.right,p,q);
            if (null == leftResult){
                return rightResult;
            }
            if (null == rightResult){
                return leftResult;
            }
            return root;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    //自己写的,但是时间复杂度有点高
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root){
            return null;
        }
        //当前节点的左节点包含p和q,说明首个共同祖先在左节点里
        if (find(root.left,p) && find(root.left,q)){
            return lowestCommonAncestor(root.left,p,q);
        }
        //当前节点的右节点包含p和q,说明首个共同祖先在右节点里
        if (find(root.right,p) && find(root.right,q)){
            return lowestCommonAncestor(root.right,p,q);
        }
        //其他情况说明当前节点就是首个共同祖先
        return root;
    }
    //判定某个树下面是否含有指定节点p,q
    private  boolean find(TreeNode root,TreeNode p){
        if (null == root){
            return false;
        }
        if (root.val == p.val){
            return true;
        }
        return find(root.left,p) || find(root.right,p);
    }
}