
本题采用贪心算法
对于数组中一个递增的片段i——j，实际上从i买入股票到j卖出股票的利润，等于从i买入到i+1卖处，加上从i+1买入到i+2卖出...一直到j—1买入j卖出。
所以只需要判断i处的值是否大于i+1的值，再计算利润即可。
```
class Solution {
public:
    int maxProfit(vector<int>& prices) {
    int sum=0; //贪心算法
    for(int i=0;i<prices.size()-1;i++) sum+= prices[i]<prices[i+1]? prices[i+1]-prices[i]:0;
    return sum;
    }
};
```
