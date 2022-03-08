//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 634 👎 0

package leetcode.editor.cn;
//Java：旋转图像
public class RotateImage{
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * (i,j) 旋转过后变为(length-1-j,i)
     */
    class Solution {
    public void rotate(int[][] matrix) {
        int temp;
        //y和e可以理解为x和s的辅助,按照变换的规律,方便写而已
        //环的旋转,由外向内的环
        //注意此方法仅针对n*n,对于n*m不适用
        //也可以把右旋90度认为是先上下交换,后沿左上至右下的对角线交换
        for (int x = 0,y = matrix[0].length -1;x<y;++x,--y){
            for (int s = x, e=y; s< y;++s,--e){
                temp = matrix[x][s];
                matrix[x][s] = matrix[e][x];
                matrix[e][x] = matrix[y][e];
                matrix[y][e] = matrix[s][y];
                matrix[s][y] = temp;
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}