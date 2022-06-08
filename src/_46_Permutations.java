import java.util.*;

/**
 * @author Diyang Li
 * @create 2022-06-07 9:50 PM
 */
public class _46_Permutations {

    static List<List<Integer>> result = new ArrayList<>(); // record result
    static LinkedList<Integer> path = new LinkedList<>(); //record current permute elements
    static boolean[] used;// record wich num has been used, since each number can only be used once in one permute

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        //initialize the used arraylist
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private static void permuteHelper(int[] nums) {
        // one permute formed, then add to result linkedlist
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //each i means [1,....] [2,....] [3, ....] ... [len-1, ....]
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // if the num is not used, can be added to the apath
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
