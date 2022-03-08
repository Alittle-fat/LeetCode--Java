### 解题思路
普通计算器，且都为整数，我们主要操作是，遇到+-就将数入栈，遇到乘除就将数字出栈计算后再入栈。有几个容易混淆的点：
1.判断的op是当前num的前一个计算符，我们是假设num后面出现了操作符，然后再去判断num前面的操作符是什么：
1.1如果num前面的是+或者-，我们就将num入栈，其中如果是-号，我们就将-num入栈，要记住，switch比的操作符是num前面的而不是
当前的char c=s.charAt(i)。
1.2如果是*/，我们就将栈中存放的num前面一个数字出栈，用该数字和num进行运算，将运算后的数字继续入栈。
每次操作完后我们将num=0，op=s.charAt(i)。
##### 为了防止有人看不懂，我写个大概的表达式方程： (假设一大堆运算) op num c=s.charAt(i)  。以上就是对应的表达式，我们是扫描到当前操作符(c)后再去对上个操作符(op)进行运算的。最后栈中存放的是所有需要相加的数，加起来就是结果了。

### 代码

```java
class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0)return 0;
        s=s.replace(" ","");
        Stack<Integer> num=new Stack<>();
        int n=0;
        char op='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                n=n*10+(c-'0');
            }
            if(!Character.isDigit(c)||i==s.length()-1){
                int pre;
                switch(op){
                    case '+': num.push(n);
                        break;
                    case '-': num.push(-n);
                        break;
                    case '*': pre=num.pop();
                        num.push(pre*n);
                        break;
                    case '/': pre=num.pop();
                        num.push(pre/n);
                        break;
                }
                op=c;
                n=0;
            }
        }
        int res=0;
        while(!num.isEmpty()){
            res+=num.pop();
        }
        return res;
    }
}
```