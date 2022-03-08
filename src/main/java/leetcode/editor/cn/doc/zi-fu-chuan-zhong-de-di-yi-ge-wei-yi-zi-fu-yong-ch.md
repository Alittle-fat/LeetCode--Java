看到的答案都是用HashMap写的，想到可以用长度26的数组存放26个字母重复次数，代码如下：
```
class Solution {
    public int firstUniqChar(String s) {
        int[] nums = new int[26];
        char[] chars = s.toCharArray();
        for(char ch: chars) {
            nums[ch - 'a']++;
        }
        for(int i=0; i<chars.length; i++) {
            if(nums[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
```
执行用时：4 ms, 在所有 Java 提交中击败了97.11%的用户