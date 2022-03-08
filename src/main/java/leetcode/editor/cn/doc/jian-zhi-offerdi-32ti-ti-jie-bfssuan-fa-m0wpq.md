### 解题思路
欢迎大家关注，我会持续更新刷题题解，希望对大家有所帮助！

本题考查的是**BFS在二叉树中的应用。**

我们从根节点开始按宽度优先的顺序遍历整棵树，每次先扩展左儿子，再扩展右儿子。

**这样我们会：**

1.先扩展根节点；
2.再依次扩展根节点的左右儿子，也就是从左到右扩展第二层节点；
3.再依次从左到右扩展第三层节点；
4.依次类推

所以BFS的顺序就是这道题目要求的顺序。

时间复杂度：
BFS时每个节点仅被遍历一次，**所以时间复杂度是 O(n)。**

### 代码

```cpp
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> levelOrder(TreeNode* root) {
        vector<int> res;
        if(!root) return res;
        queue<TreeNode*> q;
        q.push(root);
        while(q.size())
        {
            auto t = q.front();
            q.pop();
            res.push_back(t->val);
            if(t->left) q.push(t->left);
            if(t->right) q.push(t->right);
        }
        return res;
    }
};
```