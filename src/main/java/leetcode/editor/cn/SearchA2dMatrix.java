//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 260 👎 0

package leetcode.editor.cn;
//Java：搜索二维矩阵
public class SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0){
            return false;
        }
        int raw = matrix.length;
        int column = matrix[0].length;
        //从左下角开始搜索
        int i = raw -1,j=0;
        while(i>=0 && j<column){
            if (matrix[i][j] == target){
                return true;
            }
            if (matrix[i][j] > target){
                --i;
            }else{
                ++j;
            }
        }
        return false;

        //或者也可以先定位行,在定位所在列,但是上面的方法更为通用
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}