# Java 的两种方法 -- 快排和大根堆  

**方法一：快排**

套套模板偷偷懒~~

```
class Solution {
    public int[] smallestK(int[] arr, int k) {
        //快排
        quickSort(arr, 0 , arr.length-1) ;
        int[] res = new int[k] ;
        for(int i = 0 ; i < k ; i++)
        {
            res[i] = arr[i] ;
        }
        return res ;
    }


    public void quickSort(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int x = partition(arr, low, high) ;
            quickSort(arr, low, x - 1) ;
            quickSort(arr, x+1, high) ;
        }
    }
    public int partition(int[] arr, int low, int high)
    {
        int i = low, j = high ;
        int x = arr[low] ;
        while(i < j)
        {
            while(i < j && x < arr[j])
            {
                j-- ;
            }

            if(i < j)
            {
                arr[i] = arr[j] ;
                i++ ;
            }

            while(i < j && x > arr[i])
            {
                i++;
            }

            if(i < j)
            {
                arr[j] = arr[i] ;
                j-- ;
            }

        }
        arr[i] = x ;
        return i ;

    }
}


```
**方法二：大根堆**

大根堆是根节点是最大值，往下值越来越小，这里维护大根堆排序，可以得到下面的前k小个数

![大根堆.png](https://pic.leetcode-cn.com/1600965957-ouASvV-%E5%A4%A7%E6%A0%B9%E5%A0%86.png)

（大根堆）

```
class Solution {
    public int[] smallestK(int[] arr, int k) {
        
        //大根堆
        //维护一个k个节点的大根堆，顶点是最大的，新加一个数时，小于顶点，就往下排，把顶点挤走，剩下的是前k个数
        PriorityQueue<Integer> pq = new PriorityQueue<>() ;
        for(int i:arr)
        {
            pq.add(i) ;
            if(pq.size() > k){
                if(i < pq.peek())
                {
                    pq.remove() ;
                    pq.add(i) ;
                }
            }
        }
        int[] res = new int[k] ;
        int i = 0 ;
        while(!pq.isEmpty() && i < k)
        {
            res[i++] = pq.remove() ;
        }
        return res ;
    }
}
```

如果哪里可以优化欢迎评论呀~我也在努力学习中！欢迎一起讨论 :)