### 解题思路
类似于走迷宫问题，首先想到的就是回溯算法，不同的是，在这里需要判断是否对应相应的字符串。
这题有两个难点：
1.如何回溯
2.如何不重复使用同一个单元格

对应这两个问题：
1.对于每一个位置用4个判断语句，分别尝试往上下左右更新，层层递归，每次更新成功要判断是否走完了整个字符串，如果走完了就直接结束，如果不能走完，返回false，回溯到上一个点。
2.利用一个初始为0的dp[][]数组记录访问过的位置，根据前一步的dp数组值，每成功匹配一项+1。每次尝试访问更新前，需要先判断数组值是否为0，不为0说明访问过，不走。
**这里需要注意的是：如果此路不通，需要将该点的dp值置0，否则会造成重复。**

*另外，在没有代码提示功能的时候，很容易写错的点：*
*注意正确的写法是word.length()  而不是word.length*



### 代码

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0 || word==null){
            return false;
        }
        int h = board.length;
        int w = board[0].length;
        int[][] dp = new int[h][w];
        int k = 0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(board[i][j]==word.charAt(k)){
                    dp[i][j]++;
                    if(k==word.length()-1 || updateAround(i,j,k+1,board,dp,word)){
                        return true;
                    }
                }
            }
        }
        return false;  
    }

    public boolean updateAround(int i,int j,int k,char[][] board,int[][] dp,String word){
        //往右更新
        if(j+1<board[0].length && dp[i][j+1]==0 && board[i][j+1]==word.charAt(k)){
            dp[i][j+1] = dp[i][j]+1;
            if(k==word.length()-1 || updateAround(i,j+1,k+1,board,dp,word)){
                return true;
            }     
        }
        //往下更新
        if(i+1<board.length && dp[i+1][j]==0 && board[i+1][j]==word.charAt(k)){
            dp[i+1][j] = dp[i][j]+1;
            if(k==word.length()-1 || updateAround(i+1,j,k+1,board,dp,word)){
                return true;
            }  
        }
        //往左更新
        if(j-1>=0 && dp[i][j-1]==0 && board[i][j-1]==word.charAt(k)){
            dp[i][j-1] = dp[i][j]+1;
            if(k==word.length()-1 || updateAround(i,j-1,k+1,board,dp,word)){
                return true;
            }  
        }
        //往上更新
        if(i-1>=0 && dp[i-1][j]==0 && board[i-1][j]==word.charAt(k)){
            dp[i-1][j] = dp[i][j]+1;
            if(k==word.length()-1 || updateAround(i-1,j,k+1,board,dp,word)){
                 return true;
            }  
        }
        dp[i][j]=0; //走不通！
        return false;
    }

}
```