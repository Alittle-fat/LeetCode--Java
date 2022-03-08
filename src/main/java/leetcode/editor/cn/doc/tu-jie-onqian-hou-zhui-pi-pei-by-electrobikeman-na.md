思路：先找出最长能匹配的前缀和后缀，判断即可

![1.png](https://pic.leetcode-cn.com/1602405561-qSFOyI-1.png)


```
class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            if (isHui(a) || isHui(b)) {
                return true;
            }
            // 翻转后找最远匹配的前缀和对应后缀
            String bReverse = new StringBuilder(b).reverse().toString();
            int aMatch = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == bReverse.charAt(i)) {
                    aMatch++;
                } else {
                    break;
                }
            }
            String aReverse = new StringBuilder(a).reverse().toString();
            int bMatch = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == aReverse.charAt(i)) {
                    bMatch++;
                } else {
                    break;
                }
            }
            // 都没有找到返回，无法组成回文串
            if (aMatch == 0 && bMatch == 0) {
                return false;
            }
            // 判断是把后缀替换还是前缀替换
            return isHui(a.substring(0, aMatch) + b.substring(aMatch)) ||
                    isHui(b.substring(0, bMatch) + a.substring(bMatch)) ||
                    isHui(a.substring(0, a.length() - aMatch) + b.substring(b.length() - aMatch)) ||
                    isHui(b.substring(0, b.length() - bMatch) + a.substring(a.length() - bMatch));
        }

        private boolean isHui(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
```
