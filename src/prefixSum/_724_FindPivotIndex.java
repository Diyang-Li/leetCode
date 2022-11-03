package prefixSum;

/**
 * @author Diyang Li
 * @create 2022-10-04 12:43 PM
 */
public class _724_FindPivotIndex {

    // use template, slow
    public int pivotIndex(int[] nums) {

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        int left= 0;
        int right = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                left = 0;
            }else{
                left = sum[i-1];
            }
            right = sum[nums.length-1] - sum[i];
            if(right == left){
                return i;
            }
        }
        return -1;
    }
    // offical solution, faster
    public int pivotIndex1(int[] nums) {
        int leftSum = 0;
        int sum = 0;
        for(int i: nums){
            sum+=i;
        }

        for(int i = 0; i < nums.length; i++){
            int rightSum = sum-leftSum-nums[i];
            if(rightSum == leftSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.err.println("EXIT 1");
        System.exit(1);
    }
}
