package dynamicProgramming;

/**
 * @author Diyang Li
 * @create 2022-09-19 11:23 AM
 */
public class _55_JumpGame {
    /**
     * Greedy:faster
     * O(n) just one loop
     * @param nums
     * @return
     */

    public boolean canJump1(int[] nums) {
        int len = nums.length;
        int last = len-1;
        for(int i = len-1; i >= 0; i--){
            if(last - i <= nums[i]){
                last = i;
            }
        }

        return last == 0;
    }
    /**
     * Dynamic Programming
     * O(n^2) because for j and for i
     * @param nums
     * @return
     */
    // function: f[j] = f[i] && (j-i) <= nums[i]
    // j: the stone wanna to jump
    // i : last stone 0 <= i < j
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] f = new boolean[len];

        //Initial Condition
        f[0] = true;

        for(int j = 1; j < len; j++){
            f[j] = false;
            for(int i = 0; i < j; i++){
                if(f[i] && j-i <= nums[i]){
                    f[j] = true;
                    break;
                }
            }
        }
        return f[len-1];
    }

}
