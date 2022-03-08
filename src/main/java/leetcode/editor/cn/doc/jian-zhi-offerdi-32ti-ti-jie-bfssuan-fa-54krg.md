### 解题思路
欢迎大家关注，我会持续更新刷题题解，希望对大家有所帮助！

本题考查的是**BFS在二叉树中的应用。**

**宽度优先遍历，一层一层来做。即：**

1.将根节点插入队列中；
2.创建一个新队列，用来按顺序保存下一层的所有子节点；
3.对于当前队列中的所有节点，按顺序依次将儿子插入新队列；
4.按从左到右、从右到左的顺序交替保存队列中节点的值；
5.重复步骤2-4，直到队列为空为止。


**时间复杂度：**
树中每个节点仅会进队出队一次，所以时间复杂度是 O(n)。

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
    vector<int> get_c(vector<TreeNode*> root)
    {
        vector<int> res;
        for(auto & x : root)
        {
            res.push_back(x->val);
        }
        return res;
    }
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if(!root) return res;
        vector<TreeNode*> level;
        level.push_back(root);
        res.push_back(get_c(level));
        bool flag = true;//判断之字型
        while(true)
        {
            vector<TreeNode*> newlevel;
            for(auto & u : level)
            {
                if(u->left) newlevel.push_back(u->left);
                if(u->right) newlevel.push_back(u->right);
            }
            if(newlevel.size())
            {
                vector<int> temp = get_c(newlevel);
                if(flag)
                {
                    reverse(temp.begin(), temp.end());
                }
                res.push_back(temp);
                level = newlevel;
                flag = !flag;//判断之字型
            }
            else
            break;
        }
        return res;
    }
};
```