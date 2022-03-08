### 解题思路
欢迎大家关注，我会持续更新刷题题解，希望对大家有所帮助！

此题考查的是**栈与队列**知识内容里的**后缀表达式**。
**本题核心思想**：遇到数字则入栈，遇到运算符则取出**栈顶两个数字**进行运算（看代码的时候注意先后顺序），**并将结果压入栈中**。
**逆波兰表达式的优点**：
1.去掉括号后无歧义。
2.适合用栈操作运算。
详情如下代码：
### 代码

```cpp
class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        for (int i = 0; i < tokens.size(); i++) 
        {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") 
            {
                int num1 = st.top();
                st.pop();
                int num2 = st.top();
                st.pop();
                //注意num2在前，num1在后
                if (tokens[i] == "+") st.push(num2 + num1);
                if (tokens[i] == "-") st.push(num2 - num1);
                if (tokens[i] == "*") st.push(num2 * num1);
                if (tokens[i] == "/") st.push(num2 / num1);
            } 
            else 
            {
                st.push(stoi(tokens[i]));
            }
        }
        int result = st.top();
        st.pop(); // 把栈里最后一个元素弹出（其实不弹出也没事）
        return result;
    }
};
```