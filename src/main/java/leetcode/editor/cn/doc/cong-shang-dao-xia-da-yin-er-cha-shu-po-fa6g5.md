执行用时：0 ms, 在所有 C++ 提交中击败了100.00%的用户
内存消耗：12.2 MB, 在所有 C++ 提交中击败了80.17%的用户

简单朴素的双栈解决：

```
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        stack<TreeNode*> left, right;
        vector<vector<int>> ans;
        if (root != nullptr)left.push(root);
        while(!left.empty() || !right.empty())
        {
            ans.push_back(vector<int>());
            if (!left.empty())
            {
                while (!left.empty())
                {
                    ans.back().push_back(left.top()->val);
                    if (left.top()->left != nullptr) right.push(left.top()->left);
                    if (left.top()->right != nullptr) right.push(left.top()->right);
                    left.pop();
                }
            }
            else
            {
                while (!right.empty())
                {
                    ans.back().push_back(right.top()->val);
                    if (right.top()->right != nullptr) left.push(right.top()->right);
                    if (right.top()->left != nullptr) left.push(right.top()->left);
                    right.pop();
                }
            }
        }
        return ans;
    }
};
```
