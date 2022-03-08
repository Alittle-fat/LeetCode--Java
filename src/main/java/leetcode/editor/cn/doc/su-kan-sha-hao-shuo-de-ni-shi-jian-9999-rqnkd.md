### 解题思路
![image.png](https://pic.leetcode-cn.com/1621081697-ZGoCnG-image.png)


### 代码

```java
class Solution {
    public int[] printNumbers(int n) {
        int num = (int)Math.pow(10, n);
        int[] result = new int[num - 1];
        for(int i = 0; i < num - 1; i++) result[i] = i + 1;
        return result;
    }
}
```