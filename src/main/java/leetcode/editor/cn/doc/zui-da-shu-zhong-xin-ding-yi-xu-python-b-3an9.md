### 解题思路
- **整体方法**：
重新定义序的关系，当 *x,y* 按照 *x* 在 *y* 前concate得到的数字更小时，定义为 *x<y*。
在这种定义之下，把数字从大到小排列，得到的数组所concate的数字最大。

- **细节**
关于cmp_to_key，这个可以参考 [key的使用](https://blog.csdn.net/qq_35531549/article/details/88405224)
最后来回倒了两次，`str(int(ans)) `，是因为用例 `nums=[0,0]`，直接排序连接得到的是`'00'`，应该是`'0'`

### 代码

```python3
from functools import cmp_to_key


def largestNumber(nums):
    nums.sort(key=cmp_to_key(compare), reverse=True)
    ans = ''.join([str(num) for num in nums])
    return str(int(ans)) 

def compare(x,y):
    x, y = str(x), str(y)
    if int(x+y)<int(y+x):
        return -1
    elif int(x+y)>int(y+x):
        return 1
    else:
        return 0
```