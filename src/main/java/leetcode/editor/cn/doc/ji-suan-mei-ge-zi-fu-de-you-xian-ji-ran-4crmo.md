### 两两比较
```
class Solution:
    def minNumber(self, nums: List[int]) -> str:
        s = list(map(str,nums))
        hashTable = dict()
        n = len(nums)
        for i in range(n) : 
            hashTable[i] = 0
        for i in range(n-1) :
            for j in range(i,n) :
                if s[i] + s[j] < s[j] + s[i] :
                    hashTable[i] += 1
                if s[i] + s[j] > s[j] + s[i] :
                    hashTable[j] += 1
        hashTable = sorted(hashTable , key= lambda x : hashTable[x] , reverse = True)
        res = ""
        for i in hashTable :
            res += s[i]
        return res
```

### 哈希表 解题思路
对于任意两个字符串 ： 从左向右依次比较每个字符，字符大的优先级低 当某个字符串比较结束还没分出优先级时，如下 s1 = num s2 = num + s s1 + s2 = num + num + s s2 + s1 = num + s + num

比较s 与 num的值 ， 大的优先级低 以此循环即可分出这两个字符的优先级 将上述整理化简 s1 = num s2 = num * n + s num >= 1 ( s 不以num 开头 ） 比较 num 和 s的大小 大的优先级低

所以对于两个字符串 将较短的字符串依次循环添加该字符串的字符，直到和较长的字符串长度相同时，比较大小即可判断优先级 又len(str(2**63)) = 19 所以将所有字符串转化长度为19的该字符串循环出现而成的字符串 x * (19 // len(x) ) + x[:19 % len(x)] 作为比较的值升序排列后相加即为答案

### 代码

```python3
class Solution:
    def minNumber(self, nums: List[int]) -> str:
        return "".join(
            sorted(
                list(map(str,nums)) , 
                key = lambda x : x * (19 // len(x) ) + x[:19 % len(x)] 
            )
        )
```