//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2808 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：三数之和
public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // TO TEST
        solution.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *三数相加其实等同于两数相加
     */
    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //可以交给set自己去重
        Set<List<Integer>> resp = new HashSet<>();
        if (null == nums || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        //从小到大,每次取一个值,然后在剩下的数组中寻找两数之和等于-当前值的两个数,
        //此时的逻辑和两数之和等于某一定值的逻辑是相等的
        //需要注意的是去重
        for (int i=0;i<nums.length;++i){
            if(nums[i] > 0){
                break;
            }
            if (i>0 && nums[i] == nums[i-1]){
                //该数在之前已经遍历过了,因此不需要在遍历,直接跳过
                continue;
            }
            int l=i+1,r = nums.length-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    /*res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l] == nums[l+1]){
                        ++l;
                    }
                    while(l<r && nums[r] == nums[r-1]){
                        --r;
                    }*/
                    resp.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    ++l;
                    --r;
                }else if(sum < 0){
                    ++l;
                }else{
                    --r;
                }
            }
        }
        //return res;
        return new ArrayList<>(resp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}