//为了提高自己的代码能力，小张制定了 LeetCode 刷题计划，他选中了 LeetCode 题库中的 n 道题，编号从 0 到 n-1，并计划在 m 天内按
//照题目编号顺序刷完所有的题目（注意，小张不能用多天完成同一题）。 
//
// 在小张刷题计划中，小张需要用 time[i] 的时间完成编号 i 的题目。此外，小张还可以使用场外求助功能，通过询问他的好朋友小杨题目的解法，可以省去该题
//的做题时间。为了防止“小张刷题计划”变成“小杨刷题计划”，小张每天最多使用一次求助。 
//
// 我们定义 m 天中做题时间最多的一天耗时为 T（小杨完成的题目不计入做题总时间）。请你帮小张求出最小的 T是多少。 
//
// 示例 1： 
//
// 
// 输入：time = [1,2,3,3], m = 2 
//
// 输出：3 
//
// 解释：第一天小张完成前三题，其中第三题找小杨帮忙；第二天完成第四题，并且找小杨帮忙。这样做题时间最多的一天花费了 3 的时间，并且这个值是最小的。 
// 
//
// 示例 2： 
//
// 
// 输入：time = [999,999,999], m = 4 
//
// 输出：0 
//
// 解释：在前三天中，小张每天求助小杨一次，这样他可以在三天内完成所有的题目并不花任何时间。 
// 
//
// 
//
// 限制： 
//
// 
// 1 <= time.length <= 10^5 
// 1 <= time[i] <= 10000 
// 1 <= m <= 1000 
// 
// 👍 40 👎 0

package leetcode.editor.cn;
//Java：小张刷题计划
public class XiaoZhangShuaTiJiHua{
    public static void main(String[] args) {
        Solution solution = new XiaoZhangShuaTiJiHua().new Solution();
        // TO TEST
        int[] time  = {1,2,3,3};
        int m = 2;
        int res = solution.minTime(time,m);
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        //使用二分查找，查找一个值v，使得原数组能分割成m个不小于v的子数组，当分得的数组过多，则v太小，向右区间搜索
        //因为有一次让小杨做题的机会，因此记录每个子数组的最大值，减去该最大值，再与v进行比较
        public int minTime(int[] time, int m) {
            int length = time.length;
            if (m>=length){
                return 0;
            }
            int l = 0,r=0;
            for(int t : time){
                r += t;
            }
            while(l<r){
                int mid = (l+r)>>1;
                if (isBigger(time,mid,m)){
                    //值大了
                    r = mid;
                }else{
                    l = mid +1;
                }
            }
            return l;
        }

        //将time分割成各自和不小于limit的子数组的个数，如果分割的子数组的个数大于m，则limit太小，返回false
        private boolean isBigger(int[] time, int limit, int m){
            int num = 0,sum = 0,max = Integer.MIN_VALUE;
            for(int t:time){
                sum += t;
                max = Math.max(max,t);
                if(sum - max >limit){
                    if(++num >= m){
                        return false;
                    }
                    //下一个分组从t开始
                    max = sum = t;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}