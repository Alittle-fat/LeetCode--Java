//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 648 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：将有序数组转换为二叉搜索树
public class ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        // TO TEST
        TreeNode res = solution.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        int x;
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bef(nums,0,nums.length-1);
        /*int size = nums.length;
        if (size == 0){
            return null;
        }

        int root = size >> 1;
        TreeNode res = new TreeNode(nums[root]);
        res.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,root));
        res.right = sortedArrayToBST(Arrays.copyOfRange(nums,root + 1,size));
        return res;*/
    }

    //左右分开
    private TreeNode bef(int[] nums,int l,int r){
        if (l>r || nums == null){
            return null;
        }
        int mid  = (l+r)>>1;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = bef(nums,l,mid-1);
        res.right = bef(nums,mid+1,r);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}