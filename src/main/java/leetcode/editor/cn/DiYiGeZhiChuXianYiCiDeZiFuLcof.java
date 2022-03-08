//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 106 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：第一个只出现一次的字符
public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        // TO TEST
        solution.firstUniqChar("leetcode");
    }

    /**
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (null == chars || chars.length == 0){
            return ' ';
        }
        Map<Character,Integer> map = new HashMap<>();
        for(char k:chars){
            map.merge(k,1,(a,b)->b=a+b);
        }
        for(int i=0;i<chars.length;++i){
            if (map.get(chars[i]) == 1){
                return chars[i];
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}