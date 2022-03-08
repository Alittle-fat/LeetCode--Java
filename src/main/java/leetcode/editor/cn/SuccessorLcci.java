//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 
// 👍 26 👎 0

package leetcode.editor.cn;

import java.util.Stack;

//Java：后继者
public class SuccessorLcci{
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
        // TO TEST
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node2.left =node1;
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        node3.left = node2;
        node3.right = node4;
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        node5.left = node3;
        node5.right = node6;

        TreeNode p = new TreeNode(6);
        TreeNode re = solution.inorderSuccessor(node5,p);
        System.out.println(re.val);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode temp = p.right;
        //如果p的右节点存在,则下一个节点就在p的右支中
        if (null != temp){
            while(temp.left != null){
                temp = temp.left;
            }
            return temp;
        }

        //右节点不存在,则后继着一定在根节点到p节点的路径上
        Stack<TreeNode> stack = new Stack<>();
        while(null != root && root.val != p.val){
            stack.push(root);
            if(root.val>p.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        //找到第一个大于p节点的值,就是下一个值
        while(!stack.isEmpty()){
            temp = stack.pop();
            if (temp.val>p.val){
                return temp;
            }
        }
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    //不对
    public TreeNode wrongInorderSuccessor(TreeNode root, TreeNode p) {
        //        思路:找出该以及它的父节点,如果他存在右节点的话,就返回右节点
        //            如果不存在右节点,查看他是父节点的左节点还是右节点,
        //                如果是左节点,则返回父节点,否则返回空;
        TreeNode father = find(root,p);
        if (null == father){
            return null;
        }
        //根节点就是
        if(father.val == p.val){
            return null == father.right?null:father.right;
        }
        //该节点为父节点的做节点
        if (null != father.left && father.left.val == p.val){
            if (father.left.right == null){
                return father;
            }else{
                return father.left.right;
            }
        }
        //该节点是父节点的右节点
        if (null != father.right && father.right.val == p.val){
            if(father.right.right == null){
                return null;
            }else {
                return father.right.right;
            }
        }
        return null;
    }
    //寻找p节点的父节点
    private TreeNode find(TreeNode root, TreeNode p){
        if (null == root){
            return null;
        }
        //当前节点比p大,找左边
        if (root.val > p.val){
            if(root.left.val == p.val){
                return root;
            }else{
                return find(root.left,p);
            }
        }
        //当前节点比p小,找右边
        else if (root.val < p.val){
            if(root.right.val == p.val){
                return root;
            }else{
                return find(root.right,p);}
        }else{
            return root;
        }
    }
}