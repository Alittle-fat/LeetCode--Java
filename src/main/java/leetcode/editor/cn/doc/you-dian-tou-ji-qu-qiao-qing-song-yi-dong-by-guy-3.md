```
class Solution {
    public int missingNumber(int[] nums) {
        int[] helper = new int[nums.length + 1]; // 记录是否出现

        for (int i : nums) { // 遍历一遍nums
            helper[i] = 1;
        }
        for (int j = 0; j < helper.length; j++) { // 遍历一遍helper
            if (helper[j] == 0) return j;
        }
        return -1;
    }
}
```
![B6HUBY4\]L@Q)AI7UHBSE%_1.png](https://pic.leetcode-cn.com/1599193724-pasmhB-B6HUBY4%5DL@Q\)AI7UHBSE%25_1.png)
