package slidingWindow;

import java.util.Arrays;

/**
 * @author Diyang Li
 * @create 2022-07-20 9:35 AM
 */
public class _480_SlidingWindowMedian {

    //Another method is to use priority queue!!!



    // [1,3,-1,-3,5,3,6,7]
    // before sliding window: win{1, 3, -1}, use Arrays.sort() to sort
    // the lenght of the rest is(len - k + 1);
    // left is the position that we wanna to inert the mid num
    // firs loop --> {-1, 1, 3} --> res[1,0,0,0...] --> nums[left] = 1 so remove the 1 out of the win and keep other nums' order
    // win: {-1, 3, 0} --> at the end of the first loop: win{-1, 3, -3}
    // in the second loop, we use insert sort: because -1 3 has already sorted in the last loop,
    // so we just need to find the right position of -3, which is O(n) but O(n^2)
    // in the end the time: O((n -k +1)*k): firs part is loop the nums, second part is sort win(len is k)
    //                space: O(n - k + 1): the array to store the result
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int[] win = new int[k];
        double[] res = new double[nums.length - k + 1];

        while (right < k){
            win[right] = nums[right];
            right++;
        }
        right--;
        Arrays.sort(win);

        while (right < nums.length) {
            sort(win);
            res[left] =  ((double)win[k/2] + (double)win[(k-1)/2])/2;
            remove(win, nums[left]);
            right++;
            left++;
            if (right < nums.length) win[k-1] = nums[right];
        }
        return res;

    }

    // use insert sort,
    public static void sort(int[] nums) {
        if (nums.length == 0) return;
        int p = nums.length-1;
        while (p > 0 && nums[p] < nums[p-1]){
            int temp = nums[p];
            nums[p] = nums[p-1];
            nums[p-1] = temp;
            p--;
        }
    }

    public static void  remove(int[] win, int val){
        int p = 0;
        while(win[p] != val){
            p++;
        }
        while (p < win.length-1){
            win[p] = win[p+1];
            p++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2147483647,2147483647};
        int k1 = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums1, k1)));
    }
}
