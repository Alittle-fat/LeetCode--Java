# 思路

本题与[79. 单词搜索](https://leetcode-cn.com/problems/word-search/)，[题解](https://leetcode-cn.com/problems/word-search/solution/shen-du-you-xian-sou-suo-suan-fa-by-jaso-4c6h/)完全一样。

实质是二维图上的搜索问题。
典型的DFS求解。

图搜索算法中，为了防止重复搜索同一个节点，通常设置去重复数组vis。
**vis[x][y] = 0，表示未搜索过。vis[x][y] = 1，表示搜索过。**

在board中寻找一个board[i][j] == word[0]的位置，作为搜索算法的起点。
再从(i,j)开始，设置vis[i][j] = 1，遍历其四周位置，寻找一个board[nx][ny] == word[1]的位置，递归搜索.
再从(nx,ny)开始，设置vis[nx][ny] = 1，遍历其四周位置，寻找一个board[nx'][ny'] == word[2]的位置，递归搜索.
......
直到，到某个位置(s,t)，word的最后一个字符word[len(word) - 1]被找到。

如此能找到word。

**注意**：word最后一个字符被找到后，就无需再递归搜索了。一方面是为了减枝，另一方面是处理board和word只有一个字符的情况。

```cpp
class Solution {
public:
    int m;
    int n;
    bool exist(vector<vector<char>>& board, string word) {
        if(!(m = board.size()) || !(n=board[0].size())){
            return false;
        }
        vector<vector<int>> vis(m,vector<int>(n,0));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word[0]){
                    bool ret = dfs(board,vis,word,0,i,j);
                    if(ret){
                        return ret;
                    }
                }
            }
        }
        return false;
    }

    bool dfs(const vector<vector<char>>& board,
            vector<vector<int>>& vis,
            const string& word,
            int cur,
            int x,int y
            ){
                if(cur+1 == word.size()){
                    return true;
                }
                if(word[cur] != board[x][y]){
                    return false;
                }

                vis[x][y] = 1;
                const int dx[4] = {1,-1,0,0};
                const int dy[4] = {0,0,1,-1};
                for(int i=0;i<4;i++){
                    const int nx = x+dx[i];
                    const int ny = y+dy[i];
                    if(in_board(nx,ny) 
                        && !vis[nx][ny] 
                        && (cur+1 < word.size() && word[cur+1] == board[nx][ny])){
                            bool ret = dfs(board,vis,word,cur+1,nx,ny);
                            if(ret){
                                return true;
                            }
                        }
                }
                vis[x][y] = 0;
                return false;
            }

    bool in_board(int x,int y){
        return 0 <= x && x < m && 0 <= y && y < n;
    }
};
```