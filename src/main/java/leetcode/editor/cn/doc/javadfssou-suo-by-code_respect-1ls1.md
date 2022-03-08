### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0;i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][]board,char[] word,int i,int j,int k){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || word[k] != board[i][j]){
            return false;
        }
        if(k == word.length - 1){
            return true;
        }
        //本次不可重复的标记点
        board[i][j] = '\0';
        boolean res = dfs(board,word,i + 1,j,k + 1) || dfs(board,word,i,j + 1,k + 1)
        || dfs(board,word,i - 1,j,k + 1) || dfs(board,word,i,j - 1,k + 1);
        //判断结束还得回溯,进行下一次判断
        board[i][j] = word[k];
        return res;
    }
}
```