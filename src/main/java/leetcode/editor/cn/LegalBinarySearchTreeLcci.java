//实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。    
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 
// 👍 24 👎 0

package leetcode.editor.cn;


//Java：合法二叉搜索树
public class LegalBinarySearchTreeLcci{
    public static void main(String[] args) {
        Solution solution = new LegalBinarySearchTreeLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

 public class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(null == root){
            return true;
        }
        return def(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean def(TreeNode root,long min, long max){
        if(null == root){
            return true;
        }
        if(root.val <= min || root.val >=max){return false;}
        return def(root.left,min,root.val) && def(root.right,root.val,max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
    /*//中序遍历算法
    class Solution{
    long pre;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        //先设定一个比较的起始值
        pre = Long.MIN_VALUE;
        //标志,只要有一个节点不满足条件,就置为false
        flag = true;
        help(root);
        return flag;
    }
    //中序遍历,一次检查是否比前一个值大
    void help(TreeNode root) {
        if (root == null || !flag) return;
        //先遍历左边
        help(root.left);
        //比较判断当前
        if (root.val > pre)
            //prefix是之前遍历的最大值
            pre = root.val;
        else
            flag = false;
        //再遍历右边
        help(root.right);
    }
}*/

    /*//中序遍历出二叉树的所有元素,放一个list中,然后检查改list是否升序
    class Solution
    {
        public boolean isValidBST(TreeNode root)
        {
            List<Integer> list = new ArrayList<>();
            helper(root, list);
            for (int i = 0; i < list.size() - 1; i++)
            {
                if (list.get(i) < list.get(i + 1))
                {
                    return false;
                }
            }
            return true;
        }

        public void helper(TreeNode root, List<Integer> list)
        {
            if (root != null)
            {
                if (root.left != null)
                {
                    helper(root.left, list);
                }
                list.add(root.val);
                if (root.right != null)
                {
                    helper(root.right, list);
                }
            }
        }
    }*/


}