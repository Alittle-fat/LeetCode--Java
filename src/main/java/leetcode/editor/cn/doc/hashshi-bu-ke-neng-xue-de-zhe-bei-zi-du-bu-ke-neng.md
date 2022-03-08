### 解题思路
![image.png](https://pic.leetcode-cn.com/3da0cbb078a4b1d8c1bef0b76a9d16000fe5ae87d136900f9cb74384135b7f0c-image.png)
还是那句话，没有数组解决不了的事。思路如下：
1. 遍历数组，字母+1，数字-1。创建新数组dif记录 字母-数字的差值
2. dif里的数据含义，举个栗子。[1,2,3,2,1,0]，两种情况，（1）0代表从开始到dif[i] = 0这个位置，字母数字刚好抵消掉 （2） 相同状态，就比如i=0的1和i=4的1代表着（0,4]中的字母数字刚好抵消掉，所以这两个位置dif值没有变化。
3. 遍历dif，计算步骤2中提到的两种情况子数组长度，记录最大的长度和开始结束位置。
4. 输出开始 结束位置的子串即可。

PS： 步骤2需要注意的是，我用start_index这个数组记录dif中元素第一次出现的位置：start_index[dif[i]] = i,之后再出现只需要计算长度即可。但问在于dif[i]不总是为正！！！！怎么办？？ 最后想到中小白处理， 那就给dif所有的元素加上array的长度，就能保证dif全部为正。但此时，步骤2中提到的情况（1），就成了dif[i] == arraySize，从0到i的位置，字母数字刚好抵消。
### 代码

```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** findLongestSubarray(char** array, int arraySize, int* returnSize)
{
    if (arraySize <= 1) {
        returnSize = 0;
        return NULL;
    }
    int dif[100500] = {0};   // 字母数量 与 数字数量 的差值
    if ((array[0][0] <= 'Z' && array[0][0] >= 'A') || (array[0][0] <= 'z' && array[0][0] >= 'a')) {
        dif[0] = 1;
    } else {
        dif[0] = -1;
    }
    int q = 1;
    for (int i = 1; i < arraySize; i++) {
        if ((array[i][0] <= 'Z' && array[i][0] >= 'A') || (array[i][0] <= 'z' && array[i][0] >= 'a')) {
            dif[i] = dif[i - 1] + 1;
            q++;
        } else {
            dif[i] = dif[i - 1] - 1;
            q++;
        }
    }

    for (int i = 0; i < q; i++) {
        dif[i] += arraySize;
    }

    int start = -1;
    int end = -1;
    int max = 0;
    int start_index[100500] = {0};
    memset(start_index, -1, 100500 * sizeof(int));
    for (int i = 0; i < q; i++) {
        if (dif[i] == arraySize) {
            if ((i + 1) >= max) {
                max = i + 1;
                start = 0;
                end = i;
            }
            continue;
        }
        if (start_index[dif[i]] == -1) {
            start_index[dif[i]] = i;
        } else {
            if ((i - start_index[dif[i]]) > max) {
                max = i - start_index[dif[i]];
                start = start_index[dif[i]] + 1;
                end = i;
            }
        }
    }
    if (start == -1 && end == -1) {
        *returnSize = 0;
        return NULL;
    }
    *returnSize = end - start + 1;
    char** ret = (char**)malloc((*returnSize) * sizeof(char*));
    for (int i = 0; i < *returnSize; i++) {
        ret[i] = (char*)malloc(20);
        strcpy(ret[i], array[start + i]);
    }
    return ret;
}
```