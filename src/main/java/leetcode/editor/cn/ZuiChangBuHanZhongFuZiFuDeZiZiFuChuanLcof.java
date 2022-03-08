//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 滑动窗口 
// 👍 224 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长不含重复字符的子字符串
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        // TO TEST
        solution.lengthOfLongestSubstring("tmmzuxt");
    }

    /**
     * 滑动窗口
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*int length = s.length();
        if (length<2){
            return length;
        }
        int max = 0,l=0,r=0;
        //map用于记录过的某个字符最后出现的位置
        Map<Character,Integer> map = new HashMap<>();
        while(l<=r && r<length){
            if (!map.containsKey(s.charAt(r))){
                //之前没有遍历过,则r指针后移,将当前字符加入窗口
                map.put(s.charAt(r),r);
                ++r;
                max = Math.max(max,r-l);
            }else{
                //之前已经遍历过
                int index = map.get(s.charAt(r));
                if (index>=l){
                    //该字符存在于窗口之内,则l指针放到出现的位置的下一位
                    l = index +1;
                    //更新该字符最后一次出现的位置
                    map.put(s.charAt(r),r);
                    //r指针后移一位
                    ++r;
                }else{
                    //该重复字符不在窗口之内,则只更新一下它最后出现的位置
                    map.put(s.charAt(r),r);
                    //将r指针右移,并计算新的最大值
                    ++r;
                    max = Math.max(max,r-l);
                }
            }
        }
        return max;*/

        //思路一样,更简单
        Map<Character,Integer> map = new HashMap<>();
        //i为左边界
        int i = -1,res = 0;
        for(int j=0;j<s.length();++j){
            if (map.containsKey(s.charAt(j))){
                //更新左边界
                i = Math.max(i,map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j);
            res = Math.max(res,j-i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}