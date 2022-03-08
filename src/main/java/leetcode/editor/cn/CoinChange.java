//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1043 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：零钱兑换
public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // TO TEST
        solution.coinChange(new int[]{186,419,83,408},6249);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public int coinChange(int[] coins, int amount) {
        /*Arrays.sort(coins);
        return help(coins,coins.length-1,amount);*/

        //完全背包问题
        //dp表示凑到i块钱所用的最小硬币数目
        int[] dp = new int[amount+1];
        for (int i=0;i<dp.length;++i){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int i=0;i<coins.length;++i){
            for (int j=coins[i];j<dp.length;++j){
                if (dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
    /*private int help(int[] coins,int index,int amount){
        if (index == 0){
            return amount%coins[0] ==0?amount/coins[0]:-1;
        }
        int maxTimes = amount/coins[index];
        for (int i=maxTimes;i>=0;--i){
            int nextRes = help(coins,index-1,amount-i*coins[index]);
            if(nextRes == 0){
                continue;
            }else if (nextRes != -1){
                return nextRes + i;
            }
        }
        return 0;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}