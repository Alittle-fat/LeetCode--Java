### 解题思路
两个字符串一个向后遍历，一个向前遍历，当对应字符不等的时候进行判断即可

### 代码

```java
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a,b)||check(b,a);
    }
    
    private boolean check(String a,String b){
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();
        int left = 0;
        int length = stra.length;
        while (left<=length/2){
            if (stra[left]==strb[length-1-left])
                left++;
            else
                break;
        }
        //如果超过一半都是相等的，直接返回true
        if (left>=length/2)
            return true;
        //否则判断中间未遍历的部分是否是回文
        if (isPa(a.substring(left,length-left)) || isPa(b.substring(left,length-left)))
            return true;
        return false;
    }
    
    //判断是否回文
    private boolean isPa(String string){
        char[] str  =string.toCharArray();
        for (int i=0;i<str.length/2;i++){
            if (str[i]!=str[str.length-1-i])
                return false;
        }
        return true;
    }
}
```