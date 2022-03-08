//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatg
//o"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
//同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。 
//
// 示例 1： 
//
// 输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
// 
//
// 示例 2： 
//
// 输入： pattern = "abba", value = "dogcatcatfish"
//输出： false
// 
//
// 示例 3： 
//
// 输入： pattern = "aaaa", value = "dogcatcatdog"
//输出： false
// 
//
// 示例 4： 
//
// 输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
// 
//
// 提示： 
//
// 
// 1 <= len(pattern) <= 1000 
// 0 <= len(value) <= 1000 
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。 
// 
// Related Topics 字符串 
// 👍 94 👎 0

package leetcode.editor.cn;
//Java：模式匹配
public class PatternMatchingLcci{
    public static void main(String[] args) {
        Solution solution = new PatternMatchingLcci().new Solution();
        // TO TEST
        boolean re = solution.patternMatching("a","");
        System.out.println(re);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        //s[0] 代表a的值 ,s[1]代表b的值
        String[] s = new String[2];
    public boolean patternMatching(String pattern, String value) {
        return match(pattern,value);
    }

        /**
         * 从当前位置开始,匹配pattern与value
         * @param pattern
         * @param value
         * @return
         */
    private boolean match(String pattern,String value){
        if ("".equals(pattern) && "".equals(value)){return true;}
        if(null == pattern || "".equals(pattern) || null == value){return false;}
        int num  = pattern.charAt(0)-'a';
        if (null == s[num]){
            for (int i=0;i<=value.length();i++){
                s[num] = value.substring(0,i);
                if (!s[num].equals(s[num^1]) && match(pattern.substring(1),value.substring(i))){return true;}
            }
            s[num] = null;
            return false;
        }else{
            int length = s[num].length();
            if(length > value.length() || !s[num].equals(value.substring(0,length))){return false;}
            return match(pattern.substring(1),value.substring(length));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public boolean patternMatching(String pattern, String value) {
        String[] s = new String[2];
        return match(s,pattern,0,value,0);
    }

    /**
     * 从当前位置开始,匹配pattern与value
     * @param s s[0] 代表a的值 ,s[1]代表b的值
     * @param pattern
     * @param index1 pattern1的下标
     * @param value
     * @param index2 value的下标
     * @return
     */
    private boolean match(String []s,String pattern, int index1, String value, int index2){
        if (index1 == pattern.length() && index2 == value.length()){return true;}
        if (index1>=pattern.length() || index2 > value.length()){return false;}
        int num = pattern.charAt(index1) - 'a';
        if (null == s[num]){
            //当前的a或者b代表的值还没有
            for(int i = index2;i<=value.length();i++){
                s[num] = value.substring(index2,i);
                if (!s[num].equals(s[num^1]) && match(s,pattern,index1+1,value,i)){return true;}
            }
            s[num] = null;
            return false;
        }else{
            //判断当前的a/b的值是否与value一致
            int length = s[num].length();
            if (length > value.length()-index2 || !s[num].equals(value.substring(index2,index2+length))){return false;}
            return match(s,pattern,index1+1,value,index2+length);
        }
    }
}