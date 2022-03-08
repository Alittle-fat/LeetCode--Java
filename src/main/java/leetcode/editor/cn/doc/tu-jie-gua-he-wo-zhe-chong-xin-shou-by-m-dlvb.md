一张图就搞定。
![image.png](https://pic.leetcode-cn.com/1624245187-MDYkvU-image.png)

```
class Solution {
    public double myPow(double x, int n) {
        double ans=1.0;
        long t=n;
        if(n<0){
            t=-t;
        }
        while(t!=0){
            if((t&1)==1){
                ans=ans*x;
            }
            x=x*x;
            t=t>>1;
        }
        if(n<0) return 1/ans;
        return ans;
    }
}
```

