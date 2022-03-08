//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找 
// 👍 446 👎 0

package leetcode.editor.cn;

import java.util.Collections;
import java.util.PriorityQueue;

//Java：有序矩阵中第K小的元素
public class KthSmallestElementInASortedMatrix{
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // TO TEST
        int[][] matrix = {{1,  5,  10},{9, 11, 13},{12, 13, 15}};
        int x = solution.kthSmallest(matrix,3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            //堆排序法
            PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
            for (int[] row : matrix) {
                for (int num : row) {
                    if (MaxPQ.size() == k && num > MaxPQ.peek())
                    {break;}
                    MaxPQ.add(num);
                    if (MaxPQ.size() > k)
                    {MaxPQ.remove();}
                }
            }
            return MaxPQ.remove();

            //二分查找法
            /*int n = matrix.length - 1;
            int left = matrix[0][0], right = matrix[n][n];
            while(left < right){
                int mid = left + (right - left) / 2;
                int count = countNotMoreThanMid(matrix, mid, n);
                if(count < k){
                    //小于等于k的元素的个数小于k,表明第k个小的元素肯定在mid的右边
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            return left;*/
        }
        //找出数组中比mid小的元素的个数
        //从左下角开始当前元素比要找的元素大,则纵坐标-1,否则横坐标+1
        private int countNotMoreThanMid(int[][] matrix, int mid, int n){
            int count = 0;
            int x = 0, y = n;
            while(x <= n && y >= 0){
                if(matrix[y][x] <= mid){
                    count += y + 1;
                    x++;
                }else{
                    y--;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}