![微信图片_20200227143807.png](https://pic.leetcode-cn.com/ef52f79f6158170ff207fabcc1ffaff6e533c03fa2278675e40a85e1bb9a1672-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200227143807.png)


# 思路
**数字**看成`-1`，**字母**看成`1`，再计算**前缀和**。
**前缀和**  相同则计算下标的差值。

技巧：使用`int[]`数组`memo`存储 该**前缀和** **第`1`次出现时** 的**下标**。
为何是**第1次出现时**的下标？
因为要求**最长**子数组。

比如：
`["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]`

转化为`[1, -1, 1, 1, 1, -1, -1, -1, 1, -1, 1, 1, -1, -1, 1, 1, 1, 1, 1, 1]`

再转为**前缀和形式**`[1, 0, 1, 2, 3, 2, 1, 0, 1, 0, 1, 2, 1, 0, 1, 2, 3, 4, 5, 6]`。


前缀和相同是什么意思呢？

比如看**加粗**的`2`个`1`：[**1**, 0, **1**, 2, 3, 2, 1, 0, 1, 0, 1, 2, 1, 0, 1, 2, 3, 4, 5, 6]

说明这`2`个`1`的**下标**所构成的**区间内**的**数字和**为`0`，而**数字和为0**说明有**相同个数**的`1`和`-1`，即**相同个数**的**字母**和**数字**。

具体来说：第`1`个加粗的`1`下标为`0`，第`2`个加粗的`1`下标为`2`，构成**区间`(0, 2]`**(注意：是**半开半闭**)，
区间`(0, 2]`内元素的和即**下标为`1`**和**下标为`2`**的**元素之和**，[1, **-1**, **1**, 1, 1, -1, -1, -1, 1, -1, 1, 1, -1, -1, 1, 1, 1, 1, 1, 1]
很明显`-1 + 1 = 0`

理解了这一点，剩余的工作就是找**前缀和相同**，且**相隔最远**的2个元素。

什么才是相隔最远？

[**1**, 0, **1**, 2, 3, 2, **1**, 0, **1**, 0, **1**, 2, **1**, 0, **1**, 2, 3, 4, 5, 6]

单只看**前缀和为1**的情况，毫无疑问，前缀和为`1`时，相隔最远的肯定是**最左边**的`1`和**最右边**的`1`.

因此我们只需要记录前缀和为1**第一次出现时**的下标即可(也就是记录了最左边的`1`的位置)，以后再遇到前缀和为`1`时，只需要将其下标 `-` 所记录的最左边的`1`的位置 即可。

至于`memo`数组大小为何初始化为`(len << 1) + 1`，考虑最极端的情况，要么全为`-1`，要么全为`1`，对应前缀和为`-array.length`和`array.length`。

**特别注意**: 
当**前缀和为0**时，假设其下标为`n`，则说明区间`[0, n]`内所有元素的和为`0`，**区间长度**为`n + 1`。
因此将`memo[0 + array.length]`的值设为`-1`，因为`n - (-1) = n + 1`。

同时由于数组下标不能为负数，因此需要映射处理:
假设数组有`2`个元素，边界值为`-2`和`2`，即`[-2, -1, 0, 1, 2]`。
将`[-2, -1, 0, 1, 2]` 集体右移`nums.length`个单位，映射为`[0, 1, 2, 3, 4]`。

# 代码
```java [-java代码]
class Solution {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] memo = new int[(len << 1) + 1];
        Arrays.fill(memo, -2);
        memo[len] = -1;
        int res = 0, count = 0, begin = 0, end = 0;
        for (int i = 0; i < len; ++i) {
            boolean is_num = true;
            for (char c : array[i].toCharArray())
                if (c < '0' || c > '9') {
                    is_num = false;
                    break;
                }
            count += is_num ? -1 : 1;
            //未曾见过该前缀和(即memo数组中没有记录)
            if (memo[count + len] <= -2) 
                memo[count + len] = i;  //记录该前缀和的下标
            //曾见过该前缀和(即memo数组中已有记录)
            else if (i - memo[count + len] > res) {
                begin = memo[count + len] + 1;
                end = i + 1;
                res = i - memo[count + len];
            }
        }
        return Arrays.copyOfRange(array, begin, end);
    }
}
```
```c++ [-c++代码]
class Solution {
public:
    vector<string> findLongestSubarray(vector<string>& array) {
        size_t len = array.size();
        vector<int> memo((len << 1) + 1, -2);
        memo[len] = -1;
        size_t begin = 0, end = 0;
        int res = 0, count = 0;
        for (size_t i = 0; i < len; ++i) {
            bool is_num = true;
            for (const auto& ch : array[i])
                if (ch < '0' || ch > '9') {
                    is_num = false;
                    break;
                }
            count += is_num ? -1 : 1;
            if (memo[count + len] <= -2) 
                memo[count + len] = i;
            else if (i - memo[count + len] > res) {
                begin = memo[count + len] + 1;
                end = i + 1;
                res = i - memo[count + len];
            }
        }
        return vector<string>(array.begin() + begin, array.begin() + end);
    }
};
```
```python3 [-python3代码]
class Solution:
    def findLongestSubarray(self, array: List[str]) -> List[str]:
        array_len = len(array)
        memo = [-2 for i in range((array_len << 1) + 1)]
        memo[array_len] = -1
        begin, end = 0, 0
        res, count = 0, 0
        for i in range(array_len):
            is_num = True
            for ch in array[i]:
                if (ord(ch) < ord('0')) or (ord(ch) > ord('9')):
                    is_num = False
                    break
            count += -1 if is_num else 1
            if memo[count + array_len] <= -2:
                memo[count + array_len] = i
            elif i - memo[count + array_len] > res:
                begin, end = memo[count + array_len] + 1, i + 1
                res = i - memo[count + array_len]
        return array[begin:end]
```
