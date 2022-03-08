//一个已排序好的表 A，其包含 1 和其他一些素数. 当列表中的每一个 p<q 时，我们可以构造一个分数 p/q 。 
//
// 那么第 k 个最小的分数是多少呢? 以整数数组的形式返回你的答案, 这里 answer[0] = p 且 answer[1] = q. 
//
// 示例:
//输入: A = [1, 2, 3, 5], K = 3
//输出: [2, 5]
//解释:
//已构造好的分数,排序后如下所示:
//1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
//很明显第三个最小的分数是 2/5.
//
//输入: A = [1, 7], K = 1
//输出: [1, 7]
// 
//
// 注意: 
//
// 
// A 长度的取值范围在 2 — 2000. 
// 每个 A[i] 的值在 1 —30000. 
// K 取值范围为 1 —A.length * (A.length - 1) / 2 
// 
// Related Topics 堆 二分查找 
// 👍 60 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Java：第 K 个最小的素数分数
public class KThSmallestPrimeFraction{
    public static void main(String[] args) {
        Solution solution = new KThSmallestPrimeFraction().new Solution();
        // TO TEST
        int[] A = {1, 2, 3, 5,7,11,13};
        int[] re = solution.kthSmallestPrimeFraction(A,3);
        System.out.println(re);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public int[] kthSmallestPrimeFraction(int[] A, int K) {
            // 因为分数是在(0,1)范围内，所以在此范围使用二分查找
            double lo = 0, hi = 1, mid;
            int p = 0, q = 1;
            int i, j;
            int count;
            // 因为是在小数内使用二分查找，无法像在整数范围内那样通过 mid+1和边界判断来终止循环
            // 所以此处根据count来结束循环
            while (true) {
                mid = (lo + hi) / 2;
                count = 0;
                p = 0;
                for (i = 0; i < A.length; i++) {
                    j = 0;
                    while (j < A.length - 1 - i && mid >= (double) A[i] / A[A.length - 1 - j]) {
                        j++;
                    }
                    count += j;
                    // 重点：p/q是比 mid小的数中的最大值(所有行)
                    if (j > 0 && ((double) p / q) < ((double) A[i] / A[A.length - j])) {
                        p = A[i];
                        q = A[A.length - j];
                    }
                }
                if (count > K){
                    hi = mid;}
                else if (count < K){
                    lo = mid;}
                else{
                    return new int[] { p, q };}
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //该方法思路正确,但是运行超时
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        //构造自定义比较器的优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            float res = ((float)a[0]/(float)a[1])-((float)b[0]/(float)b[1]);
            if(res == 0){
                return 0;
            }
            return res>0 ? 1 : -1;
        });
        //将所有分数淄河放入队列
        for (int i = 0; i < A.length; ++i) {
            for (int j =i+1;j<A.length;j++){
                pq.add(new int[]{A[i],A[j]});
            }
        }

        while (--K > 0) {
            pq.poll();
        }

        int[] ans = pq.poll();

        return new int[]{ans[0], ans[1]};
    }


    //降序的优先队列的构建和测试
    public int test(int[] A, int K){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer s, Integer t1) {
                if (s.equals(t1)){
                    return 0;
                }
                return s-t1>0?-1:1;
            }
        });

        for (int a:A){
            pq.add(a);
        }
        while(--K>0){
            pq.poll();
        }
        return pq.poll();
    }

}