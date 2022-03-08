### 解题思路

说实在工作中真碰到这样的问题，第一反应是用现有的工具解决。算法可能要折腾半小时，而且看了众多解答也没有觉得特别的简洁。

根据 pattern 构造一个正则它不香吗？

- `aabb` -> `(\w*)\1(\w*)\2`
- `abba` -> `(\w*)(\w*)\2\1`

上面 `\1` 和 `\2` 表示对前面分组的反向引用。

### 代码

```javascript
/**
 * @param {string} pattern
 * @param {string} value
 * @return {boolean}
 */
function patternMatching(pattern, value) {
  if (pattern === "") {
    return value === "";
  }
  let group = 1;
  let a = '';
  let b = '';
  let reg = '';
  for (const char of pattern.split('')) {
    if (char === 'a') {
      if (a) {
        reg += a;
      }
      else {
        reg += '(\\w*)';
        a = '\\' + group++;
      }
    }
    else if (char === 'b') {
      if (b) {
        reg += b;
      }
      else {
        reg += '(\\w*)';
        b = '\\' + group++;
      }
    }
  }
  const match = new RegExp('^' + reg + '$').exec(value);
  return Boolean(match) && match[1] !== match[2];
};
```