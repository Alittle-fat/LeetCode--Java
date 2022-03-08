//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
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
// Related Topics 树 广度优先搜索 
// 👍 710 👎 0

package leetcode.editor.cn;


import java.util.*;

//Java：二叉树的层序遍历
public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            //size的作用是确定当前层的个数
            int size = queue.size();
            List<Integer> perList = new ArrayList<>();
            //弹出size个元素,同时判断每个元素是否有子节点,有的话再添加到队列中,作为访问的下一层
            while (size-- > 0){
                TreeNode temp = queue.poll();
                perList.add(temp.val);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(perList);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}