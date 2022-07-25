package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Diyang Li
 * @create 2022-07-25 11:15 AM
 */
public class _220_ContainsDuplicateIII {
    /**
     * 桶的解法相当凝练，不过有一点可以啰嗦两句。不知道有没有人疑惑，在比较id - 1和id + 1这两个相邻桶时，只比较了一个元素，这足够吗？
     * 哈希表的行为不是会用新元素覆盖旧元素，一个桶里有多个元素怎么办？
     *
     * 其实是覆盖根本不会发生...因为一旦要覆盖，就说明存在两个元素同属一个桶，直接返回true了。
     * 这就是题解说的“一个桶内至多只会有一个元素”——数组输入里当然可以有多个元素属于同一个桶，但是一旦出现一对，算法就结束了
     * @param nums
     * @param k
     * @param t
     * @return
     */

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || k < 0){
            return false;
        }

        // take nums = [1,5,9,1,5,9], k = 2, t = 3 for instance
        // put 0~3 in 0 bucket, because any number in this bucket could satisfied the requirment: abs(nums[i] - nums[j]) <= t
        // for negative number: -4~-1 in the bucket -1, [-4, -1] --> [-3, 0]/4 = 0 --> 0-1 --> bucket -1
        long w = t+1;

        int left = 0;
        int right = 0;
        // key is id, value is the number in numbers
        Map<Long, Long> map = new HashMap<>();

        while(right < nums.length){
            long id = getId(nums[right], w);
            // in range of abs(i - j) <= k, find number in same bucket, definitely abs(nums[i] - nums[j]) <= t, return true;
            if(map.containsKey(id)){
                return true;
            }
            // find in neighbor
            if(map.containsKey(id + 1) && Math.abs(map.get(id+1) - nums[right])<=t){
                return true;
            }

            if(map.containsKey(id - 1) && Math.abs(map.get(id -1) - nums[right]) <= t){
                return true;
            }

            map.put(id, (long)nums[right]);

            if(right - left >= k){
                map.remove(getId(nums[left], w));
                left++;
            }

            right++;
        }
        return false;
    }

    //calculate the id
    public static long getId(long x, long w){

        if(x >= 0){
            return x/w;
        }

        return (x + 1)/w - 1;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,-2,2};
        int k = 2;
        int t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
