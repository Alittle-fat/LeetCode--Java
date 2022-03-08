//给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 501 👎 0

package leetcode.editor.cn;
//Java：最大数
public class LargestNumber{
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        // TO TEST
        solution.largestNumber(new int[]{34323,3432});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public String largestNumber(int[] nums) {
        int size = nums.length;
        //冒泡排序
        for (int i=0;i<size;++i){
            for(int j=i+1;j<size;++j){
                if (verf(nums[j],nums[i])){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        if(nums[0]==0){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        for (int i=0;i<size;++i){
            s.append(nums[i]);
        }
        return s.toString();
    }

    //判断a是否应该放在b前面
    public boolean verf(Integer x,Integer y){
        String a = x.toString();
        String b = y.toString();
        return Long.valueOf(a+b)>Long.valueOf(b+a);
        /*int m = a.length();
        int n = b.length();
        if (m>n){
            return !verf(Integer.valueOf(b),Integer.valueOf(a));
        }
        for(int i =0;i<m;){
            int temp = a.charAt(i) - b.charAt(i);
            if (temp>0){
                return true;
            }else if(temp<0){
                return false;
            }else{
                //当前位置的数值相等
                if (i == m-1){
                    if(m==n){
                        return true;
                    }else{
                        while(i<n-1){
                            int k = b.charAt(i) - b.charAt(i+1);
                            if (k == 0){
                                ++i;
                                continue;
                            }else{
                                return k>0?true:false;
                            }
                        }
                    }
                }else{
                    ++i;
                }
            }
        }
        return true;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}