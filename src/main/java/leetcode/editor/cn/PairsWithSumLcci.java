//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 
// 👍 8 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：数对和
public class PairsWithSumLcci{
    public static void main(String[] args) {
        Solution solution = new PairsWithSumLcci().new Solution();
        // TO TEST
        int[] nums = {-2,-1,0,3,5,6,7,9,13,14};
        List<List<Integer>> re = solution.pairSums(nums,12);
        System.out.println(re);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (null == nums || length == 0 || length == 1){
            return result;
        }
        //排序
        Arrays.sort(nums);

        //排除两数的最大和最小值
        if(target >nums[length-2] + nums [length-1] || target < nums[0] + nums[1]){
            return result;
        }

        //双向进行一次遍历
        for (int i = 0, j = nums.length - 1; i < j && j > 0; ) {

            if (nums[i] + nums[j] == target) {
                /*List<Integer> temp = new ArrayList<>(2);
                temp.add(nums[i++]);
                temp.add(nums[j--]);
                result.add(temp);*/
                //这样写更简单
                result.add(Arrays.asList(nums[i++],nums[j--]));
            }else if (nums[i] + nums[j] < target) {
                /*if (nums[i + 1] + nums[j] > target) {
                    i++;
                    j--;
                    continue;
                }*/
                i++;
            }
            else {
                /*if (nums[i] + nums[j - 1] < target) {
                    i++;
                    j--;
                    continue;
                }*/
                j--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     *算法对,但是时间超时
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }

        List<Integer> repeat = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if(repeat.contains(i)){
                continue;
            }
            for (int j=i+1;j<nums.length;j++){
                if(repeat.contains(j)){
                    continue;
                }
                if (nums[i]+nums[j] == target){
                    List<Integer> temp = new ArrayList<>(2);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    result.add(temp);
                    repeat.add(i);
                    repeat.add(j);
                    break;
                }
            }
        }
        return result;
    }
}