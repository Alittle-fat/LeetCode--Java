### 解题思路
![QQ截图20200804213755.png](https://pic.leetcode-cn.com/78bd0d1e961d4dcb1f5175e15c074ac661905d93514b93fe77bad11a612e08eb-QQ%E6%88%AA%E5%9B%BE20200804213755.png)

和73题撞题了
步骤如下：
1、矩阵中某个数为零，则将该数所在行的第一个数置零，所在列的第一个数置零，即matrix[0][j] = matrix[i][0] = 0
2、遍历上面处理过的首行和首列的每个元素（[0][0]位置除外），如果为零，则说明该行或者该列应该都为零，将该行或列全部元素置零
3、第一步操作会让首行首列是否有零这个信息损失掉，因为首行首列被用来存储其他信息了，会改变他们的取值，所以再定义两个变量row0,col0记录首行首列是否有零，最后根据row0和col0来处理首行和首列自己
### 代码

```java
class Solution {
    public void setZeroes(int[][] matrix) {
  int m=matrix.length;
        int n=matrix[0].length;
        boolean row0=false,cow0=false;
        //因为第一行和第一列被征用了，所以原始状态需要提前记录下来
        for(int i=0;i<m;i++){//首列
            if(matrix[i][0]==0) cow0=true;
        }
        for(int j=0;j<n;j++){//首行
            if(matrix[0][j]==0) row0=true;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){//第i行，第j列都需要置零，所以把首列第i行和首行第j列标记上
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0) matrix[i]=new int[n];
        }
        for(int j=1;j<n;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<m;i++) matrix[i][j]=0;
            }
        }
        if(row0) matrix[0]=new int[n];
        if(cow0){
            for(int i=0;i<m;i++) matrix[i][0]=0;
        }
    }
}
```