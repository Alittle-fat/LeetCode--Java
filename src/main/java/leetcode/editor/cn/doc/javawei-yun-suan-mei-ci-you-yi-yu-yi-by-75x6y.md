### 解题思路
此处撰写解题思路

### 代码

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0;i < 32;i++){
            if(((n >> i) & 1) == 1){
                res++;
            }
        }
        return res;
    }
}
```