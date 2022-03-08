#### 方法一：深度优先搜索

**思路与算法**

设函数 ![\text{check}(i,j,k) ](./p__text{check}_i,_j,_k__.png)  判断以网格的 *(i, j)* 位置出发，能否搜索到单词 ![\text{word}\[k..\] ](./p__text{word}_k..__.png) ，其中 ![\text{word}\[k..\] ](./p__text{word}_k..__.png)  表示字符串 ![\text{word} ](./p__text{word}_.png)  从第 *k* 个字符开始的后缀子串。如果能搜索到，则返回 ![\text{true} ](./p__text{true}_.png) ，反之返回  ![\text{false} ](./p__text{false}_.png) 。函数 ![\text{check}(i,j,k) ](./p__text{check}_i,_j,_k__.png)  的执行步骤如下：
- 如果 ![\text{board}\[i\]\[j\]\neqs\[k\] ](./p__text{board}_i__j__neq_s_k__.png) ，当前字符不匹配，直接返回 ![\text{false} ](./p__text{false}_.png) 。
- 如果当前已经访问到字符串的末尾，且对应字符依然匹配，此时直接返回 ![\text{true} ](./p__text{true}_.png) 。
- 否则，遍历当前位置的所有相邻位置。如果从某个相邻位置出发，能够搜索到子串 ![\text{word}\[k+1..\] ](./p__text{word}_k+1..__.png) ，则返回 ![\text{true} ](./p__text{true}_.png) ，否则返回 ![\text{false} ](./p__text{false}_.png) 。

这样，我们对每一个位置 *(i,j)* 都调用函数 ![\text{check}(i,j,0) ](./p__text{check}_i,_j,_0__.png)  进行检查：只要有一处返回 ![\text{true} ](./p__text{true}_.png) ，就说明网格中能够找到相应的单词，否则说明不能找到。

为了防止重复遍历相同的位置，需要额外维护一个与 ![\text{board} ](./p__text{board}_.png)  等大的 ![\text{visited} ](./p__text{visited}_.png)  数组，用于标识每个位置是否被访问过。每次遍历相邻位置时，需要跳过已经被访问的位置。

**代码**

```C++ [sol1-C++]
class Solution {
public:
    bool check(vector<vector<char>>& board, vector<vector<int>>& visited, int i, int j, string& s, int k) {
        if (board[i][j] != s[k]) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        vector<pair<int, int>> directions{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        bool result = false;
        for (const auto& dir: directions) {
            int newi = i + dir.first, newj = j + dir.second;
            if (newi >= 0 && newi < board.size() && newj >= 0 && newj < board[0].size()) {
                if (!visited[newi][newj]) {
                    bool flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    bool exist(vector<vector<char>>& board, string word) {
        int h = board.size(), w = board[0].size();
        vector<vector<int>> visited(h, vector<int>(w));
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bool flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
};
```

```Java [sol1-Java]
class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
```

```Python [sol1-Python3]
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        def check(i: int, j: int, k: int) -> bool:
            if board[i][j] != word[k]:
                return False
            if k == len(word) - 1:
                return True
            
            visited.add((i, j))
            result = False
            for di, dj in directions:
                newi, newj = i + di, j + dj
                if 0 <= newi < len(board) and 0 <= newj < len(board[0]):
                    if (newi, newj) not in visited:
                        if check(newi, newj, k + 1):
                            result = True
                            break
            
            visited.remove((i, j))
            return result

        h, w = len(board), len(board[0])
        visited = set()
        for i in range(h):
            for j in range(w):
                if check(i, j, 0):
                    return True
        
        return False
```

```JavaScript [sol1-JavaScript]
var exist = function(board, word) {
    const h = board.length, w = board[0].length;
    const directions = [[0, 1], [0, -1], [1, 0], [-1, 0]];
    const visited = new Array(h);
    for (let i = 0; i < visited.length; ++i) {
        visited[i] = new Array(w).fill(false);
    }
    const check = (i, j, s, k) => {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length - 1) {
            return true;
        }
        visited[i][j] = true;
        let result = false;
        for (const [dx, dy] of directions) {
            let newi = i + dx, newj = j + dy;
            if (newi >= 0 && newi < h && newj >= 0 && newj < w) {
                if (!visited[newi][newj]) {
                    const flag = check(newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    for (let i = 0; i < h; i++) {
        for (let j = 0; j < w; j++) {
            const flag = check(i, j, word, 0);
            if (flag) {
                return true;
            }
        }
    }
    return false;
};
```

```Golang [sol1-Golang]
type pair struct{ x, y int }

var directions = []pair{{-1, 0}, {1, 0}, {0, -1}, {0, 1}} // 上下左右

func exist(board [][]byte, word string) bool {
	h, w := len(board), len(board[0])
	vis := make([][]bool, h)
	for i := range vis {
		vis[i] = make([]bool, w)
	}
	var check func(i, j, k int) bool
	check = func(i, j, k int) bool {
		if board[i][j] != word[k] { // 剪枝：当前字符不匹配
			return false
		}
		if k == len(word)-1 { // 单词存在于网格中
			return true
		}
		vis[i][j] = true
		defer func() { vis[i][j] = false }() // 回溯时还原已访问的单元格
		for _, dir := range directions {
			if newI, newJ := i+dir.x, j+dir.y; 0 <= newI && newI < h && 0 <= newJ && newJ < w && !vis[newI][newJ] {
				if check(newI, newJ, k+1) {
					return true
				}
			}
		}
		return false
	}
	for i, row := range board {
		for j := range row {
			if check(i, j, 0) {
				return true
			}
		}
	}
	return false
}
```

```C [sol1-C]
int directions[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

bool check(char** board, int boardSize, int boardColSize, int** visited, int i, int j, char* s, int sSize, int k) {
    if (board[i][j] != s[k]) {
        return false;
    } else if (k == sSize - 1) {
        return true;
    }
    visited[i][j] = true;
    bool result = false;
    for (int sel = 0; sel < 4; sel++) {
        int newi = i + directions[sel][0], newj = j + directions[sel][1];
        if (newi >= 0 && newi < boardSize && newj >= 0 && newj < boardColSize) {
            if (!visited[newi][newj]) {
                bool flag = check(board, boardSize, boardColSize, visited, newi, newj, s, sSize, k + 1);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
    }
    visited[i][j] = false;
    return result;
}

bool exist(char** board, int boardSize, int* boardColSize, char* word) {
    int** visited = malloc(sizeof(int*) * boardSize);
    for (int i = 0; i < boardSize; i++) {
        visited[i] = malloc(sizeof(int) * boardColSize[0]);
        memset(visited[i], 0, sizeof(int) * boardColSize[0]);
    }
    int wordSize = strlen(word);
    for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardColSize[0]; j++) {
            bool flag = check(board, boardSize, boardColSize[0], visited, i, j, word, wordSize, 0);
            if (flag) {
                return true;
            }
        }
    }
    return false;
}
```

**复杂度分析**

- 时间复杂度：一个非常宽松的上界为 ![O(MN\cdot3^L) ](./p__O_MN_cdot_3^L__.png) ，其中 *M, N* 为网格的长度与宽度，*L* 为字符串 ![\text{word} ](./p__text{word}_.png)  的长度。在每次调用函数 ![\text{check} ](./p__text{check}_.png)  时，除了第一次可以进入 *4* 个分支以外，其余时间我们最多会进入 *3* 个分支（因为每个位置只能使用一次，所以走过来的分支没法走回去）。由于单词长为 *L*，故 ![\text{check(i,j,0)} ](./p__text{check_i,_j,_0_}_.png)  的时间复杂度为 *O(3^L)*，而我们要执行 *O(MN)* 次检查。然而，由于剪枝的存在，我们在遇到不匹配或已访问的字符时会提前退出，终止递归流程。因此，实际的时间复杂度会远远小于 ![\Theta(MN\cdot3^L) ](./p__Theta_MN_cdot_3^L__.png) 。

- 空间复杂度：*O(MN)*。我们额外开辟了 *O(MN)* 的 ![\text{visited} ](./p__text{visited}_.png)  数组，同时栈的深度最大为 ![O(\min(L,MN)) ](./p__O_min_L,_MN___.png) 。