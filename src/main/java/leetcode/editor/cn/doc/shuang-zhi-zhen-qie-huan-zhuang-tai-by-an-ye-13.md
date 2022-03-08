1、双指针初始化到a的首部，b的尾部，向中间移动
2、遇到不相等元素，记录断点位置，从断点开始切换为向a的中间元素移动，即剩下的步骤都在a上进行
3、如果2中又遇到不相等元素，则从断点开始 切换为向b的中间元素移动，即剩下的步骤都在b上进行
4、若3中又遇到不相等元素，则不能构成回文串；若双指针相遇则能构成回文串

```
class Solution {
public:
    // 模式0：i在a上往右遍历，j在b上往左遍历
    // 模式1：i在a上往右遍历，j在a上往左遍历
    // 模式2：i在b上往右遍历，j在b上往左遍历
    bool check(string &a,string &b)
    {
        int change=0,a_loca,b_loca;
        for(int i=0,j=a.size()-1;i<j;i++,j--)
        {
            // 出现不等的情况，切换到模式1，同时记录当前位置，后续可能用到模式2
            if(change==0&&a[i]!=b[j])
            {
                change=1;   //切换到模式1
                i--;        //for循环默认自加，这里i,j都往后退一步
                j++;        
                a_loca=i;   //记录不相等的位置
                b_loca=j;
            }
            // 模式0不满足，尝试模式1，即假设断点发生在b_loca位置，判断aprefix + bsuffix
            else if(change==1&&a[i]!=a[j])
            {
                i=a_loca;   //重回第一个不相等的位置
                j=b_loca;
                change=2;
            }
            // 模式1不满足，尝试模式2，即假设断点发生在a_loca位置，判断bprefix + asuffix
            else if(change==2&&b[i]!=b[j]) return false;    //3种模式都尝试完，依然不满足，返回false
        }
        return true;
    }
    
    bool checkPalindromeFormation(string a, string b) {
        //两种开始方式
        bool ans1=check(a,b);
        if(ans1) return true;
        bool ans2=check(b,a);
        if(ans2) return true;
        else return false;
        
    }
};
```
