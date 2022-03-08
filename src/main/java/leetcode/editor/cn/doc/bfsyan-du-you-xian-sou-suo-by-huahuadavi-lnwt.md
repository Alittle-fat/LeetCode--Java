
### 代码
```java
  var levelOrder = function (root) {
    let r = [];
    if (root) {
      let arr = [root]
      while (arr.length) {
        let node = arr.shift();
        r.push(node.val)
        if (node.left) {
          arr.push(node.left)
        }
        if (node.right) {
          arr.push(node.right)
        }
      }
    }
    return r;
  };
```