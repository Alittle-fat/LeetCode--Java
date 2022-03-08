先求返回的最大值 `Math.pow` ，然后 `for` 循环一下依次推入

```javascript
var printNumbers = function(n) {
  let target = Math.pow(10, n);
  let res = [];
  for(let i = 1; i < target; i++) {
    res.push(i);
  }
  return res;
};
```