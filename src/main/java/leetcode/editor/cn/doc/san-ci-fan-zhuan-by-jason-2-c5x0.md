思路:

三次反转是个经典解法。技巧性很强。

例如：输入: s = "abcdefg", k = 2
"abcdefg" 反转前2个字符 "bacdefg"
"bacdefg" 反转后5个字符 "bagfedc"
"bagfedc" 反转整个字符串 "cdefgab"


```cpp
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        reverse(s.begin(),s.begin()+n);
        reverse(s.begin()+n,s.begin()+s.size());
        reverse(s.begin(),s.end());
        return s;
    }
};
```