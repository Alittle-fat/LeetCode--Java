### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public String[] permutation(String S) {
        char[] arrS = S.toCharArray();
        boolean[] used = new boolean[S.length()];
        LinkedList<String> result = new LinkedList<>();
        dfs(arrS, used, new StringBuilder(), result);
        return result.toArray(new String[0]);
    }

    private void dfs(char[] data, boolean[] used, StringBuilder stringBuilder, LinkedList<String> result) {
        if (stringBuilder.length() == data.length) {
            result.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < data.length; i++) {
            if (used[i] == true) {
                continue;
            }
            stringBuilder.append(data[i]);
            used[i] = true;
            dfs(data, used, stringBuilder, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            used[i] = false;
        }
    }
}
```