太菜了别喷哈，大家随便看看
```java []
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return helper(b,a)||helper(a,b);
    }
    
    boolean helper(String a,String b){
        if(a.length()==1) return true;
        //把第二个字符串反一下
        String rb = new StringBuilder(b).reverse().toString();
        //找最长公前缀
        int max=0;
        for(int i =0;i<a.length();i++){
            if(a.charAt(i)==rb.charAt(i)){
                max++;
            }else{
                break;
            }
        }
        //pvhmupgqeltozftlmfjjde
        //yjgpzbezspnnpszebzmhvp
        //b反转后
        //pvhmzbezspnnpszebzpgjy
        //此时回文串由两部分组成（第一个字符串和第二个的反转）
        //  （1）pvhm   (2)
        //  （1）pvhm   (2)zbezspnnpszebz
        //显然第一个的（1）+第二个的（1）（2）加起来符合题意
        //但我们不确定是要第一个字符串的（2）部分还是第二个字符串的（2）部分，所以都来比一下
        String rbt=new StringBuilder(rb.substring(max,rb.length()-max)).reverse().toString();
        
        String at=a.substring(max,a.length()-max);
        String att=new StringBuilder(a.substring(max,a.length()-max)).reverse().toString();
        
        return rb.substring(max,rb.length()-max).equals(rbt)||at.equals(att);
    }
}
```
