一、双重循环，暴力解法，时间复杂度O(n²)
二、利用HashTable，因为查找的时候时间复杂度O(1),像数组一样，我压根不需要知道之前插入的数据在什么位置，只需要知道是否存在这个元素。
```
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i]))
                return true;
            count.put(nums[i],1);
        }
        return false;
    }
}
```
