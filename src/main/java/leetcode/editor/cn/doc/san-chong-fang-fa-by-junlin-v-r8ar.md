### 解题思路
法一：回溯法
法二：用栈
法三：利用vector的insert特性

### 代码

# **1.回溯法**
```cpp
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void method(vector<int>& res,ListNode* head){
        if(head==NULL) return;
        method(res,head->next);
        res.push_back(head->val);
    }
    vector<int> reversePrint(ListNode* head) {
        vector<int> res;
        method(res,head);
        return res;
    }
};
```

# **2.用栈**
```
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
        stack<int> s;
        vector<int> res;
        ListNode* pre=head;
        while(pre){
            s.push(pre->val);
            pre=pre->next;
        }
        while(!s.empty()){
            res.push_back(s.top());
            s.pop();
        }
        return res;
    }
};
```

# **3.利用vector的insert特性**
```
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
        vector<int> res;
        ListNode* pre=head;
        while(pre){
            res.insert(res.begin(),pre->val);
            pre=pre->next;
        }
        return res;
    }
};
```





