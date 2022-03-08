//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 906 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        List<String> list = solution.letterCombinations("2");
        System.out.println(list);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        Map<Integer,String> map = new HashMap<>();
        List<String> re = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        if(digits.equals(""))
        {return re;}
        help(digits,0,"");
        return re;
    }

    public void help(String digits,int index,String current){
        if (digits.length() == index){
            re.add(current.toString());
            return;
        }

        String tempString = map.get(digits.charAt(index) - '0');
        for (int i=0;i<tempString.length();i++){
            help(digits,index+1,current + tempString.charAt(i));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //自己写的,虽然能解决,但是时空复杂度较高
    Map<String,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        return help(digits);
    }

    public List<String> help(String digits){
        List<String> result = new ArrayList<>();
        if (digits.length() == 0){
            return result;
        }
        String tempString = map.get(Character.toString(digits.charAt(0)));
        List<String> pre = help(digits.substring(1));
        for (int i=0;i<tempString.length();i++){
            if(pre.size() == 0){
                result.add(Character.toString(tempString.charAt(i)));
                continue;
            }
            for (String p:pre){
                result.add(tempString.charAt(i)+p);
            }
        }
        return result;
    }
}