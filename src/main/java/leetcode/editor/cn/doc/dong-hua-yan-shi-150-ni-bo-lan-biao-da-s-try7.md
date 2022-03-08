**题目描述：**

根据 逆波兰表示法，求表达式的值。

有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

**示例:**

输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

**思路分析:**

该题目用栈求解的思路是：

首先，对于给定的字符串数组进行遍历，对每个元素进行考察。

然后，如果当前考察的元素不属于+、 -、*、/ ，则将其入栈；如果当前考察的元素属于+、 -、*、/，则将栈顶元素及其后面一个元素出栈。接着，将出栈的两个元素进行表达式求值运算，并将计算结果入栈。

最后，当字符串数组中的所有元素考察完毕时，将栈顶元素出栈，就是最终计算结果。

**动画演示：**

![150.mov](0f6492ab-9633-4135-bb7c-2b23313d118f)


**代码实现：**

```java
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0; i < tokens.length; i++) {
        String cur = tokens[i];
        if ("+".equals(cur)) {
            stack.push(stack.pop() + stack.pop());
        }else if ("-".equals(cur)) {
            Integer num1 = stack.pop();
            Integer num2 = stack.pop();
            stack.push(num2 - num1);
        }else if ("*".equals(cur)) {
            stack.push(stack.pop() * stack.pop());
        }else if ("/".equals(cur)) {
            Integer num1 = stack.pop();
            Integer num2 = stack.pop();
            stack.push(num2 / num1);
        }else {
            stack.push(Integer.valueOf(cur));
        }
    }
    return stack.pop();
}
```