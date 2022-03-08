
![watercolour-4799014_640.jpg](https://pic.leetcode-cn.com/1614865101-quDYlD-watercolour-4799014_640.jpg)



题目链接：[509. Fibonacci Number](https://leetcode-cn.com/problems/fibonacci-number/)

题解链接：[畅游面试中的动态规划套路-斐波那契数列系列之斐波那契数列](https://leetcode-cn.com/problems/fibonacci-number/solution/chang-you-mian-shi-zhong-de-dong-tai-gui-e1ph/)

#### 方法1:暴力递归

- 经典的种子题

```java
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }
```

#### 方法2:自顶向下记忆化递归(Top-down)

```java
Integer[] memo;
public int fib(int n) {
    memo = new Integer[n+1];
    return recursive(n);
}   
private int recursive(int num){
    if(memo[num]!=null) return memo[num];
    if(num==0) return 0;
    if(num==1) return 1;
    return memo[num] = ( fib(num-1)+fib(num-2));
}
```

#### 方法3:自底向上填表DP(Bottom-up)

```java
public int fib(int n) {
    if(n<2) return n;
    int[] f= new int[n+1];
    f[0] = 0;
    f[1]= 1;
    for(int i = 2;i<=n;i++) f[i] =f[i-1]+f[i-2];
    return f[n];
}
```



