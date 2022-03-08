开始想着用双层循环来做，但仔细一想，效率太低了；然后发现可以用指针来做
思路：
1.先对两个数组排序
2.建立f1、f2指针，分别指向nums1数组、nums2数组的下标
3.若nums1[f1]>nums[f2]，则指针f1移动一位；若num1[f1]>nums[f2]，则指针f2移动一位；若相等，便是找到了两个数组的交集之一，加入动态数组arrl中
4.重复步骤3，直到其中一个数组迭代完，便退出循环
5.将动态数组arrl赋值给静态数组jiao,并返回jiao

### 代码

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int f1 = 0,f2=0;
        ArrayList<Integer> arrl = new ArrayList<>();
        while(f1<nums1.length && f2<nums2.length){
            if(nums1[f1]<nums2[f2]){
                f1++;
            }else if(nums1[f1]>nums2[f2]){
                f2++;
            }else{
                arrl.add(nums1[f1]);
                f1++;
                f2++;
            }
        }
        int[] jiao = new int[arrl.size()];
        for(int i=0; i<arrl.size(); i++)
        {
            jiao[i] = arrl.get(i);
        }
        return jiao;
    }
}
```