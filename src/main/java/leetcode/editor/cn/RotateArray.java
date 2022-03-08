//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 734 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//Java：旋转数组
public class RotateArray{
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        // TO TEST
        solution.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    //可以可利用反转的方法解决,很方便,思路是:
    //先反转一下整个数组
    //然后反转前k个数
    //然后在反转后n-k个数
    //原始数组                  : 1 2 3 4 5 6 7
    //反转所有数字后             : 7 6 5 4 3 2 1
    //反转前 k 个数字后          : 5 6 7 4 3 2 1
    //反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }
    //逆序数组起止位置之间的元素
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            //交换数组start位置和end位置的数
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            --end;
            ++start;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //自己的方法,能解,但是繁琐
    public void myRotate(int[] nums, int k) {
        int length = nums.length;
        Body head = new Body(nums[0]);
        Body pre = head;
        for (int i=1;i<length;i++){
            pre.next = new Body(nums[i]);
            pre = pre.next;
        }
        pre.next = head;
        k = k % length;
        for (int i=0;i<length -k;i++){
            head = head.next;
        }

        for (int i=0;i<length;i++){
            nums[i] = head.num;
            head = head.next;
        }
        System.out.println(nums);
    }
    class Body{
        private int num;
        private Body next;

        public Body(int num){
            this.num = num;
        }

        public int getNum()
        {
            return num;
        }

        public void setNum(int num)
        {
            this.num = num;
        }

        public Body getNext()
        {
            return next;
        }

        public void setNext(Body next)
        {
            this.next = next;
        }
    }
}