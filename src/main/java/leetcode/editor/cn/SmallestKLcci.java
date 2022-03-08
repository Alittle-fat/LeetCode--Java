//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 堆 排序 分治算法 
// 👍 23 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

//Java：最小K个数
public class SmallestKLcci{
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        // TO TEST
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] re = solution.smallestK(arr,8);
        System.out.println(re);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(k == 0 || 0 == arr.length){
            return new int[]{};
        }
        //用优先队列,java自带的堆
        PriorityQueue<Integer> mq = new PriorityQueue<>();
        for (int a:arr){
            mq.offer(a);
        }
        int[] res = new int[k];
        for (int i=0;i<k;i++){
            res[i] = mq.poll();
        }
        return res;


        /*//方法一:冒泡排序 该方法可解,但是运行时间超了
        for(int i=0;i<arr.length;i++){
             int min = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            //交换i,j
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        return Arrays.copyOfRange(arr,0,k);*/

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}