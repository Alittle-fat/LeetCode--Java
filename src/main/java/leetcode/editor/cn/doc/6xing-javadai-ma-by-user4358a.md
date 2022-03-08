### 解题思路
此处撰写解题思路

通过 sum(a) - a + b =  sum(b) - b - a 可以推导出 a - b = (sum(a) - sum(b)) / 2
 =>   b = a - (sum(a) - sum(b)) / 2
也就是目标是在b列表中找到值为 'a - (sum(a) - sum(b)) / 2' 的数值
### 代码

```java
class Solution {
    public int[] findSwapValues(int[] a, int[] b) {
        int diff = Arrays.stream(a).sum() - Arrays.stream(b).sum();
        if ((diff & 1) != 0) return new int[0];
        final int finaldiff = diff >> 1;
        Set<Integer> bSet = Arrays.stream(b).boxed().collect(Collectors.toSet());
        Integer res = Arrays.stream(a).boxed().filter(i -> bSet.contains(i - finaldiff)).findFirst().orElseGet(()->null);
        return res == null? new int[0] : new int[]{res, res-finaldiff};
    }
}
```