package slidingWindow;

/**
 * @author Diyang Li
 * @create 2022-07-19 10:50 AM
 */
public class _1248_CountNumberofNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int[] nums, int k){
        int left = 0;
        int right = 0;
        int rest = 0;

        while(right < nums.length){
            int r = nums[right];
            if(r % 2 != 0) k--;

            // when odd numbers > k
            while(k < 0){
                int l = nums[left];
                if(l % 2 != 0) k++;
                left++;
            }
            rest += (right - left + 1);
            right++;
        }

        return rest;
    }

}
