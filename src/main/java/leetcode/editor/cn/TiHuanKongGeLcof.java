//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 128 👎 0

package leetcode.editor.cn;
//Java：替换空格
public class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for(char c:chars){
            if (c!=' '){
                res.append(c);
            }else{
                res.append("%20");
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}