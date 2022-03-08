//给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
// Related Topics 数组 
// 👍 20 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java： 字母与数字
public class FindLongestSubarrayLcci{
    public static void main(String[] args) {
        Solution solution = new FindLongestSubarrayLcci().new Solution();
        // TO TEST
        String[] a = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
                      "L","M"};
        String[] b = solution.findLongestSubarray(a);
        System.out.println(b);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *将字母看做1,梳子看做-1,然后求前缀和,前缀和相同的两个数之间的各数的和为0,即字母与数字的各数相等,找出间距最大的相同前缀和便可;
     */
    class Solution {
    public String[] findLongestSubarray(String[] array) {
        if(null == array || array.length == 0){
            return new String[0];
        }
        //字母记1,数字记-1,求前n项和
        int[] num = new int[array.length];
        //map用于存放前缀和相同的id
        Map<Integer, List<Integer>> map = new HashMap<>();
        int temp = 0;

        for (int i=0;i<array.length;i++){
            if (Character.isDigit(array[i].charAt(0))){
                temp += -1;
            }else{
                temp += 1;
            }
            num[i] = temp;

            List<Integer> list = map.get(temp);
            if(null == list){
                List<Integer> a = new ArrayList<>();
                a.add(i);
                map.put(temp,a);
            }else{
                list.add(i);
            }
        }

        //遍历map,找出最大间距
        int max = Integer.MIN_VALUE,i=0,j=0;
        for(Map.Entry<Integer, List<Integer>>m:map.entrySet()){
            List<Integer> list = m.getValue();
            if (list.size()>0){
               if(list.get(list.size()-1) -list.get(0)>max){
                   max = list.get(list.size()-1) -list.get(0);
                   i = list.get(0);
                   j= list.get(list.size()-1);
               }
            }
        }

        return Arrays.copyOfRange(array,i,j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}