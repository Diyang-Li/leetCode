import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Diyang Li
 * It has another way to optimize...
 * @create 2022-06-06 9:56 PM
 */
public class _77_Combinations {
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> result = new LinkedList<>();

    public static void backtracking(int n, int k, int startPoint) {
        if (path.size() == k) {
            //new LinkedList?
            // path is a reference type, if just add the path into the result directly,
            // path in result will change along the static path, so we have to make a new instance;
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startPoint; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i+1);
            path.removeLast(); // LinkedList has the method to remove the last element
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = combine(n, k);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }
}
