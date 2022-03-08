### 解题思路
解法1： 暴力蛮算。

解法2： 稍作优化，用O(M+N)空间存储每行或每列是否该reset状态。

解法3： 基于解法2。进一步优化，不用额外O(M+N)空间存储每行或每列是否该reset状态。而是借用第一行第一列来存储。第一行和第一列本身是否reset用两个变量存储就行了。

### 代码

```cpp
// Brute force
class Solution1 {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) {
            return;
        }

        int M = matrix.size();
        int N = matrix[0].size();
        vector<vector<int>> copy = matrix;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rowContainsZero(i, copy) || colContainsZero(j, copy)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

private:
    bool rowContainsZero(int i, vector<vector<int>>& copy) {
        for (int j = 0; j < copy[i].size(); j++) {
            if (copy[i][j] == 0) {
                return true;
            }
        }

        return false;
    }

    bool colContainsZero(int j, vector<vector<int>>& copy) {
        for (int i = 0; i < copy.size(); i++) {
            if (copy[i][j] == 0) {
                return true;
            }
        }

        return false;
    }
};

class Solution2 {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) {
            return;
        }

        int M = matrix.size();
        int N = matrix[0].size();
        vector<bool> rowNeedToSet(M, false);
        vector<bool> colNeedToSet(N, false);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rowNeedToSet[i] = true;
                    colNeedToSet[j] = true;
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rowNeedToSet[i] || colNeedToSet[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
};

// Smartest algorithm, use first row and first col as the space used in Solution 2.
class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if (matrix.empty() || matrix[0].empty()) {
            return;
        }

        int M = matrix.size();
        int N = matrix[0].size();

        bool needSetFirstCol = false;
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) {
                needSetFirstCol = true;
                break;
            }
        }

        bool needSetFirstRow = false;
        for (int j = 0; j < N; j++) {
            if (matrix[0][j] == 0) {
                needSetFirstRow = true;
                break;
            }
        }

        // Mark rest or not state to first row and first col
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (needSetFirstCol) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }

        if (needSetFirstRow) {
            for (int j = 0; j < N; j++) {
                matrix[0][j] = 0;
            }
        }
    }
};
```