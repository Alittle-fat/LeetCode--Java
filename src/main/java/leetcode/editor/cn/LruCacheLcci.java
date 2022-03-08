//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 28 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

//Java：LRU缓存
public class LruCacheLcci{
    public static void main(String[] args) {
        LRUCache solution = new LruCacheLcci().new LRUCache(2);
        // TO TEST

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class LRUCache {

        int capacity;
        HashMap<Integer,Integer> map;
        LinkedList<Integer> list;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new LinkedList<>();
        }

        public int get(int key) {
            if(map.containsKey(key)){
                list.remove((Integer) key);
                list.addLast(key);
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            //包含,更新map的值
            if (map.containsKey(key)){
                map.put(key,value);
                list.remove((Integer)key);
                list.addLast(key);
                return;
            }
            //饱和,删除最久未使用的
            if(list.size() == capacity){
                map.remove(list.removeFirst());
                map.put(key,value);
                list.addLast(key);
            }else{
                //不饱和,直接存
                map.put(key,value);
                list.addLast(key);
            }
        }
    }

    /**
     * 用LinkedHashMap
     */
    class newLRUCache {
        //使用LinkedHashMap:再HashMap的基础上增加了双向链表，输出顺序为插入的顺序
        LinkedHashMap<Integer,Integer> map;
        int capacity;

        public newLRUCache(int capacity) {
            // 初始大小，0.75是装载因子，true是表示按照访问时间排序
            map = new LinkedHashMap<>(capacity+1,0.75f,true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)) {return -1;};
            return map.get(key);
        }

        public void put(int key, int value) {
            map.put(key,value);
            if(map.size()>capacity){
                Iterator itor = map.keySet().iterator();
                map.remove(itor.next());
            }
        }
    }



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//leetcode submit region end(Prohibit modification and deletion)

}
