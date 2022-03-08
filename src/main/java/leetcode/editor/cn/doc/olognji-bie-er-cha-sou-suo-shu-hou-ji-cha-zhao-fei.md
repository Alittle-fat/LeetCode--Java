二叉搜索树（BST）的前驱后继搜索算法的一个重要应用场景是`BST的删除操作`，需要使用当前节点（度不为零）的前驱（后继）来替代当前元素。
### 图示
![后继者.PNG](https://pic.leetcode-cn.com/b8f66e131b478021832c8a1416ec87c4fd257b006ccd7d135e6a1ea7c0cb5287-%E5%90%8E%E7%BB%A7%E8%80%85.PNG)
### 算法
- 若`p.right != null`，**向下找**：
      1.  记录当前节点的右节点，`tmp = p.right`；
      2.  若`tmp != null`且`tmp.left != null`，`tmp = tmp.left`；
      3.  循环执行`步骤2`，退出循环后，`tmp`就是`p的前驱`。

- 若`p.right == null`，**向上找**：
      1. 从根节点开始，利用BST树的性质，找出`从根节点到p节点的路径`，定义一个栈`stack`用来记录`该路径`；
      2. 记录当前节点，`tmp = p`；
      3. 判断`tmp`是否是stack `栈顶的左子节点` ：
         1. 若`是`，则`当前的栈顶`就是`p的前驱`，**结束算法**；
         2. 若`不是`，则令`tmp = 栈顶`，并弹出栈顶，循环执行`步骤3`；
      4. 弹出stack所有元素后，若仍未结束算法，则表明p的`后继不存在`，返回`false`。

### 代码
```java
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //向下找
        TreeNode tmp = p.right;
        while(tmp != null && tmp.left != null)  tmp = tmp.left;
        if(p.right != null)    return tmp;
        //向上找
        tmp = root;
        Stack<TreeNode> stack = new Stack<>();
        //记录root到p的路径
        while(tmp != p){
            stack.push(tmp);
            if(p.val > tmp.val) tmp = tmp.right;
            else tmp = tmp.left;
        }
        while(stack.size() != 0 && stack.peek().left != tmp) tmp = stack.pop();
        if(stack.size() != 0)   return stack.peek();
        return null;
    }
}
```
### 复杂度分析
**时间复杂度**：O(logn)，**空间复杂度**：O(logn)





   











