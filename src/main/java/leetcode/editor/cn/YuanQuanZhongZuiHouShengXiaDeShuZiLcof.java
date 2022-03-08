//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 383 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：圆圈中最后剩下的数字
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
        // TO TEST
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        /* //约瑟夫环,第一思路,但是时间超时
        if (m == 1){
            return n-1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;++i){
            list.add(i);
        }
        int index=0;
        while(list.size()>1){
            //计算要删除的索引的位置
            index = (index + m-1)%list.size();
            list.remove(index);
        }
        return list.get(0);*/

        //递归
            if(n==1) {
                return 0;
            }
            return (lastRemaining(n-1,m)+m)%n;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}