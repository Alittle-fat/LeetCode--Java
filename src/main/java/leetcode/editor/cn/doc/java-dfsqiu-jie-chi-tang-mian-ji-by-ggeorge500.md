### 解题思路
首先我们能想到要做的第一件事就是遍历矩阵，遇到0之后就开始搜索周围是否还有0，这里搜索的过程要用到递归，那么递归的返回条件就是`land[x][y] != 0`或索引x和y越界。

值得一提的是，我们要注意在写if语句的时候索引x y越界的判断一定要放在`land[x][y] != 0`的后面！如果先判断！=0就有可能会报错提示越界。

为了避免在递归的时候重复判断矩阵中的0，因为在判断池塘个数的过程中，每个0只会被记录一次，记录完之后就没有价值了，所以我们可以在判断为0后加上`land[x][y] = -1`，这样在下次dfs的时候就可以避免重复的0。


### 代码

```java
class Solution {
    public int[] pondSizes(int[][] land) {
      List<Integer> list = new ArrayList<>();
      int temp;

      // 遍历矩阵每个元素
      for (int i = 0; i < land.length; i++) {
        for (int j = 0; j < land[0].length; j++) {
          temp = findPool(land, i, j);
          if (temp != 0) list.add(temp);
        }
      }

      // 第一种List<Integer>转int[]
      // int[] result = new int[list.size()];
      // for (int i = 0; i < result.length; i++) {
      //   result[i] = list.get(i);
      // }

      // 第二种List<Integer>转int[]，优雅且高效
      int[] result = list.stream().mapToInt(Integer::valueOf).toArray();

      Arrays.sort(result);

      return result;
    }

    private int findPool(int[][] land, int x, int y) {
      int num = 0;
      if (x < 0 || x >= land.length || y < 0 ||y>=land[0].length||land[x][y]!=0) {
        return num;
      }
      num++;
      land[x][y] = -1;   // 如果为0，就转换为-1，避免重复搜索

      num += findPool(land, x + 1, y);
      num += findPool(land, x - 1, y);
      num += findPool(land, x, y + 1);
      num += findPool(land, x, y - 1);
      num += findPool(land, x + 1, y + 1);
      num += findPool(land, x + 1, y - 1);
      num += findPool(land, x - 1, y + 1);
      num += findPool(land, x - 1, y - 1);

      return num;
    }
}
```