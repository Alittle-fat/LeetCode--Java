package leetcode.editor.cn;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @Author: 张正华 10263447
 * @Date: 2020/10/16 15:12
 */
public class ZzhTest {
    public static void main(String[] args) {
        ZzhTest.Solution solution = new ZzhTest().new Solution();
        // TO TEST
        int[] x = {1,-1,1,2,5,-3,-8,-7,-6,-2,4};
        int[] res  = solution.maxChildArray(x);
        System.out.println(res);

        List<String> times = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = solution.lastDateOfPrevMonth(new Date());
        times.add(sdf.format(date));

        for (int i=1;i<13;i++){
            date = solution.lastDateOfPrevMonth(date);
            times.add(sdf.format(date));
        }
        System.out.println("上月最后一天：" + "haode");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        //求数组值最大的连续子数组
        //基本思想,从数组的起始位置开始,记录每个位置的和,若到当前位置的和的值大于最大值,那么记录起止位置与当前位置,
        // 如果某个位置上的累加和小于等于0,那么重置起始条件,将起始位置记在下一位,累计和sum记为0
        public int[] maxChildArray(int[] array) {
            int maxSum = Integer.MIN_VALUE;
            int[] res = new int[]{0,0};
            int index = 0,sum = 0,startIndex = 0;
            while(index<array.length){
                sum += array[index++];
                if (sum<=0){
                    //重新设定起始位置
                    startIndex = index;
                    //将和置0,从新的位置重新开始
                    sum = 0;
                    continue;
                }
                if (sum > maxSum){
                    res[0] = startIndex;
                    res[1] = index -1;
                    maxSum = sum;
                }
            }
            //注意,to的那个位置是不复制的
            return Arrays.copyOfRange(array,res[0],res[1]+1);
        }

        public  Date lastDateOfPrevMonth(Date date) {
            Calendar c = Calendar.getInstance(Locale.CHINA);
            //设置为指定日期
            c.setTime(date);
            //指定日期月份减去一
            c.add(Calendar.MONTH, -1);
            //指定日期月份减去一后的 最大天数
            c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
            //获取最终的时间
            return c.getTime();
        }
    }
}
