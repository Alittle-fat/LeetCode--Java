//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 939 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：全排列
public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used =  new boolean[nums.length];
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track,used);
        return res;
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