#### 方法一: 线性扫描

本方法利用了连续的两个元素 *nums[j]* 和 *nums[j + 1]* 不会相等这一事实。于是，我们可以从头开始遍历 *nums* 数组。每当我们遇到数字 *nums[i]*，只需要检查它是否大于下一个元素 *nums[i+1]* 即可判断 *nums[i]* 是否是峰值。可以通过分别讨论问题的全部三种可能情况来理解本方法的思路。

情况 1. 所有的数字以降序排列。这种情况下，第一个元素即为峰值。我们首先检查当前元素是否大于下个元素。第一个元素满足这一条件，因此被正确判断为峰值。此时，我们不需要继续向下判断，也就不会有需要判断 *nums[i]* 和上一个元素 *nums[i-1]* 的大小的情况。

![image.png](https://pic.leetcode-cn.com/fafef6e2070c9c444541d03e5d24c6c06f2f50f94026a22a9a86903e9d5ffcb1-image.png)



情况 2. 所有的数字以升序排列。这种情况下，我们会一直比较 *nums[i]* 与 *nums[i+1]* 以判断 *nums[i]* 是否是峰值元素。没有元素符合这一条件，说明处于上坡而非峰值。于是，在结尾，我们返回末尾元素作为峰值元素，得到正确结果。在这种情况下，我们同样不需要比较 *nums[i]* 和上一个元素 *nums[i-1]*，因为处于上坡是 *nums[i]* 不是峰值的充分条件。

![image.png](https://pic.leetcode-cn.com/06cbc777aee1d0d0a906aefd408e539014f783727e401f136b66581d0856aa6d-image.png)



情况 3. 峰值出现在中间某处。这种情况下，当遍历上升部分时，与情况 2 相同，没有元素满足 *nums[i] > nums[i + 1]*。我们不需要比较 *nums[i]* 和上一个元素 *nums[i-1]*。当到达峰值元素时，*nums[i] > nums[i + 1]* 条件满足。此时，我们同样不需要比较 *nums[i]* 和上一个元素 *nums[i-1]*。这是由于“遍历会到达第i个元素”本身就说明上一个元素（第i- 1个）不满足 *nums[i] > nums[i + 1]* 这一条件，也就说明 *nums[i-1] < nums[i]*。于是，我们同样可以得到正确结果。

![image.png](https://pic.leetcode-cn.com/802bad70c4444bf708f4c63e30e054a33c27ace43b3c7b4fa64a0ffb8201fb7d-image.png)



```Java [solution 1]
public class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}
```

**复杂度分析**
* 时间复杂度 : *O(n)*。 我们对长度为 *n* 的数组 *nums* 只进行一次遍历。
* 空间复杂度 : *O(1)*。 只使用了常数空间。
<br />
<br />
---
#### 方法二：递归二分查找

**算法**

我们可以将 *nums* 数组中的任何给定序列视为交替的升序和降序序列。通过利用这一点，以及“可以返回任何一个峰作为结果”的要求，我们可以利用二分查找来找到所需的峰值元素。

在简单的二分查找中，我们处理的是一个有序数列，并通过在每一步减少搜索空间来找到所需要的数字。在本例中，我们对二分查找进行一点修改。首先从数组 *nums* 中找到中间的元素 *mid*。若该元素恰好位于降序序列或者一个局部下降坡度中（通过将 *nums[i]* 与右侧比较判断)，则说明峰值会在本元素的左边。于是，我们将搜索空间缩小为 *mid* 的左边(包括其本身)，并在左侧子数组上重复上述过程。

若该元素恰好位于升序序列或者一个局部上升坡度中（通过将 *nums[i]* 与右侧比较判断)，则说明峰值会在本元素的右边。于是，我们将搜索空间缩小为 *mid* 的右边，并在右侧子数组上重复上述过程。

就这样，我们不断地缩小搜索空间，直到搜索空间中只有一个元素，该元素即为峰值元素。

为了理解本方法的原理，让我们再次讨论前文提到的全部三种情况。

情况 1. 这种情况下，首先找到中间元素 *3*。由于它处于下降坡度，将搜索空间缩小到 `[1, 2, 3]`。对于此子数组，*2* 为中间元素，也处于下降坡度中，于是将搜索空间缩小到 `[1, 2]`。现在 *1* 是中间元素并同样处于下降坡度，于是将搜索空间缩小到 `[1]`。 最终 *1* 作为答案被正确返回。

 ![image.png](https://pic.leetcode-cn.com/63177d2c44aab77a657c0eb4589f7b7f45e754cf3408d9872bc3371e680c5908-image.png) ![image.png](https://pic.leetcode-cn.com/317e900368f211d02e3f107e288824a0e351d39963aae9a210b1fe3730ef1eec-image.png) ![image.png](https://pic.leetcode-cn.com/1a26071c6f370ccd84a417a4edbfcf7178b1daf78ed3270285861af4f77c6496-image.png) ![image.png](https://pic.leetcode-cn.com/8a511427f1c0c1b7c58776fa238124f44c300fc632d13658e1f381f6fd23fa03-image.png) ![image.png](https://pic.leetcode-cn.com/17974218262fc0e235fac8bfe9252058015de312546ce35ac217ab428360b780-image.png) ![image.png](https://pic.leetcode-cn.com/7d34f6f13915860f01f1e18409534a06db73504ffa3ab7dc66422801697a8a39-image.png) ![image.png](https://pic.leetcode-cn.com/e2edf7bcc45863a10d438dd92b8c4c6b6b63ff834aa11f05e4a104b5cbf859fc-image.png) 

情况 2. 这种情况下，首先找到中间元素 *3*。由于它处于上升坡度，将搜索空间缩小到 `[4, 5]`。对于此子数组，*4* 为中间元素，也处于上升坡度中，于是将搜索空间缩小到 `[5]`。 最终 *5* 作为答案被正确返回。

 ![image.png](https://pic.leetcode-cn.com/935aeb721c5901d8f70a64aafc0bff14be030db7cf44605c051e5c87de2890c0-image.png) ![image.png](https://pic.leetcode-cn.com/fb6d1262315867c62d818b0606b2628b6537d4b1b9c337bbaf3708fad257391c-image.png) ![image.png](https://pic.leetcode-cn.com/6de90b2f77920d015f7a45191090b9265a49dae0c4585e8d514b1aaa39afd2b9-image.png) ![image.png](https://pic.leetcode-cn.com/d359a685a16480ac4d6ad3d7e5df1f3b00524a74580982920bc01de72a9dd837-image.png) ![image.png](https://pic.leetcode-cn.com/a976733e8b2e4817b2d88616b519bc58ca471ca15e9ee3f77fcc377a329e0d46-image.png) ![image.png](https://pic.leetcode-cn.com/b0c6a62e9a0ebdc7a92995a1d633da7176cc82f9f3fe5e9e8f4b921b3d8fc4cc-image.png) 

情况 3. 这种情况下， 峰值位于中间某处。第一个中间元素是 *4*。它位于上升坡度，表明峰值在其右侧。于是，搜索空间缩小为 `[5, 1]`。 现在，*5* 位于下降坡度（相对其右侧相邻元素）, 搜索空间下降为 `[5]`。于是，*5* 被正确识别。

 ![image.png](https://pic.leetcode-cn.com/3e49bacacecbf67aed75bcee9387dab5ccb7e7160dcc7c33be1be9e7a3acc563-image.png) ![image.png](https://pic.leetcode-cn.com/8ee64c7b12c6b64b282324be43ecb89d29ac70d15dc3a35f2c62113cea7c23d8-image.png) ![image.png](https://pic.leetcode-cn.com/78f6084e3bdfe12c05f2304d6a8b8c15e224f1b7f01f254bc04c0832c24c53b2-image.png) ![image.png](https://pic.leetcode-cn.com/94cae61b8d045a3682d6a479417069776cabf13cc8bed930d07e088bcc2df575-image.png) ![image.png](https://pic.leetcode-cn.com/03d56e48600ff839e6a6c8819d859d488e8bafd4c052fc61b7bdba09ed78ff8c-image.png) ![image.png](https://pic.leetcode-cn.com/95f33e0a46ed380e3e5c2db5cb5a93479bb65463e7fcf6a7c953e3a039fe0461-image.png) 

```Java [solution 2]
public class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
```

**复杂度分析**

* 时间复杂度 : ![O\big(log_2(n)\big) ](./p__Obig_log_2_n_big__.png) 。每一步都将搜索空间减半。因此，总的搜索空间只需要 *log_2(n)* 步。其中 *n* 为 *nums* 数组的长度。
* 空间复杂度: ![O\big(log_2(n)\big) ](./p__Obig_log_2_n_big__.png) 。每一步都将搜索空间减半。因此，总的搜索空间只需要 *log_2(n)* 步。于是，递归树的深度为 *log_2(n)*。
<br />
<br />
---
#### 方法三：迭代二分查找

**算法**

上述二分查找方法使用了递归。我们可以通过迭代达到同样的效果。本方法即为迭代实现二分查找。

```Java [solution 3]
public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
```

**复杂度分析**

* 时间复杂度 : ![O\big(log_2(n)\big) ](./p__Obig_log_2_n_big__.png) 。 每一步都将搜索空间减半。因此，总的搜索空间只需要 *log_2(n)* 步。其中 *n* 为 *nums* 数组的长度。
* 空间复杂度 : *O(1)*。 只使用了常数空间。
