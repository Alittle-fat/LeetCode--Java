//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 838 👎 0

package leetcode.editor.cn;
//Java：移动零
public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // TO TEST
        solution.moveZeroes(new int[]{0,1,0,3,12});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
    public void moveZeroes(int[] nums) {
        if(null == nums || nums.length == 0){
            return;
        }

        //思路1: 只要部不为0就往前移动,剩下的都是0
        /*int index = 0;//记录已经移动的数据个数
        for (int i=0;i<nums.length;i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length){
            nums[index++] = 0;
        }*/

        //思路2: 双指针
        int i = 0;
        for (int j=0;j<nums.length;j++){
            if (nums[j] == 0){
                ++i;
            }else if(i != 0){
                //将当前位置的值向前移动i个位置,并将当前位置的值置为0
                nums[j-i] = nums[j];
                nums[j] = 0;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //有点繁琐
    /*
    public void moveZeroes(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-count;i++){
            if (0 == nums[i]){
                ++count;
                move(nums,i,nums.length-count);
                nums[nums.length-count] = 0;
                //由于数组整体向前移动了,故新的检测点-1
                --i;
            }
        }
        //System.out.println(nums);
    }
    private void move(int[] nums,int start,int end){
        for (int i=start;i<end;i++){
            nums[i] = nums[i+1];
        }
    }
     */
}