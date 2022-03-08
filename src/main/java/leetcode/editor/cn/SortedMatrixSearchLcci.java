//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 双指针 二分查找 分治算法 
// 👍 8 👎 0

package leetcode.editor.cn;
//Java：排序矩阵查找
public class SortedMatrixSearchLcci{
    public static void main(String[] args) {
        Solution solution = new SortedMatrixSearchLcci().new Solution();
        // TO TEST
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18, 21, 23, 26, 30}};
        boolean a = solution.searchMatrix(matrix,1);
        System.out.println(a);
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
        //从左下角开始(可以认为是中位数)
        int i = matrix.length-1,j = 0;
        while(i>=0 && j<matrix[0].length){
            if(matrix[i][j] < target){
                j++;
            }else if(matrix[i][j] > target){
                i--;
            }else{ return true; }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //该方法较为繁琐
    public boolean fansuoSearchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0){
            return false;
        }
        int m = 0,n = 0;
        int i = matrix.length-1,j = matrix[0].length-1;
        while(i>=0 && j>=0 && matrix[i][j] >= target){
            if (matrix[i][j]==target){
                return true;
            }
            m=i;
            n=j;
            while(m>0 && matrix[m][j] >=target){
                if(matrix[--m][j] == target){
                    return true;
                }
            }
            while(n>0 && matrix[i][n] >= target){
                if(matrix[i][--n] == target){
                    return true;
                }
            }
            i--;
            j--;
        }
        return false;
    }

}