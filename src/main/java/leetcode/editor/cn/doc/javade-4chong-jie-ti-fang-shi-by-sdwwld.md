这题没什么难度，最简单的就是使用双指针，一个指向前，一个指向后，遇到空格以及特殊字符要跳过，然后判断
![image.png](https://pic.leetcode-cn.com/4d9102ff750701d75d5ba25800498d67bb11b06444cc543670ced1aac00cf4d0-image.png)


**1，** 我们先来看第一种写法，
```
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
```
**2，** 我们还可以在比较之前字母全部转化为小写，这里改为for循环的方式，只不过是换汤不换药，原理还都是一样的
```
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
```
**3，** 我们还可以使用正则匹配，把特殊字符过滤掉，只留下字母和数字，然后转化为小写，再反转，最后在判断是否相等。当然这种写法只是提供了一种思路，面试中如果写出这种肯定还会让你再写一种的，因为它没有完全考察出对这题的解题思路，
```
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
```
**4，** 如果想玩出花样，我们还可以把第一种的解题思路改为递归的方式
```
    public boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    public boolean isPalindromeHelper(String s, int left, int right) {
        if (left >= right)
            return true;
        while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
            left++;
        while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
            right--;
        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)) && isPalindromeHelper(s, ++left, --right);
    }
```

##### 查看更多答案，可点击扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”，