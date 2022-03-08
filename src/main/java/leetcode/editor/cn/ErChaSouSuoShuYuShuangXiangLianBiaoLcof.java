//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 分治算法 
// 👍 256 👎 0

package leetcode.editor.cn;
//Java：二叉搜索树与双向链表
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof().new Solution();
        // TO TEST
        Node a = new Node(1);
        Node b = new Node(9);
        Node c = new Node(4);
        c.left = a;
        c.right = b;
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(2);
        g.left = c;
        g.right = d;
        Node h = new Node(3);
        h.left = e;
        h.right = f;
        Node i = new Node(4);
        i.left = g;
        i.right = h;
        Node res = solution.treeToDoublyList(c);
        System.out.println(res);
    }

    // Definition for a Node.
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Node pre;
    Node head;
    public Node treeToDoublyList(Node root) {
        if (null == root){
            return null;
        }
        def(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

        /**
         * 中序遍历
         * @param cur
         */
    public void def(Node cur){
        if(null == cur){
            return;
        }
        def(cur.left);
        if (null == pre){
            //设置头结点
            head = cur;
        }else{
            pre.right = cur;
            cur.left = pre;
        }
        //注意前置结点的更换
        pre = cur;
        def(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}