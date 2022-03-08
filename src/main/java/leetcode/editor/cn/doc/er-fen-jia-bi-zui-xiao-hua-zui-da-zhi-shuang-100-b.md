刷这道题之前，建议先刷一下 力扣 410.分割数组的最大值。

- 时间复杂度：![O(n×log^{\sum_{i=1}^{n}time\[i\]}) ](./p__O_n_×_log^{sum_{i=1}^{n}_time_i_}__.png) 
- 空间复杂度：*O(1)*
- 思路：典型的二分求最大值最小化。因为要求分割成子数组中各自和减去该子数组中最大值后的最大值最小，所以我们只需在`[min(nums),sum(nums)]`中二分查找`mid`，判断其是否可以将整个数组划分成不超过`m`的子数组个数，并且不断夹逼最小化`mid`即可。判断子数组和时需要减去该子数组中最大的元素值。

## AC代码：
```java
class Solution {
	public int minTime(int[] time, int m) {
		int len = time.length, lt = Integer.MAX_VALUE, rt = 0, mid, res = 0;
		if (m >= len)
			return 0;
		for (int i = 0; i < len; i++) {
			lt = Math.min(lt, time[i]);
			rt += time[i];
		}
		while (lt <= rt) {
			mid = (lt + rt) >> 1;
			if (check(time, len, mid, m)) { // 切割得多了，调大下界
				lt = mid + 1;
			} else { // 切割得可能少了，调小上界
				rt = mid - 1;
				res = mid; // 同时记录夹逼值
			}
		}
		return res;
	}
	private boolean check(int[] time, int len, int limit, int m) {
		int cnt = 1, sum = time[0], maxVal = time[0]; // 初始化为1，且当前子数组最大值初始化为第一个元素
		for (int i = 1; i < len; i++) { // 从第二个元素开始遍历
			sum += time[i];
			maxVal = Math.max(maxVal, time[i]);
			if (sum - maxVal > limit) { // 划分 第 cnt + 1 个子数组（新的子数组的第一个元素）
				cnt++;
				maxVal = sum = time[i];
			}
			if (cnt > m) // 当划分的子数组个数超过m时，直接返回true
				return true;
		}
		return false; // 找到一种可能的分割方案
	}
}
```