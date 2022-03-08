//假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。 
//
// 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。 
//
// 示例 1: 
//
// 输入:
//big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
//small = [1,5,9]
//输出: [7,10] 
//
// 示例 2: 
//
// 输入:
//big = [1,2,3]
//small = [4]
//输出: [] 
//
// 提示： 
//
// 
// big.length <= 100000 
// 1 <= small.length <= 100000 
// 
// Related Topics Sliding Window 
// 👍 10 👎 0

package leetcode.editor.cn;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

//Java：最短超串
public class ShortestSupersequenceLcci{
    public static void main(String[] args) {
        Solution solution = new ShortestSupersequenceLcci().new Solution();
        // TO TEST
        int[] a = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] b = {1,5,9};
        int[] x = solution.shortestSeq(a,b);
        System.out.println(x);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        int[] result = {0,big.length-1};
        int count = small.length;

        if(count > big.length){
            return new int[0];
        }
        //先把小数组放入map中,v为各值在大数组中的最新位置,初始为-1
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:small){
            map.put(x,-1);
        }
        //遍历大数组,更新小数组中的元素在大数组中的最新位置,当所有元素全找齐时,当前元素,与所有元素最新位置的最小值就是答案
        for (int i=0;i<big.length;i++){
            if(map.containsKey(big[i])){
                if (map.get(big[i]) == -1){
                    //第一次更新(找到了一个,该方法可以避免单个元素的多次更新也算作次数)
                    count--;
                }
                map.put(big[i],i);
            }

            //判断所有元素是否已经找全了
            if(count == 0){
                //所有元素最新位置的最小值
                int min = Integer.MAX_VALUE;
                for (Map.Entry<Integer,Integer>m:map.entrySet()){
                    int a =m.getValue();
                    min = Math.min(m.getValue(),min);
                }
                //当找到的新子数组比原有的小时,更新原有的
                if(i-min < result[1] - result[0]){
                    result[0] = min;
                    result[1] = i;
                }
            }
        }
        //小数组的元素再大数组中没有找全,则返回空
        if(count >0){
            return new int[0];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}