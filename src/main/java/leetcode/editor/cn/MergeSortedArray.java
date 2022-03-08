//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 703 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：合并两个有序数组
public class MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        // TO TEST
        solution.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*int[] res = new int[m+n];
        int i=0,j=0;
        while(i<m+j && j< n){
            if (nums1[i]> nums2[j]){
                //向后移动1位
                for (int x=m+j;x>i;--x){
                    nums1[x] = nums1[x-1];
                }
                nums1[i] = nums2[j++];
            }
            ++i;
        }
        //如果nums2没有插入玩,则将剩下的全部插入
        while(i<m+n && j<n){
            nums1[i++] = nums2[j++];
        }*/

        //或者先合并,再排序
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);

        //或者,从后往前
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
        {nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];}

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}