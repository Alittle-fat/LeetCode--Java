### 解题思路
在层序遍历的基础上设置层数，每当模2为1时则翻转每一层的数据
![image.png](https://pic.leetcode-cn.com/1616852894-vZSaWJ-image.png)


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
 //2021-03-27 层序遍历 广度搜索
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        queue<TreeNode*> que;
        if(root)    que.push(root);
        int flag = 0;
        while(!que.empty())
        {
            int size = que.size();
            vector<int> vec;
            for(int i = 0;i < size;i++)
            {
                TreeNode* node = que.front();
                que.pop();
                vec.push_back(node->val);
                if(node->left)  que.push(node->left);
                if(node->right)  que.push(node->right);
            }
            if(flag % 2)
                reverse(vec.begin(),vec.end());
            ans.push_back(vec);
            flag++;
        }
        return ans;
    }
};
```