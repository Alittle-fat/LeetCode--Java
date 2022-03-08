//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 动态规划 
// 👍 168 👎 0

package leetcode.editor.cn;
//Java：硬币
public class CoinLcci{
    public static void main(String[] args) {
        Solution solution = new CoinLcci().new Solution();
        // TO TEST
        int x=solution.waysToChange(5);
        System.out.println(x);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        /*public int waysToChange(int n) {
            //count[i][j]数组表示考虑到param[i]时,组成j的所有方法的和
            int[][] count = new int[4][n+1];
            int[] param = {1,5,10,25};

            //初始化
            for (int i=0;i<=n;i++){ count[0][i] = 1; }
            for(int i=0;i<4;i++){count[i][0] = 1;}

            //开始计算
            for(int j=1;j<=n;j++){
                for(int i=1;i<4;i++){
                    if (j>=param[i]){
                        count[i][j] = (count[i-1][j] + count[i][j-param[i]])%1000000007;
                    }else{
                        count[i][j] = count[i-1][j];
                    }
                }
            }
            return count[3][n];
        }*/

        //上面二维数组的优化
        public int waysToChange(int n) {
            //count[i][j]数组表示考虑到param[i]时,组成j的所有方法的和
            int[] count = new int[n+1];
            int[] param = {1,5,10,25};

            //初始化
            for (int i=0;i<=n;i++){ count[i] = 1; }

            //开始计算
            //注意i,j的先后顺序
            for(int i=1;i<4;i++){
                for(int j=1;j<=n;j++){
                    if (j>=param[i]){
                        count[j] = (count[j] + count[j-param[i]])%1000000007;
                    }
                }
            }
            return count[n];
        }

}
//leetcode submit region end(Prohibit modification and deletion)


    public int waysToChange(int n) {
        //村数学方法,也能解,但是这个时间度也高
        /*int count = 0;
        for(int i=0;i<=n/25;i++){
            int restA = n - i*25;
            for (int j=0;j<=restA/10;j++){
                int restB = restA-j*10;
                int p = restB/5;
                count = count%1000000007 + p+1%1000000007;
            }
        }
        return count%1000000007;*/
        //用重循环的数学方法解
        int ans = 0;
        for (int i = 0; i <= n / 25; i ++) {
            int rest = n - i * 25;
            int p = rest / 5;
            int q = rest / 10;
            ans += (long)(p + 1)*(q + 1) % 1000000007 - (long)q*(q + 1)% 1000000007;
            ans %= 1000000007;
        }
        return ans;
    }

    /** 能解,但是时间复杂度太大
     * 从x开始计算n
     * @param n
     * @param x
     */
    int count=0;
    public void help(int n,int x){
        int times;
        switch (x) {
            case 25:
                times = n / 25;
                if (times > 0) {
                    for (int i = 0; i <= times; i++) {
                        help(n - 25 * i, 10);
                    }
                    break;
                }
            case 10:
                times = n / 10;
                if (times > 0) {
                    for (int i = 0; i <= times; i++) {
                        help(n - 10 * i, 5);
                    }
                    break;
                }
            case 5:
                times = n / 5;
                if (times > 0) {
                    for (int i = 0; i <= times; i++) {
                        help(n - 5 * i, 1);
                    }
                    break;
                }
            default:
                count = ++count%1000000007;
        }
    }
}