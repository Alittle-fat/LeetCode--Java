//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 486 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//Java：全排列 II
public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used =  new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track,used);
        //多一个去重
        return res.stream().distinct().collect(Collectors.toList());
    }

        private void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used){
            if (track.size() == nums.length){
                //注意此处不能写res.add(track);
                res.add(new LinkedList(track));
            }

            for (int i=0;i<nums.length;i++){
                if (used[i]){
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                backTrack(nums,track,used);
                used[i] = false;
                track.removeLast();
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}