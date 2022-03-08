
<br>

### 1，把非0的往前挪
把非0的往前挪，挪完之后，后面的就都是0了，然后在用0覆盖后面的。这种是最容易理解也是最容易想到的，代码比较简单，这里就以示例为例画个图来看下
![image.png](https://pic.leetcode-cn.com/1605757309-IUmJCz-image.png)
![image.png](https://pic.leetcode-cn.com/1605757324-TcMxsz-image.png)

代码如下

```
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int index = 0;
        //一次遍历，把非零的都往前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }
        //后面的都是0,
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
```
看下运行结果
![image.png](https://pic.leetcode-cn.com/1605749974-ZJBytI-image.png)


<br>

### 2，参照双指针解决
这里可以参照双指针的思路解决，指针```j```是一直往后移动的，如果指向的值不等于0才对他进行操作。而```i```统计的是前面0的个数，我们可以把```j-i```看做另一个指针，它是指向前面第一个0的位置，然后我们让```j```指向的值和```j-i```指向的值交换

```
    public void moveZeroes(int[] nums) {
        int i = 0;//统计前面0的个数
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {//如果当前数字是0就不操作
                i++;
            } else if (i != 0) {
                //否则，把当前数字放到最前面那个0的位置，然后再把
                //当前位置设为0
                nums[j - i] = nums[j];
                nums[j] = 0;
            }
        }
    }
```
看一下运行结果
![image.png](https://pic.leetcode-cn.com/1605754938-jmWWKA-image.png)


<br>
如果觉得绕，还可以换种写法

```
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //只要不为0就往前挪
            if (nums[j] != 0) {
                //i指向的值和j指向的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }
```

看下运行结果
![image.png](https://pic.leetcode-cn.com/1605756091-hEgwNx-image.png)




<br>

**如果觉得有用就给个赞吧，你的赞是给我最大的鼓励，也是我写作的最大动力**

> 查看更多答案，可扫码关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20200807155236311.png)**”