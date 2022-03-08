//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差 
// 示例： 
// 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//输出： 3，即数值对(11, 8)
// 
// 提示： 
// 
// 1 <= a.length, b.length <= 100000 
// -2147483648 <= a[i], b[i] <= 2147483647 
// 正确结果在区间[-2147483648, 2147483647]内 
// 
// Related Topics 数组 双指针 
// 👍 16 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：最小差
public class SmallestDifferenceLcci{
    public static void main(String[] args) {
        Solution solution = new SmallestDifferenceLcci().new Solution();
        // TO TEST
        int[] a = {-2147483648,1};
        int[] b = {2147483647,0};
        int re = solution.smallestDifference(a,b);
        System.out.println(re);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        //思路差不多,双指针,不判断,直接计算,取最小
    public int smallestDifference(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {return -1;};
        int minDiff = Integer.MIN_VALUE , aIdx = 0 , bIdx = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (aIdx < a.length && bIdx < b.length) {
            //关键，解决溢出 ， 负数域 大于 正数域。
            minDiff = Math.max(minDiff,-Math.abs(a[aIdx] - b[bIdx]));

            if (a[aIdx] < b[bIdx]) {
                aIdx++;
            }
            else {
                bIdx++;
            }
        }
        //反置
        return Math.abs(minDiff);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public int smallestDifference(int[] a, int[] b) {
        Arrays.parallelSort(a);
        Arrays.parallelSort(b);

        long min = Integer.MAX_VALUE;
        for (int i = 0,j=0;i<a.length && j<b.length;){
            if (min == 0){
                return 0;
            }

            if (a[i] > b[j]){
                while(j< b.length && a[i] > b[j]){
                    j++;
                }
                if (j < b.length){
                    min = Math.min(min,Math.abs((long)a[i]-b[j]));
                }
                min = Math.min(min,Math.abs((long)a[i]-b[j-1]));

            }else if (a[i] < b[j]){
                while(i < a.length && a[i] < b[j]){
                    i++;
                }
                if (i < a.length ){
                    min = Math.min(min,Math.abs((long)a[i]-b[j]));
                }
                min = Math.min(min,Math.abs((long)a[i-1]-b[j]));
            }
        }
        return (int)min;
    }
}