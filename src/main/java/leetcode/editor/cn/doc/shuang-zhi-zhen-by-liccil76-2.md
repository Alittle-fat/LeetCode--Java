### 解题思路
双指针

### 代码

```java
class Solution {
    public boolean isPalindrome(String s) {
        byte[] bytes = s.getBytes();
        int index = bytes.length-1;
        for (byte c : bytes) {
            if (
                    (c >= 48 && c <= 57) ||
                    (c >= 65 && c <= 90) ||
                    (c >= 97 && c <= 122)
            ) {
                while (index >= 0) {
                    byte c1 = bytes[index];
                    if (
                            (c1 >= 48 && c1 <= 57) ||
                            (c1 >= 65 && c1 <= 90) ||
                            (c1 >= 97 && c1 <= 122)
                    ) {
                        if (c1 == c || (c>=65 && c1>=65 && (c-c1==32 || c1-c==32))) {
                            index--;
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        index--;
                    }
                }
            }
        }
        return true;
    }
}
```