//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 693 👎 0

package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：字母异位词分组
public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //hash数组
        /*Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            String newValue = new String(chars);
            List<String> list = map.getOrDefault(newValue, new ArrayList<String>());
            list.add(str);
            map.put(newValue,list);
        }
        return new ArrayList<List<String>>(map.values());*/

        return new ArrayList<>(Arrays.stream(strs)
            .collect(Collectors.groupingBy(str -> {
                // 返回 str 排序后的结果。
                // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                char[] array = str.toCharArray();
                Arrays.sort(array);
                return new String(array);
            })).values());

        //return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}