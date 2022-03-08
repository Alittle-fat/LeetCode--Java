//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 287 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：二叉搜索树的后序遍历序列
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        // TO TEST
        boolean res = solution.verifyPostorder(new int[]{1,2,5,10,6,9,4,3});
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length < 3){
            return true;
        }
        int l = 0,r = postorder.length-1;
        int root = postorder[r];
        --r;
        //从后向前找到第一个比跟节点小的位置
        while(r>=0 && postorder[r]>root){
            --r;
        }
        //遍历左节点,看是否所有的做节点都根节点小
        while(l<=r){
            if (postorder[l]>root){
                return false;
            }
            ++l;
        }
        //分别校验左节点和右节点
        //左节点:0-r;
        //右节点:r+1到.length-2
        return verifyPostorder(Arrays.copyOfRange(postorder,0,r+1))
            && verifyPostorder(Arrays.copyOfRange(postorder,r+1,postorder.length-1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}