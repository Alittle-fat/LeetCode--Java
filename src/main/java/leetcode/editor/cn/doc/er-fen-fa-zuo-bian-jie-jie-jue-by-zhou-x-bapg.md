### 解题思路
写一个查找左边界的二分法；先查找target的左边界，在查找target+1的左边界，这样两个左边界相减就是答案；
**但是！！！！！**
需要判断连个左边界的特殊情况：

```
if (nums[l] != target) return 0;//数组中没有target元素
if (nums[r] == target) return r - l + 1;//数组中没有target+1元素
```


### 代码

```java
class Solution {
   public static int search(int[] nums, int target) {
       if (nums == null || nums.length == 0) return 0;
        int l = searchL(nums, target );
        int r = searchL(nums, target+1);
        if (nums[l] != target) return 0;
        if (nums[r] == target) return r - l + 1;
        return r - l;
    }

    public static int searchL(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }


    
}
```