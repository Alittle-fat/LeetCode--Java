

### 1，解法一

  截取前面的n个把它放到后面

```java
    public String reverseLeftWords(String s, int n) {
        //截取前面的n个把它放到后面
        return s.substring(n) + s.substring(0, n);
    }
```

<br>

### 2，解法二

还可以一行代码搞定，假如字符串是```abcde```，n是2，我们把这两个字符串相加就是```abcdeabcde```，只需要截取```cdeab```即可，代码如下


```java
    public String reverseLeftWords(String s, int n) {
        return (s + s).substring(n, s.length() + n);
    }
```



<br>

### 3，解法三

使用```StringBuilder```解决，先从字符串的第```n+1```个字符开始截取，然后在截取字符串的前n个字符，代码如下

```java
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        //从第n+1个开始读取
        for (int i = n; i < s.length(); i++)
            stringBuilder.append(s.charAt(i));
        //在读取字符串的前n个
        for (int i = 0; i < n; i++)
            stringBuilder.append(s.charAt(i));
        return stringBuilder.toString();
    }
```

还可以改为求余运算符计算

```java
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = s.length();
        for (int i = n; i < n + length; i++)
            stringBuilder.append(s.charAt(i % length));
        return stringBuilder.toString();
    }
```




<br>

### 4，解法四

可以参考[《189. 旋转数组》](https://leetcode-cn.com/problems/rotate-array/solution/javadai-ma-3chong-fang-shi-tu-wen-xiang-q8lz9/)

- **先全部反转**
- **反转前length - n个**
- **反转剩余的**

如下图所示

![image.png](https://pic.leetcode-cn.com/1617827301-sefpyK-image.png)



看下代码

```java
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, length - 1);//先反转全部的元素
        reverse(chars, 0, length - n - 1);//在反转前length - n个元素
        reverse(chars, length - n, length - 1);//接着反转剩余的
        return new String(chars);
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
```




<br>

我把部分**算法题**整理成了PDF文档，截止目前总共有**900多页**，大家可以下载阅读
**链接**：https://pan.baidu.com/s/1hjwK0ZeRxYGB8lIkbKuQgQ 
**提取码**：6666 

#### 如果觉得有用就给个赞吧，还可以关注我的[LeetCode主页](https://leetcode-cn.com/u/sdwwld/)查看更多的详细题解


