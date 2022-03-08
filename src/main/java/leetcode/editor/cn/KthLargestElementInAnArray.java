//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 840 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer m,Integer n){
                return m-n;
            }
        });
        for (int n:nums){
            if (queue.size()==k){
                if (queue.peek()<n){
                    queue.poll();
                    queue.add(n);
                }
            }else{
                queue.add(n);
            }
        }
        return queue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}