### 解题思路
首先是细节‘0’不是0

最开始自己想的是，递归，我可以肯定自己的递归写的很漂亮，但是这道题求得是结果数量，而不是列举所有结果，所以递归必定超时，不过这种写出新类型递归还是很开心的。

其实这题就是一个动态规划，只不过容易把人绕晕而已。首先给vec[0]赋值，然后做下去砍断vec[i]和vec[i-1]什么关系就好了。关键是要理解好动态规划数组的含义，所以vec[i]就是0-》i的所有数可以译码的结果数。

### 代码

```cpp
class Solution {
public:
    int numDecodings(string s) {
        vector<int> vec(s.size());
        if(s[0]=='0')
            return 0;
        vec[0] =1;
        //vec[-1]=1;
        for(int i=1 ; i<s.size() ;i++ ){
            if(s[i]=='0'  ){
                if (s[i-1]=='0' || s[i-1]>'2')
                    vec[i] = 0;
                else
                    {
                        if(i>1){
                            vec[i]=vec[i-2];
                        }
                        else{
                            vec[i]=1;
                        }
                    }
            }
            else if( s[i-1] == '0' || s[i-1] >'2' || (s[i-1]=='2' && s[i] > '6') ){
                vec[ i ] = vec[i-1];
            }
            else{
                if(i-2>=0)
                    vec[i] = vec[i-1]+ vec[i-2];
                else
                    vec[i] = vec[i-1]+1;
            }
        }
        return vec[s.size()-1];
    }
};
/*class Solution {
public:
    int numDecodings(string s) {
        //0前必须有1或者2，遇到1或者2时，还要看后面能否组成双位数，其他的就智能译作自身
        return dfs(s,0);
    }

    int dfs( string & s , int idx ){//idx之前的分法已经确定
        if(idx == s.size()){
            return 1;
        }
        if( s[idx] == '0' ){
            return 0;
        }
        if(  idx + 1 == s.size() || s[idx] > '2'   ){
            return dfs(s,idx+1);
        }
        if( s[idx] == '1' ){
            return dfs(s,idx+1)+dfs(s,idx+2);
        }
        return s[idx+1] < '7' ?  dfs(s,idx+1) + dfs(s,idx+2)  :  dfs(s,idx+1);
    }
};*/
```