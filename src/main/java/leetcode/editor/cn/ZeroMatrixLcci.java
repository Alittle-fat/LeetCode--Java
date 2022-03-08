//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 14 👎 0

package leetcode.editor.cn;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.event.SmartApplicationListener;

import java.util.HashSet;
import java.util.Set;

//Java：零矩阵
public class ZeroMatrixLcci{
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
        // TO TEST
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        System.out.println(matrix);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public void setZeroes(int[][] matrix) {
        if (null == matrix){
            return ;
        }

        int raw = matrix.length;
        int column = matrix[0].length;
        //记录找到的行和列
        Set<Integer> rawSet= new HashSet<>();
        Set<Integer> columnSet= new HashSet<>();
        //先遍历数组,找到要遍历的行和列
        for (int i = 0;i<raw;i++){
            for (int j=0;j<column;j++){
                if (matrix[i][j] == 0){
                    rawSet.add(i);
                    columnSet.add(j);
                }
            }
        }
        if (rawSet.size() == 0 || columnSet.size() == 0){
            return;
        }

        //设置所在行和列的数值为0
        for (int i = 0;i<raw;i++){
            for (int j=0;j<column;j++){
                if (rawSet.contains(i) || columnSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}