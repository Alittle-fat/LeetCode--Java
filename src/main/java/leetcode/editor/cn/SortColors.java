//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
// Related Topics 排序 数组 双指针 
// 👍 740 👎 0

package leetcode.editor.cn;
//Java：颜色分类
public class SortColors{
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        // TO TEST
        solution.sortColors(new int[]{2,0,2,1,1,0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public void sortColors(int[] nums) {
        //1. 冒泡
        /*for(int i=0;i<nums.length;++i){
            for (int j=i;j<nums.length;++j){
                if (nums[i]>nums[j]){
                    *//*int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;*//*
                    nums[i] = nums[i]^nums[j];
                    nums[j] = nums[i]^nums[j];
                    nums[i] = nums[i]^nums[j];
                }
            }
        }*/
        //2. 双指针
        int p0=0;
        int p1 = 0;
        for (int i=0;i<nums.length;++i){
            if (nums[i] == 1){
                swap(nums,p1++,i);
            }else if(nums[i] == 0){
                swap(nums,p0,i);
                if (p0<p1){
                    //当 p_0 < p_1 时，我们已经将一些 1 连续地放在头部，此时一定会把一个 1 交换出去
                    //需要再进行一次交换,换回来
                    swap(nums,p1,i);
                }
                //需要将 p_0 和 p_1 均向后移动一个位置，而不是仅将 p_0 向后移动一个位置
                ++p0;
                ++p1;
            }
        }
    }
    //交换数组的i和j位置的值
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}