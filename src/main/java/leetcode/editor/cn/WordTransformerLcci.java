//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 深度优先搜索 广度优先搜索 数组 字符串 
// 👍 19 👎 0

package leetcode.editor.cn;

import java.lang.reflect.GenericDeclaration;
import java.util.*;
import java.util.stream.Collectors;

//Java：单词转换
public class WordTransformerLcci{
    public static void main(String[] args) {
        Solution solution = new WordTransformerLcci().new Solution();
        // TO TEST
        String[] wordList = {"hot","dog","dot"};
        List<String> query = Arrays.asList(wordList);
        List<String> res = solution.findLadders("hot","dog",query);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        List<String> result = new ArrayList<>();
        //记录已经被找过的单词,很关键,不然执行会超时
        boolean[] marked;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        marked=new boolean[wordList.size()];
        wordList.remove(beginWord);
        //深度优先法
        dfs(beginWord,endWord,wordList);
        return result;
    }

    //深度优先搜索
    private boolean dfs(String word,String endWord,List<String> wordList){
        result.add(word);
        if (word.equals(endWord)){
            return true;
        }
        //临近单词链
        Set<String> set = help(word,wordList);
        for (String s:set){
            if(dfs(s,endWord,wordList)){
                return true;
            }
        }
        result.remove(word);
        return false;
    }

    //寻找某个单词的邻居(只改变一个字母便可到达)
    private Set<String> help(String word,List<String> wordList){
        Set<String> result = new HashSet<>();
        if(null == word || word.length() == 0){
            return result;
        }
        //遍历数组,找出与目标单词只差一个字母的单词的集合(已经找过的除外)
        for (int i=0;i<wordList.size();i++){
            String s = wordList.get(i);
            //marked[i]的判断很关键,不然代码执行会超时
            if (s.length() != word.length() || marked[i]){ continue; }
            int count = 0;
            for (int j=0;j<word.length();j++){
                if (count>1){break;}
                if (word.charAt(j) != s.charAt(j)){ count++; }
            }
            if (count == 1){
                result.add(s);
                marked[i] = true;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //广度优先法
        /*Set<String> start = new HashSet<>();
        start.add(beginWord);
        bfs(start,endWord,wordList);*/

    //广度优先搜索
    /*private boolean bfs(Set<String> words,String endWord,List<String> wordList){
        if (null == words || words.size() == 0){
            return false;
        }
        //对每一个邻居单词寻找它的下一组邻居
        for (String w:words){
            //已找过,则忽略,未找过则添加
            if(result.contains(w)){ continue; }else{ result.add(w); }

            //当前节点就是,则结束,返回true
            if (endWord.equals(w)){ return true; }

            //否则,找到w的邻居节点
            Set<String> set = help(w,wordList);

            //移除当前层已经存在的节点
            Set<String> temp = new HashSet<>();
            for(String s:set){ if (!words.contains(s)){ temp.add(s); } }

            //若临近节点不存在,则进行下一个循环
            if (null == temp || 0==temp.size()){ result.remove(w);continue;}

            //如果临近存在,且在临近节点或其后面找到了目标值则返回true,否则移除该节点的记录,并进行下一个循环
            if (bfs(temp,endWord,wordList)){ return true; }else{ result.remove(w); }
        }
        return false;
    }*/

}