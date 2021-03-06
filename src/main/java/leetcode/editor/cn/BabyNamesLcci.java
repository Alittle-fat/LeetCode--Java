//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成
//了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 
//是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。 
//
// 在结果列表中，选择字典序最小的名字作为真实名字。 
//
// 示例： 
//
// 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], sy
//nonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
//输出：["John(27)","Chris(36)"] 
//
// 提示： 
//
// 
// names.length <= 100000 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 14 👎 0

package leetcode.editor.cn;
//Java：婴儿名字
public class BabyNamesLcci{
    public static void main(String[] args) {
        Solution solution = new BabyNamesLcci().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        return new String[6];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}