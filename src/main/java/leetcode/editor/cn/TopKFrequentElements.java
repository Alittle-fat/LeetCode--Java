//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回
// 答案。
// 
// Related Topics 堆 哈希表 
// 👍 599 👎 0

package leetcode.editor.cn;

import org.springframework.context.annotation.Configuration;

import java.util.*;

//Java：前 K 个高频元素
public class TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        // TO TEST
        solution.topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            //先放在哈希表里
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                }
                else {
                    map.put(num, 1);
                }
            }

            //新建优先队列,确定优先队列的规则,int[]的第一个元素表示原数组中的值,第二个元素表示该值出现的次数
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer m, Integer n)
                {
                    return map.get(m) - map.get(n);
                }
            });
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();
                if (queue.size() == k) {
                    if (map.get(queue.peek()) < count) {
                        queue.poll();
                        queue.offer(num);
                    }
                }else {
                    queue.offer(num);
                }
            }
            int[] res = new int[k];
            for (int i = 0; i < k; ++i) {
                res[i] = queue.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
