package array;

/**
 * @author Diyang Li
 * @create 2022-06-26 4:03 PM
 */
public class _26_RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        //1. ascending order
        //2. no more result space
        //3. same order
        //4. return k numbers

        // solution: use fast pointer j and slow pointer i
        // since it's a ascending, so the number next to the current number mush larger than the current number

        int i = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] > nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int[] nums3 = {0};

        System.out.println(removeDuplicates(nums3));
    }
}
