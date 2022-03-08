//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 419 👎 0

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

//Java：两个数组的交集 II
public class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] res = new int[Math.min(nums1.length,nums2.length)];

        int index0 = 0 ,index1 = 0,index2 =0 ;
        while (index1<nums1.length && index2<nums2.length){
            if (nums1[index1] < nums2[index2]){
                ++index1;
            }else if (nums1[index1] > nums2[index2]){
                ++index2;
            }else{
                res[index0++] = nums1[index1];
                ++index1;
                ++index2;
            }
        }
        //拷贝的是0到index0-1位置上的元素
        return Arrays.copyOfRange(res,0,index0);

        //hash表法
        /*
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //下方法是自己理解错误而写的,理解为共有的最小连续数组
    /*
    public int[] intersect(int[] nums1, int[] nums2) {
        //默认nums1的长度小于nums2的长度
        if(nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }

        Map<Integer, List<Integer>> map = new HashMap<>(nums2.length);
        //将nums2的元素放入map
        for(int i=0;i<nums2.length;i++){
            List<Integer> index = map.get(nums2[i]);
            if (index == null){
                index = new LinkedList<>();
                index.add(i);
                map.put(nums2[i],index);
            }else{
                index.add(i);
            }
        }

        for (int j=0;j<nums1.length;j++){
            if (map.containsKey(nums1[j])){
                List<Integer> index = map.get(nums1[j]);
                ArrayList<Integer> res = new ArrayList<>();
                res.add(nums1[j]);
                for (int start:index){
                    while (nums2[++start] == nums1[++j]){
                        res.add(nums1[j]);
                    }
                    if (res.size()>1){
                        return res.toArray(new int[res.size()]);
                    }
                }
            }
        }
    }
     */
}