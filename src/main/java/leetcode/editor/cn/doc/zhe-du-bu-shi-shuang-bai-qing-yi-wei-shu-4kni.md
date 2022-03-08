### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public int fib(int n) {
        int[] sum = new int[3];
        if(n<=1){
            return n;
        }
        sum[0] = 0;
        sum[1] = 1;
        for(int  i =2;i<=n;i++){
            sum[2] = (sum[0] + sum[1])%1000000007;
            sum[0] = sum[1] ;
            sum[1] = sum[2];
        }
        return sum[2];
    }
    
}
```