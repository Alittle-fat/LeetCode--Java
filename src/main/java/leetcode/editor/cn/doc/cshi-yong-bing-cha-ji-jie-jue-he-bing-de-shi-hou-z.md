- 使用并查集来保存名字，频数。
- 合并的时候需要把字典序靠后的名字suffix的频数加到字典序考前的名字prefix的频数中，同时把它的suffix的root名字设置为prefix
- 使用哈希表插入的过多，可以尝试在初始化的时候直接操作哈希表而不同初始化之后再操作哈希表

```c++
class UF      //定义并查集
{
public:
    unordered_map<string,string> m;   //保存每个名字对应的的root名字，即字典序最靠前的那个名字
    unordered_map<string,int> n;      //保存每个名字对应出现的频数
    UF(vector<int>& num,vector<string>& str)
    {
        for(int i=0;i<str.size();i++)
        {
            m[str[i]]=str[i];
            n[str[i]]=num[i];
        }
    }

    string findRoot(string s)    //查找名字的root名字
    {
        return s==m[s] ? s : m[s]=findRoot(m[s]);
    }

    void unite(string x,string y)   //合并两个名字，把字典序靠后的名字root名字置为字典序靠前的名字，同时把它的频数加到前面的名字上
    {
        if(m.count(x)==0 || m.count(y)==0) //如果并查集中没有这两个名字，那就直接跳过
            return;
        string a=findRoot(x);
        string b=findRoot(y);
        if(a==b)
            return;
        if(a<b)
        {
            n[a]+=n[b];
            m[b]=a;
        }
        else
        {
            n[b]+=n[a];
            m[a]=b;
        }
    }
};
class Solution {
public:
    vector<string> trulyMostPopular(vector<string>& names, vector<string>& synonyms)
    {
        vector<int> num;         //保存频数
        vector<string> str;      //保存名字
        for(auto i:names)
        {
            int l=i.find('(');
            int r=i.size()-1;
            int n=r-l-1;
            num.push_back(stoi(i.substr(l+1,n)));
            str.push_back(i.substr(0,i.size()-2-n));
        }
        
        UF t(num,str);         //使用名字和频数初始化并查集
        
        vector<pair<string,string>> res;  //保存要合并的名字
        for(string i:synonyms)
        {
            int n=i.find(',');
            string prefix=i.substr(1,n-1);
            string suffix=i.substr(n+1,i.size()-n-2);
            res.push_back({prefix,suffix});
        }
        
        for(auto i:res)    //合并名字
        {
            t.unite(i.first,i.second);
        }
        
        unordered_map<string,int> aaa;  //保存每个名字对应的的root名字和对应的频数
        for(auto i:t.m)
        {
            if(aaa.count(t.findRoot(i.first))==1)  //已经保存过，那么直接跳过
                continue;
            aaa[t.findRoot(i.first)]=t.n[t.findRoot(i.first)]; //保存root名字及对应的频数           
        }
        
        vector<string> ans;   //最后输出结果
        for(auto i:aaa)
        {
            string tmp=i.first+"("+to_string(t.n[i.first])+")";
            ans.push_back(tmp);
        }
        return ans;
    }
};
```

