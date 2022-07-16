package slidingWindow;

/**
 * @author Diyang Li
 * @create 2022-07-16 6:53 PM
 */
public class _209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        // 1.left right two pointers
        int left = 0;
        int right = 0;
        // 2. curSum to record the sum of nums between left and right
        int curSum = 0;
        // 3. minLen
        int minLen = 0;
        // 4. while loop
        while(right <= nums.length - 1){
            // 1. cal sum between left and right = curSum
            curSum += nums[right];
            // while(curSum >= target):
            while(curSum >= target){
                // if (compare(right - left + 1) with minLen )
                if((right - left + 1) < minLen || minLen ==0){
                    minLen = right - left + 1;
                }
                // curSum - left value
                curSum -= nums[left];
                // left++
                left++;
            }

            right++;
        }

        return minLen;
    }
}
