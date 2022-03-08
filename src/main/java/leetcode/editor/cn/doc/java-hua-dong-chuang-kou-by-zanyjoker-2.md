### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : small) {
            set.add(num);
        }

        int l = 0, r = 0, minLen = Integer.MAX_VALUE, minL = Integer.MAX_VALUE;
        
        
        while(r < big.length) {

            if(map.containsKey(big[r])) {
                map.put(big[r], map.get(big[r]) + 1);
                r++;
                continue;
            }
            if(set.contains(big[r])) {
                set.remove(big[r]);
                map.put(big[r], map.getOrDefault(big[r], 0) + 1);
            }

            if(set.size() == 0) {
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minL = l;
                }
                
                if(minLen == small.length) {
                    break;
                }
                while(!map.containsKey(big[l]) || map.get(big[l]) > 1) {
                    if(map.containsKey(big[l])) {
                        map.put(big[l], map.get(big[l]) - 1);
                    }
                    l++;
                }
                
                if(r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minL = l;
                }
                set.add(big[l]);
                map.remove(big[l]);
                l++;
            }
            r++;
        }

        if(minL == Integer.MAX_VALUE) {
            return new int[0];
        }

        int[] ans = new int[2];
        ans[0] = minL;
        ans[1] = minLen + minL - 1;
        return ans;
    }
}
```