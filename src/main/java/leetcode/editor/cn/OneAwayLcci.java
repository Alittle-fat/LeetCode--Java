//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 36 👎 0

package leetcode.editor.cn;
//Java：一次编辑
public class OneAwayLcci{
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        // TO TEST
        String first = "se";
        String second = "sa";
        solution.oneEditAway(first,second);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public boolean oneEditAway(String first, String second) {
        if(null == first || null == second ){return false;}
        int length_f = first.length();
        int length_s = second.length();
        if(length_f == 0 && length_s ==0){return true;}
        if (length_f < length_s){return oneEditAway(second,first);}
        if(length_f - length_s>1){return false;}

        for(int i = 0;i<second.length();i++){
            //出现字符不一样了
            if(first.charAt(i) != second.charAt(i)){
                return first.substring(i+1).equals(second.substring(length_f == length_s ? i+1:i));
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     *自己所写,有点繁琐
     */
    /*class Solution {
        public boolean oneEditAway(String first, String second) {
            if(null == first && null == second){
                return true;
            }
            int firstLength = first.length();
            int secLength = second.length();
            if(firstLength >= secLength){
                return change(first,second);
            }else {
                return change(second,first);
            }
        }

        //校验是否可以替换
        private boolean change(String first, String second){
            if(first.length() - second.length() >= 2){
                return false;
            }
            if(first.length()>second.length()){
                for (int i=0;i<first.length();i++){
                    if(i == 0){
                        if(first.substring(1).equals(second)){
                            return true;
                        }
                    }else if(i == first.length()-1){
                        if(first.substring(0,i).equals(second)){
                            return true;
                        }
                    } else{
                        if((first.substring(0,i) + first.substring(i+1)).equals(second)){
                            return true;
                        }
                    }
                }
            }
            if (first.length() == second.length()){
                if(0 == first.length()){
                    return true;
                }
                for (int i=0;i<first.length();i++){
                    if(i == 0){
                        if(first.substring(1).equals(second.substring(1))){
                            return true;
                        }
                    }else if(i == first.length()-1){
                        if(first.substring(0,i).equals(second.substring(0,i))){
                            return true;
                        }
                    } else{
                        if((first.substring(0,i) + first.substring(i+1)).equals(second.substring(0,i) + second.substring(i+1))){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }*/
}