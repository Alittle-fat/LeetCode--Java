 相对于leetcode 215而言，这个题并不只是输出第k个元素，而是输出前k个元素，也就是说我们要用一个list或者array来存全部的数。
但是方法与之前的近乎相同。

思路：
1. 我们要明确，这里要找的是前k个最小的数，我们需要对堆顶的元素进行比较，如果数据流的元素小于堆顶元素，我们才进行替换，所以这里要采用maxheap才可以实现。***（这个真的是重点）***
2. 先将前k个加入到heap中，我们要保持这个size。
3. 进行判断，新旧元素的替换过程。
4. 最后简单的将heap中存的元素，依次的拿出来放入array中，输出就好了。

```
class Solution {
    public int[] smallestK(int[] arr, int k) {
        if(k == 0){
            return new int[]{};
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            maxHeap.offer(arr[i]);
        }
        for(int i = k; i < arr.length; i++){
            if(maxHeap.peek() > arr[i]){
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
```

time: 因为对于heap而言，加入元素的复杂度为log，我们规定了要取第k个最大值，且要遍历所有的数字来找。所以最终**O(n) = N * log(k)**。
space: 因为我们始终保持heap size为k，所以存储空间也就是**O(k)**。

# ***"Top" k 题型总结ing：***
["Top" k - 1: leetcode 215](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/java-top-k-1-by-donoghl-2/)