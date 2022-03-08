//给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符
//合要求的单词则返回空字符串。 
//
// 示例： 
//
// 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
//输出： "dogwalker"
//解释： "dogwalker"可由"dog"和"walker"组成。
// 
//
// 提示： 
//
// 
// 0 <= len(words) <= 200 
// 1 <= len(words[i]) <= 100 
// 
// Related Topics 字符串 
// 👍 7 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：最长单词
public class LongestWordLcci{
    public static void main(String[] args) {
        Solution solution = new LongestWordLcci().new Solution();
        // TO TEST
        String[] words = {"ttaaaa","pp","tpa","kpaqkt","tktpqq","aqppatp"};
        String result = solution.longestWord(words);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 主方法
     */
    class Solution {
    public String longestWord(String[] words) {
        if(null == words || 0 == words.length){
            return "";
        }
        //先将数组进行从大到小的排序
        Arrays.sort(words,(w1,w2)->{
            if(w1.length() == w2.length()){
                return w1.compareTo(w2);
            }else{
                return Integer.compare(w2.length(),w1.length());
            }
        });

        //将数组保存为set
        Queue<String> wordQues = new LinkedList<>(Arrays.asList(words));
        while(null != wordQues && wordQues.size()>0){
            String word = wordQues.poll();
            if(exist(word,wordQues)){
                return word;
            }
        }
        return "";
    }

    private boolean exist(String word,Queue<String> queue){
        if (null == word || 0 == word.length()){
            return true;
        }

        for (int i=0;i<word.length();i++){
            //String.substring(a,b): 截取下标从a到b-1位置的字符串
            //String.substring(c): 从下标c开始截取至结尾
            if(queue.contains(word.substring(0,i+1)) && exist(word.substring(i+1),queue)){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}