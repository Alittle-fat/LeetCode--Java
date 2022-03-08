//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。 
// 示例： 
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
// 
// 提示： 
// 
// 0 <= len(array) <= 1000000 
// 
// Related Topics 排序 数组 
// 👍 31 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：部分排序
public class SubSortLcci{
    public static void main(String[] args) {
        Solution solution = new SubSortLcci().new Solution();
        // TO TEST
        int[] array = {1,2,4,7,10,11};
        solution.subSort(array);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 从左向右遍历,只要右边的右边的值小于左边遍历过的最大值,就将当前index记为last
     * 从右向左,只要左边的值大于右边遍历过的最小值,就将当前index记为first
     */
    class Solution {
    public int[] subSort(int[] array) {
        if(array == null || array.length == 0){
            return new int[]{-1,-1};
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int first = -1;
        int last = -1;
        for (int i=0;i<array.length;i++){
            if (array[i]<max){
                last = i;
            }else{
                max = array[i];
            }

            if (array[array.length-1-i]>min){
                first = array.length-1-i;
            }else{
                min = array[array.length-1-i];
            }
        }
        return new int[]{first,last};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //自己写的,先排序,再找到左右不同的index就行,容易理解,但是耗内存,耗时间
    public int[] subSort(int[] array) {
        int[] result = {-1,-1};
        if (null == array || array.length == 0){
            return result;
        }
        int[] temp = Arrays.copyOf(array,array.length);
        Arrays.sort(array);
        //比较两个素组不一样的地方
        int i=0,j=array.length-1;
        while (i<array.length && temp[i] == array[i]) {
            i++;
        }
        while (j>i && temp[j] == array[j]) {
            j--;
        }
        if (i < j)
        {
            result[0] = i;
            result[1] = j;
        }
        return result;
    }
}