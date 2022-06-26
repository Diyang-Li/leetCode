package array;

/**
 * @author Diyang Li
 * @create 2022-06-26 4:09 PM
 */
public class _80_RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        //1. ascending
        //2. in-place
        //3. most appear twice
        //4. keep same order

        // counting the appearance numbers
        int time = 1;
        int i = 0; // slow pointer

        // fast pointer
        for(int j = 1; j < nums.length; j++){
            if(nums[i] == nums[j] && time < 2){
                i++;
                nums[i] = nums[j];
                time ++;
            }else if(nums[i] == nums[j] && time >= 2){
                continue;
            }else if(nums[i] < nums[j]){
                i++;
                nums[i] = nums[j];
                time = 1;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int[] nums4 = {0,0,1,1,1,1,2,3,3};
        int[] nums3 = {0,0,0};
        System.out.println(removeDuplicates(nums4));
    }
}
