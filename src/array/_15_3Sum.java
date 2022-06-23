package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diyang Li
 * @create 2022-06-21 10:52 AM
 */
public class _15_3Sum {
    /**
     * 1. the index care different in the same triplet
     * 2. the triplets in List cannot be same
     * 3. nums[i] + nums[j] + nums[k] == 0
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //sort the nums to avoid repeat elements
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            // avoid triples repeating
            if(i>0 && nums[i] == nums[i-1]) continue;
            // the sum of another two numbers
            int sum = 0 - nums[i];
            // the method like 167
            int low = i+1, high =nums.length-1;

            while(low < high){
                if(nums[low] + nums[high] == sum){
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // avoid elements repeating in triples
                    // if no low < hight, example nums4 and 5 will out bound exception
                    while(low<high && nums[low+1] == nums[low]) low++;
                    while(low < high && nums[high-1] == nums[high]) high--;
                    low++;
                    high--;
                }else if(nums[low] + nums[high] > sum){
                    high--;
                }else{
                    low++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,0,1,2,-1,-4};
        int[] nums2 = {};
        int[] nums3 = {0};
        int[] nums4 = {0,0,0};
        int[] nums5 = {-2,1,1};

        List<List<Integer>> lists = threeSum(nums5);
        System.out.println(lists);
    }
}
